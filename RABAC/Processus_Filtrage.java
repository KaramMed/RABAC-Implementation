package RABAC;

import java.util.ArrayList;
import java.util.HashMap;

public class Processus_Filtrage {
	
	// methode de filtrage 1
	public static boolean FPatient(Session s,Objet o) {
		// on recupere les attributs de l'objet
		ArrayList<OAttribut> oa = o.getOatt();
		// on recupere l'utilisateur de session
		Utilisateur u = s.getUtilisateur();
		// on cherche l attirbut recordof
		for ( OAttribut oo : oa ) {
			if(oo.getNom().equals("recordof")){
				// on recupere l utilisateur de cet objet
				Utilisateur u2 = oo.getUtilisateur();
				//System.out.println(u.getNom()+" : "+u2.getNom());
				// on compare les deux utilisateurs ( avec celui de session ) en utilisant leurs noms
				if (u.getNom().equals(u2.getNom()) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	// methode de filtrage 2
	public static boolean FAutorized(Session s,Objet o) {
		int conditions = 0 ; // compteur de conditions
		// on recupere l'utilisateur de session
		Utilisateur u = s.getUtilisateur();
		// on cherche l attribut proj
		for ( OAttribut oo : o.getOatt() ) {
			if(oo.getNom().equals("oproj")){
				// on va voir le range de l'attribut ( son projet )
				String projet = oo.getRange();
				// on recupere le projet de l'utilisateur
				for (UAttribut uu : u.getUatt() ) {
					if(uu.getNom().equals("uproj")) {
						// on prends son range ( son projet )
						String projet2 = uu.getRange();
						// on compare les deux projets 
						if(projet.equals(projet2)) {
							conditions++;
						}
					}
				}
			}
		}
		// on va voir le temps de session
		float temps = s.getTemps();
		if (temps>=8.00 && temps<=17.00) {
			conditions++;
		}
		// on voit la certification de l'appareil de session
		if (s.certifie()) {
			conditions++;
		}
		// on evalue les conditions
		if (conditions==3) {
			return true;
		}
		return false;
	}
	
	// methode TargetFiltre
	public static ArrayList<Boolean> TargetFilter(Session s,Objet o) {
		ArrayList<Boolean> filtre = new ArrayList<Boolean>();
		// on voit le type de l'objet ( patient )
		for ( OAttribut oa : o.getOatt()) {
			if (oa.getNom().equals("type")) {
				// on extrait le type ( le range )
				String type = oa.getRange();
				switch(type) {
				case "PatientRecord" : filtre.add(FPatient(s,o));
					break;
				case "AuthorizedDoc" : filtre.add(FAutorized(s,o));
					break;
				}
			}
		}
		return filtre;
	}
	
	
	// methode avail_session_perms : prends session actuelle et retourne ceux autorisés
	// un mapping entre l'objet et ses permissions autorisés
	public static HashMap<Objet,ArrayList<Boolean>> avail_session_perms(Session s){
		HashMap<Objet,ArrayList<Boolean>> map = new HashMap<Objet,ArrayList<Boolean>>();
		// on extrait les objets de session
		ArrayList<Objet> objets = new ArrayList<Objet>();
		// la session a un role , les roles on des permissions sur des objets
		Role r = s.getRole();
		for ( Permission p : r.permissions ) {
			objets.add(p.getObjet());
		}
		
		// pour chaque objet on execute TaregtFilre
		for(Objet o : objets) {
			System.out.println(" Pour l'objet "+o.getNom());
			map.put(o,TargetFilter(s,o));
			System.out.println(TargetFilter(s,o));
		}
		return map;
	}
}

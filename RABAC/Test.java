package RABAC;

import java.util.ArrayList;
import java.util.Collections;

import RABAC.Objet;
import RABAC.Permission;
import RABAC.Role;
import RABAC.Session;
import RABAC.Utilisateur;

public class Test {
	
	public static void main(String[] args) {
		
		// definition utilisateurs et objets
		Utilisateur u1 = new Utilisateur("docteur1");
		Objet o1 = new Objet("patient1");
		
		// definition des roles
		Role Doctor = new Role("Doctor");
		Role VisitDoctor = new Role("VisitDoctor");
		
		
		// definition des attributs
		UAttribut doctorof = new UAttribut();
		doctorof.setNom("doctorof");
		UAttribut uproj = new UAttribut();
		uproj.setNom("uproj");
		OAttribut type = new OAttribut();
		type.setNom("type");
		OAttribut recordof = new OAttribut();
		recordof.setNom("recordof");
		OAttribut oproj = new OAttribut();
		oproj.setNom("oproj");
		
		
		// attribution des attributs
		u1.ajoutUatt(doctorof);
		u1.ajoutUatt(uproj);
		
		o1.ajoutOatt(type);
		o1.ajoutOatt(recordof);
		o1.ajoutOatt(oproj);
		
		
		
		// utilisateur a comme patient p1 et projet projet1
		doctorof.setObjet(o1);
		uproj.setRange("projet1");
		
		// le patient a comme type PatientRecord , comme docteur u1 et projet projet1
		type.setRange("AuthorizedDoc");
		recordof.setUtilisateur(u1);
		oproj.setRange("projet1");
		
		
		// definir la permission de lecture pour patient1
		Permission p1 = new Permission();
		p1.setAction("lecture");
		p1.setObjet(o1);
		
		// attribuer permissions aux roles
		VisitDoctor.ajouterPermission(p1);
		VisitDoctor.ajouterUtilisateur(u1);
		
		
		
		// creation de session
		Session s1 = new Session();
		s1.setRole(VisitDoctor);
		s1.setUtilisateur(u1);
		// le temps d acces est 15h et le device non certifié
		s1.setAppareil(false);
		s1.setTemps(15);
		Processus_Filtrage.avail_session_perms(s1);
	}

}

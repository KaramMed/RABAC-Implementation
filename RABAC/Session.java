package RABAC;

public class Session {

 Utilisateur utilisateur;
 Role role;
 float temps;
 boolean appareil;
 
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

public float getTemps() {
	return temps;
}
public void setTemps(float temps) {
	this.temps = temps;
}

public boolean isAppareil() {
	return appareil;
}
public void setAppareil(boolean appareil) {
	this.appareil = appareil;
}
// voir si l appareil est certifié
public boolean certifie() {
	return appareil;
}
// ouvrir session
public void ouvrir() {
  // montrer les roles de chaque utilisateur
  role = utilisateur.role;
  System.out.println(" l'utilisateur "+utilisateur.getNom()+" appartient au role "+role.nom);
  // Montrer les attributs 
  System.out.println(" Les Attributs :");
  for ( UAttribut u : utilisateur.getUatt()) {
	  System.out.println(" "+u.nom);
  }
  // montrer ses permissions
  System.out.println(" Les permissions :");
  for ( Permission p : role.permissions ) {
	  System.out.println(" "+p.getAction()+" => "+p.objet.nom);
  }
}

 
 
}

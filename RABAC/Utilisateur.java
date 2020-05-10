package RABAC;

import java.util.ArrayList;

public class Utilisateur {

 String nom;
 Role role;
 ArrayList<UAttribut> uatt = new ArrayList<UAttribut>();

 public Utilisateur(String a) {
	 nom = a;
 }
 
 public String getNom() {
	 return nom;
 }
 
 public void setRole(Role r) {
	 role = r;
 }

public ArrayList<UAttribut> getUatt() {
	return uatt;
}

// ajout attribut
public void ajoutUatt(UAttribut u) {
	uatt.add(u);
}

public Role getRole() {
	return role;
}

public void setNom(String nom) {
	this.nom = nom;
}
 
 
}

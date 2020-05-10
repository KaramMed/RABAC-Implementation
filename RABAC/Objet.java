package RABAC;

import java.util.ArrayList;

public class Objet {

 String nom;
 ArrayList<OAttribut> oatt = new ArrayList<OAttribut>();
 
 public Objet(String a) {
	 nom = a;
 }
 
//ajout attribut
public void ajoutOatt(OAttribut u) {
	oatt.add(u);
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public ArrayList<OAttribut> getOatt() {
	return oatt;
}

public void setOatt(ArrayList<OAttribut> oatt) {
	this.oatt = oatt;
}


 
}

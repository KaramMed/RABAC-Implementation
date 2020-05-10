package RABAC;

import java.util.ArrayList;

public class Role {

 String nom;
 ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
 ArrayList<Permission> permissions = new ArrayList<Permission>();
 
 
 public Role(String a) {
	 nom = a;
 }
 
 public void ajouterUtilisateur(Utilisateur u) {
	 utilisateurs.add(u);
	 u.setRole(this);
 }
 
 public void ajouterPermission(Permission p) {
	 permissions.add(p);
 }

}

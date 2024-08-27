package tn.essat.nlpchatbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricule_admin;
    private String username;
    private String password;
    private String GSM;
    private String email;
    private String nom;
    private String prenom;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(long matriculeAdmin, String username, String password, String gSM, String email, String nom,
			String prenom) {
		super();
		this.matricule_admin = matriculeAdmin;
		this.username = username;
		this.password = password;
		GSM = gSM;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}
	public long getMatricule_admin() {
		return matricule_admin;
	}
	public void setMatricule_admin(long matricule_admin) {
		this.matricule_admin = matricule_admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGSM() {
		return GSM;
	}
	public void setGSM(String gSM) {
		GSM = gSM;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}

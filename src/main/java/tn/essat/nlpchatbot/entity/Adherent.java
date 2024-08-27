package tn.essat.nlpchatbot.entity;

import jakarta.persistence.*;
import tn.essat.nlpchatbot.entity.Enum.Role;

@Entity
@Table(name = "Adherent")
public class Adherent {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long matricule;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private String CIN;
	private String genre;
	private String RIB_RIP;
	private String matricule_fiscale;
	private String date_de_naissance;
	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	public Adherent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adherent(long matricule, String nom, String prenom, String username, String password, String CIN, String genre, String RIB_RIP, String matricule_fiscale, String date_de_naissance, String email, Role role) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.CIN = CIN;
		this.genre = genre;
		this.RIB_RIP = RIB_RIP;
		this.matricule_fiscale = matricule_fiscale;
		this.date_de_naissance = date_de_naissance;
		this.email = email;
		this.role = role;
	}

	public long getMatricule() {
		return matricule;
	}

	public void setMatricule(long matricule) {
		this.matricule = matricule;
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

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRIB_RIP() {
		return RIB_RIP;
	}

	public void setRIB_RIP(String RIB_RIP) {
		this.RIB_RIP = RIB_RIP;
	}

	public String getMatricule_fiscale() {
		return matricule_fiscale;
	}

	public void setMatricule_fiscale(String matricule_fiscale) {
		this.matricule_fiscale = matricule_fiscale;
	}

	public String getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(String date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

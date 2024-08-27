package tn.essat.nlpchatbot.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "malade_en_charge")
public class MaladeEnCharge{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String CIN;
    private String prenom;
    private String qualite;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name ="matricule_adherent",foreignKey = @ForeignKey (name="fk_adherent"),nullable =false,columnDefinition ="FOREIGN KEY  matricule_adherent REFERNCES Adherent(matricule) ON DELETE CASCADE ON UPDATE CASCADE")
    private Adherent adherent;
    
	public MaladeEnCharge(long id, String nom, String cIN, String prenom, String qualite, Adherent adherent) {
		super();
		this.id = id;
		this.nom = nom;
		CIN = cIN;
		this.prenom = prenom;
		this.qualite = qualite;
		this.adherent = adherent;
	}

	public MaladeEnCharge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getQualite() {
		return qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

}

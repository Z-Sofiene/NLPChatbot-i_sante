package tn.essat.nlpchatbot.entity;

import jakarta.persistence.*;
import tn.essat.nlpchatbot.entity.Enum.StatusReclamation;

@Entity
@Table(name = "reclamation")
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reclamation;
    /*
    @Enumerated(EnumType.STRING)
    private Type type_reclamation;
     */
	@Enumerated(EnumType.STRING)
    private StatusReclamation statut;
    private String textReclamation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
	    name ="id_Consultation",
	    foreignKey = @ForeignKey (name="fk_consultation"),
	    nullable =false,
	    columnDefinition ="FOREIGN KEY  id_consultation REFERNCES Dossier(numConsultation) ON DELETE CASCADE ON UPDATE CASCADE"
    )
    private Dossier dossier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
    	    name ="id_admin",
    	    foreignKey = @ForeignKey (name="fk_admin"),
    	    nullable =false,
    	    columnDefinition ="FOREIGN KEY  id_admin REFERNCES Admin(matricule_admin) ON DELETE CASCADE ON UPDATE CASCADE"
        )
    private Admin admin;

	public Reclamation(long id_reclamation, StatusReclamation statut, String textReclamation, Dossier dossier,
                       Admin admin) {
		super();
		this.id_reclamation = id_reclamation;
		this.statut = statut;
		this.textReclamation = textReclamation;
		this.dossier = dossier;
		this.admin = admin;
	}

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdReclamation() {
		return id_reclamation;
	}

	public void setid_reclamation(long id_reclamation) {
		this.id_reclamation = id_reclamation;
	}

	public StatusReclamation getStatut() {
		return statut;
	}

	public void setStatut(StatusReclamation statut) {
		this.statut = statut;
	}

	public String getTextReclamation() {
		return textReclamation;
	}

	public void setTextReclamation(String textReclamation) {
		this.textReclamation = textReclamation;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}

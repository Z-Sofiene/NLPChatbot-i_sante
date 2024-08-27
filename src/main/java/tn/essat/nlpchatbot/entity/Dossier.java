package tn.essat.nlpchatbot.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num_consultation;
    private boolean pharmacie;
    private boolean radio;
    private boolean analyses;
    private boolean autre;
    private long ticketModerateur;
    private float resteAPayer_consultation;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(
	    name ="malade_en_charge_id",
	    foreignKey = @ForeignKey (name="fk_maladeencharge"),
	    nullable =false,
	    columnDefinition ="FOREIGN KEY malade_en_charge_id REFERNCES MaladeEnCharge (id) ON DELETE CASCADE ON UPDATE CASCADE"
	    )
    private MaladeEnCharge malade_en_charge;

    
    public Dossier(long num_consultation, boolean pharmacie, boolean radio, boolean analyses,
			boolean autre, long ticketModerateur, float resteAPayer, MaladeEnCharge malade_en_charge) {
		super();
		this.num_consultation = num_consultation;
		this.pharmacie = pharmacie;
		this.radio = radio;
		this.analyses = analyses;
		this.autre = autre;
		this.ticketModerateur = ticketModerateur;
		this.resteAPayer_consultation = resteAPayer;
		this.malade_en_charge = malade_en_charge;
	}

	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNumConsultation() {
		return num_consultation;
	}

	public void setNumConsultation(long num_consultation) {
		this.num_consultation = num_consultation;
	}

	public boolean isPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(boolean pharmacie) {
		this.pharmacie = pharmacie;
	}

	public boolean isRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		this.radio = radio;
	}

	public boolean isAnalyses() {
		return analyses;
	}

	public void setAnalyses(boolean analyses) {
		this.analyses = analyses;
	}

	public boolean isAutre() {
		return autre;
	}

	public void setAutre(boolean autre) {
		this.autre = autre;
	}

	public long getTicketModerateur() {
		return ticketModerateur;
	}

	public void setTicketModerateur(long ticketModerateur) {
		this.ticketModerateur = ticketModerateur;
	}

	public float getResteAPayer_consultation() {
		return resteAPayer_consultation;
	}

	public void setResteAPayer_consultation(float resteAPayer_consultation) {
		this.resteAPayer_consultation = resteAPayer_consultation;
	}

	public MaladeEnCharge getMalade_en_charge() {
		return malade_en_charge;
	}

	public void setMalade_en_charge(MaladeEnCharge malade_en_charge) {
		this.malade_en_charge = malade_en_charge;
	}
}

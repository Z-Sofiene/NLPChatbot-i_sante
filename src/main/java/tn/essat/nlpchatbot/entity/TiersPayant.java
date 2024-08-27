package tn.essat.nlpchatbot.entity;


import jakarta.persistence.*;

@Entity
@Table (name ="tiers_payant")
public class TiersPayant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num_transaction;
    private float resteAPayer_transaction; 
    private float totaleOrdonnace;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "consultation_id",
        foreignKey = @ForeignKey(name = "fk_dossier"),
        nullable = false,
        columnDefinition = "FOREIGN KEY (consultation_id) REFERENCES Dossier (num_consultation) ON DELETE CASCADE ON UPDATE CASCADE"
    )
    private Dossier dossier;
	public TiersPayant() {
		super();
	}
	public TiersPayant(long num_transaction, float resteAPayer_transaction, float totaleOrdonnace, String type,
			Dossier dossier) {
		super();
		this.num_transaction = num_transaction;
		this.resteAPayer_transaction = resteAPayer_transaction;
		this.totaleOrdonnace = totaleOrdonnace;
		this.type = type;
		this.dossier = dossier;
	}
	public long getNumTransaction() {
		return num_transaction;
	}
	public void setNumTransaction(long num_transaction) {
		this.num_transaction = num_transaction;
	}
	public float getResteAPayer_transaction() {
		return resteAPayer_transaction;
	}
	public void setResteAPayer_transaction(float resteAPayer_transaction) {
		this.resteAPayer_transaction = resteAPayer_transaction;
	}
	public float getTotaleOrdonnace() {
		return totaleOrdonnace;
	}
	public void setTotaleOrdonnace(float totaleOrdonnace) {
		this.totaleOrdonnace = totaleOrdonnace;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
    
}

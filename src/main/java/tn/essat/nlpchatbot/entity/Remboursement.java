package tn.essat.nlpchatbot.entity;

import jakarta.persistence.*;

@Entity
public class Remboursement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_remboursement;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name ="num_transaction",
			foreignKey = @ForeignKey (name="fk_tierspayant"),
			nullable =false,
			columnDefinition ="FOREIGN KEY  num_transaction REFERNCES Tiers_Payant(numTransaction) ON DELETE CASCADE ON UPDATE CASCADE"
			)
	private TiersPayant tiers_payant;
    private float totalRemboursement;
    private boolean decision;
    private String dateDecision;
	public Remboursement(long id_remboursement, TiersPayant tiers_payant, float totalRemboursement, boolean decision,
			String dateDecision) {
		super();
		this.id_remboursement = id_remboursement;
		this.tiers_payant = tiers_payant;
		this.totalRemboursement = totalRemboursement;
		this.decision = decision;
		this.dateDecision = dateDecision;
	}
	public Remboursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdRemboursement() {
		return id_remboursement;
	}
	public void setIdRemboursement(long id_remboursement) {
		this.id_remboursement = id_remboursement;
	}
	public TiersPayant getTiers_payant() {
		return tiers_payant;
	}
	public void setTiers_payant(TiersPayant tiers_payant) {
		this.tiers_payant = tiers_payant;
	}
	public float getTotalRemboursement() {
		return totalRemboursement;
	}
	public void setTotalRemboursement(float totalRemboursement) {
		this.totalRemboursement = totalRemboursement;
	}
	public boolean isDecision() {
		return decision;
	}
	public void setDecision(boolean decision) {
		this.decision = decision;
	}
	public String getDateDecision() {
		return dateDecision;
	}
	public void setDateDecision(String dateDecision) {
		this.dateDecision = dateDecision;
	}
   
}

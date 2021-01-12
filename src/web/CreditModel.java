package web;

public class CreditModel {
	
	private Double capital;
	private Double taux;
	private int duree;
	private Double mensualite;
	public CreditModel() {

	}
	public CreditModel(Double capital, Double taux, int duree, Double mensualite) {
		super();
		this.capital = capital;
		this.taux = taux;
		this.duree = duree;
		this.mensualite = mensualite;
	}
	public Double getCapital() {
		return capital;
	}
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Double getMensualite() {
		return mensualite;
	}
	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}
	
}


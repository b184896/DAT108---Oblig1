package oppg2;

public class Ansatt {
	private String fornavn;
	private String etternavn;
	private Kjonn kjonn;
	private String stilling;
	private int aarslonn;
	
	public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarslonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public String getKjonn() {
		return kjonn.toString();
	}
	
	public int getAarslonn() {
		return aarslonn;
	}
	public void setAarslonn(int nyLonn) {
		this.aarslonn = nyLonn;
	}
	
	@Override
	public String toString() {
		return "Fornavn = " + fornavn + " Etternavn = " + etternavn + " Kjonn = " + kjonn.toString() + " Stilling = " + stilling + " Årslønn = " + aarslonn;
	}
}

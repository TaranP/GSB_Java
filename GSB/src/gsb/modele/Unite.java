package gsb.modele;

public class Unite {
	protected String codeUnit;
	protected String nom;
	/**
	 * @param codeUnit
	 * @param nom
	 */
	
	public Unite(String codeUnit, String nom) {
		this.codeUnit = codeUnit;
		this.nom = nom;
	}
	public String getCodeUnit() {
		return codeUnit;
	}
	public void setCodeUnit(String codeUnit) {
		this.codeUnit = codeUnit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}

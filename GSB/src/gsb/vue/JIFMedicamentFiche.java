package gsb.vue;

import gsb.modele.Medicament;

public class JIFMedicamentFiche extends JIFMedicamentCons {

	private static final long serialVersionUID = 1L;

	public JIFMedicamentFiche(Medicament unMedicament) {
		super();
		this.remplirText(unMedicament);

	}
	
}


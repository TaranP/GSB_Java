package gsb.tests;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

public class MedicamentServiceTest {
	
	public static void main(String[] args) {
		Medicament unMedicament = MedicamentService.rechercherMedicament("BITALV");
		System.out.println(unMedicament.getDepotLegal());
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getComposition());
		System.out.println(unMedicament.getEffets());
		System.out.println(unMedicament.getContreIndication());
		System.out.println(unMedicament.getPrixEchantillon());
		System.out.println(unMedicament.getCodeFamille());
		
	}
	
}

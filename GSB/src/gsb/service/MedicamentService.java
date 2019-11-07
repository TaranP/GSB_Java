package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	
	public static Medicament rechercherMedicament(String depotLegal){
		Medicament unMedicament = null;
		try{
		if (depotLegal==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		unMedicament = MedicamentDao.rechercher(depotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}

}

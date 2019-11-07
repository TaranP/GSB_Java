package gsb.modele.dao;

import gsb.modele.Medicament;
import gsb.modele.Famille;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MedicamentDao {
	
	public static Medicament rechercher(String depotLegal){
		Famille uneFamille = null;
		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				uneFamille = FamilleDao.rechercher(reqSelection.getString(1));
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), uneFamille);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDICAMENT where DEPOTLEGAL ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	public static ArrayList<Medicament> retournerCollectionDesMedicaments(){
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
		    collectionDesMedicaments.add(MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}
	
	public static HashMap<String,Medicament> retournerDictionnaireDesMedicaments(){
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
		    diccoDesMedicaments.put(codeMedicament, MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedicaments;
	}
}

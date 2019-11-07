package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Unite;

public class UniteeDao {

	public static Unite rechercher(String matricule){
		Unite unUnite=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Unite where MATRICULE='"+matricule+"'");
		try {
			if (reqSelection.next()) {
				unUnite = new Unite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8), reqSelection.getString(9), reqSelection.getString(10));	
			};
		}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from Unite where MATRICULE='"+matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unUnite;
	}
	
	
	
	
	public static ArrayList<Unite> retournerCollectionDesUnites(){
		ArrayList<Unite> collectionDesUnites = new ArrayList<Unite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from Unite");
		try{
		while (reqSelection.next()) {
			String codeUnite = reqSelection.getString(1);
		    collectionDesUnites.add(UniteDao.rechercher(codeUnite));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesUnites()");
		}
		return collectionDesUnites;
	}
	
	public static HashMap<String,Unite> retournerDictionnaireDesUnites(){
		HashMap<String, Unite> diccoDesUnites = new HashMap<String, Unite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from Unite");
		try{
		while (reqSelection.next()) {
			String codeUnite = reqSelection.getString(1);
		    diccoDesUnites.put(codeUnite, UniteDao.rechercher(codeUnite));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesUnites()");
		}
		return diccoDesUnites;
	}
}

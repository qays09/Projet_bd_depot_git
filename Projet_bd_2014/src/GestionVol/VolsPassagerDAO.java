package GestionVol;

import Main.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VolsPassagerDAO extends DAO<VolsPassagerDAO>{
	
    ResultSet resultat;
	
	public ResultSet ShowList() {
		
		try{
	        Statement requete = cn.createStatement();
			ResultSet resultat = requete.executeQuery("select * from volpassager ....");
			
			return resultat;
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
		}
		return resultat;
			
	}

	public void create(VolsPassagerDAO obj) {

	}

	public void update(VolsPassagerDAO obj) {
	}

	public void delete(VolsPassagerDAO obj) {
		
	}

}

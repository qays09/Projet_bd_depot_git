package GestionReservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Main.DAO;

public class ReservationDAO extends DAO<ReservationDAO>{

    ResultSet resultat;
	
	public ResultSet ShowList() {
		try{
	        Statement requete = cn.createStatement();
			ResultSet resultat = requete.executeQuery("select * from reservation");
			
			return resultat;
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
		}
		return resultat;	
	}

	
	public static void create(Reservation obj) {

		try{
	        cn.setAutoCommit(true);

	        Statement requete = cn.createStatement();	
			
			requete.executeQuery("insert into reservation "
			           + "values('','"+obj.getNumClient()+"',"
			           + "to_date('"+obj.getDateResa()+"','dd-mm-yyyy'))");
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
		}
	}

	
	public void update(ReservationDAO obj) {
		try{
	        Statement requete = cn.createStatement();
			ResultSet resultat = requete.executeQuery("update reservation ....");
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
		}
	}

	
	public void delete(ReservationDAO obj) {
		try{
	        Statement requete = cn.createStatement();
			ResultSet resultat = requete.executeQuery("delete from reservation ....");
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
		}
	}
	
	
	public static ResultSet chercherVol(String villeDepart, String villeDestination,
			String dateVolP) {
	    
		try{

	        Statement requete = cn.createStatement();
			ResultSet resultat = requete.executeQuery("select * "
					                                + "from VolsPassager "
					                                + "where Origine ='"+villeDepart+"'"
					                                + "and Destination ='"+villeDestination+"'"
					                                + "and DateVolP = to_date('"+dateVolP+"', 'dd-mm-yyyy')"
					                                + "and Termine ='N'");
			
			return resultat;
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
			return null;	
		}
	}


	@Override
	public void create(ReservationDAO obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public static ResultSet chercherPlaceLibre(int numVol, String dateVolP) {
		try{

	        Statement requete = cn.createStatement();
			ResultSet resultat = requete.executeQuery("select * "
					                                + "from places p ,volspassager v "
					                                + "where v.NumVolP ="+numVol+" "
					                                + "and p.NumAvionP = v.NumAvionP");
			
			return resultat;
			
		}catch(SQLException e){	
			System.out.println("ERROR ! \n Code d'erreur"+e.getErrorCode());
			System.out.println("Message d'erreur : "+e.getMessage());
			return null;	
		}
	}
}

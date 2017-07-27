package fr.lteconsulting;

import java.util.List;

import fr.lteconsulting.dao.ChansonDAO;
import fr.lteconsulting.modele.Chanson;

public class AppTest2 {

	public static void main(String[] args) {
		ChansonDAO dao = new ChansonDAO();
		
		chercherEtAfficherChanson(dao, 5);
		chercherEtAfficherChanson(dao, "sdfv");


	}
	private static void chercherEtAfficherChanson(ChansonDAO dao, int id) {
		Chanson chanson = dao.findById(id);
		if (chanson != null) {
			System.out.println("La chanson " + id + " a été trouvé :");
			chanson.afficher();
		} else {
			System.out.println("La chanson " + id + "n'existe pas");
		}

	}
	
	private static void chercherEtAfficherChanson(ChansonDAO dao, String id) {
		List<Chanson> chansons = dao.findByDisqueId(id);
		if (chansons != null) {
			System.out.println("Les chansons sont" + id);
		} else {
			System.out.println("La chanson " + id + "n'existe pas");
		}

	}

}

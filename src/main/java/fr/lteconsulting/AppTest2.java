package fr.lteconsulting;

import java.util.List;

import fr.lteconsulting.dao.ChansonDAO;
import fr.lteconsulting.modele.Chanson;

public class AppTest2 {

	public static void main(String[] args) {
		ChansonDAO dao = new ChansonDAO();
		
		chercherEtAfficherChanson(dao, 5);
		chercherEtAfficherChanson(dao, "pttd");


	}
	private static void chercherEtAfficherChanson(ChansonDAO dao, int id) {
		Chanson chanson = dao.findById(id);
		if (chanson != null) {
			System.out.println("La chanson " + id + " a été trouvé :");
			chanson.afficher();
		} else {
			System.out.println("La chanson " + id + " n'existe pas");
		}

	}
	
	private static void chercherEtAfficherChanson(ChansonDAO dao, String disqueId) {
		List<Chanson> chansons = dao.findByDisqueId(disqueId);
		if (chansons != null) {
			for(Chanson chanson: chansons)
			{
			System.out.println("Les chansons sont " + chanson.getNom());
			}
		} else {
			System.out.println("La chanson " + disqueId + "n'existe pas");
		}

	}

}

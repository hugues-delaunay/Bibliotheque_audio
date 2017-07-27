package fr.lteconsulting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.dao.DisqueDAO;
import fr.lteconsulting.modele.Disque;

public class ApplicationTest {
	public static void main(String[] args) throws SQLException {
		DisqueDAO dao = new DisqueDAO();

		chercherEtAfficherDisque(dao, "jhds");
		chercherEtAfficherDisque(dao, "ppttdddd");
		AfficherTousDisques(dao);
		AjouterDisques(dao, "sdfv", "J'ai réussi");
		UpdateDisques(dao, "sdfv", "yeahyeah");
		AfficherTousDisques(dao);
		DeleteDisques(dao, "sdfv");
		chercherParNom(dao,"a");

	}

	private static void chercherEtAfficherDisque(DisqueDAO dao, String id) {
		Disque disque = dao.findById(id);
		if (disque != null) {
			System.out.println("Le disque " + id + " a été trouvé :");
			disque.afficher();
		} else {
			System.out.println("Le disque " + id + "n'existe pas");
		}

	}
	
	private static void chercherParNom(DisqueDAO dao, String recherche) {
		List<Disque> search = dao.findByName(recherche);
		if (search != null) {
			System.out.println("Il y a " + search.size() + " disques");
			System.out.println("Les disques contenant "+recherche+ " sont :" +search.toString());
		} else {
			System.out.println("Le disque contenant " + recherche + " n'existe pas");
		}

	}

	private static void AfficherTousDisques(DisqueDAO dao) {
		List<Disque> d = new ArrayList<>();
		d = dao.findAll();

		if (d != null) {
			System.out.println("BIBLIOTHEQUE avec " + d.size() + " disques");
			System.out.println("Les disques suivant ont été trouvé :" + d.toString());

		} else {
			System.out.println("aucun disque");
		}

	}

	private static void AjouterDisques(DisqueDAO dao, String id, String nom) throws SQLException {
		Disque disque = new Disque(id, nom);
		Disque d = dao.add(disque);

		if (d != null) {
			System.out.println("Disque :" + d.toString() + " ajouté");

		} else {
			System.out.println("aucun disque");
		}

	}

	private static void UpdateDisques(DisqueDAO dao, String id, String nom) throws SQLException {
		Disque disque = new Disque(id, nom);
		dao.update(disque);

		if (nom != null) {
			System.out.println("Disque :" + disque.toString() + " modifié");

		} else {
			System.out.println("Pas de modif");
		}

	}

	private static void DeleteDisques(DisqueDAO dao, String id) throws SQLException {
		dao.delete(id);

		if (id != null) {
			System.out.println("Disque :" + id + " effacé");

		} else {
			System.out.println("Pas de modif");
		}

	}
}

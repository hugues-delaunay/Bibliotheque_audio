package fr.lteconsulting.modele;

import java.util.List;

import fr.lteconsulting.dao.DisqueDAO;

public class Bibliotheque {
	DisqueDAO disqueDAO = new DisqueDAO();

	public void ajouterDisque(Disque disque) {
		disqueDAO.add(disque);

	}

	public List<Disque> getDisques() {
		return disqueDAO.findAll();
	}

	public Disque rechercherDisqueParCodeBarre(String id) {
		return disqueDAO.findById(id);
	}

	public List<Disque> rechercherDisqueParNom(String recherche) {

		return disqueDAO.findByName(recherche);
	}

	public void afficher() {
		List<Disque> disques = disqueDAO.findAll();
		System.out.println("BIBLIOTHEQUE avec " + disques.size() + " disques");
		for (Disque disque : disques) {
			disque.afficher();

		}
	}
}

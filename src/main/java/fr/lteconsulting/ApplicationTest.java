package fr.lteconsulting;

import fr.lteconsulting.dao.DisqueDAO;
import fr.lteconsulting.modele.Disque;

public class ApplicationTest
{
	public static void main( String[] args )
	{
		DisqueDAO dao = new DisqueDAO();

		chercherEtAfficherDisque( dao, "pptt" );
		chercherEtAfficherDisque( dao, "ppttdddd" );
	}

	private static void chercherEtAfficherDisque( DisqueDAO dao, String id )
	{
		Disque disque = dao.findById( id );
		if( disque != null )
		{
			System.out.println( "Le disque " + id + " a été trouvé :" );
			disque.afficher();
		}
		else
		{
			System.out.println( "Le disque " + id + "n'existe pas" );
		}
	}
}

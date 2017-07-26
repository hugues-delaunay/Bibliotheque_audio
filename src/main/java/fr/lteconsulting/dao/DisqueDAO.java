package fr.lteconsulting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.lteconsulting.modele.Disque;

public class DisqueDAO
{
	private Connection connection;

	public DisqueDAO()
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bibliotheque_audio", "root", "" );
		}
		catch( ClassNotFoundException e )
		{
			throw new RuntimeException( "Chargement driver failure", e );
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible d'établir une connection avec le SGBD", e );
		}
	}

	public Disque findById( String id )
	{
		try
		{
			String sql = "SELECT * FROM `disques` WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString( 1, id );
			ResultSet resultSet = statement.executeQuery();
			if( resultSet.next() )
			{
				String nom = resultSet.getString( "nom" );
				Disque disque = new Disque( id, nom );
				return disque;
			}
			else
			{
				return null;
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public List<Disque> findAll()
	{
		return null;
	}

	public Disque add( Disque disque )
	{
		return disque;
	}

	public void update( Disque disque )
	{
	}

	public void delete( String id )
	{
	}
}

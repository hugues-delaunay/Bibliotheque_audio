package fr.lteconsulting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.modele.Disque;

public class DisqueDAO {
	private Connection connection;

	public DisqueDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque_audio", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Chargement driver failure", e);
		} catch (SQLException e) {
			throw new RuntimeException("Impossible d'établir une connection avec le SGBD", e);
		}
	}

	public Disque findById(String id) {
		try {
			String sql = "SELECT * FROM `disques` WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String nom = resultSet.getString("nom");
				Disque disque = new Disque(id, nom);
				return disque;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Impossible de réaliser l(es) opération(s)", e);
		}
	}
	
	public List<Disque> findByName(String recherche){
		try{
			String sql = "SELECT * FROM `disques` WHERE LOWER(`nom`) LIKE ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + recherche + "%");
			ResultSet resulset = statement.executeQuery();
			
			List<Disque> d = new ArrayList<>();

			while (resulset.next()) {
				String nom = resulset.getString("nom");
				String id = resulset.getString("id");
				Disque disque = new Disque(id, nom);
				d.add(disque);
			}
			if(d.size() == 0){
				return null;
			}
			return d;
			
		} catch (SQLException e) {
			throw new RuntimeException("Impossible de réaliser l(es) opération(s)", e);
		
		}
	}

	public List<Disque> findAll() {
		try {
			String sql = "SELECT * FROM `disques`";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			List<Disque> d = new ArrayList<>();

			while (resultSet.next()) {
				String nom = resultSet.getString("nom");
				String id = resultSet.getString("id");
				Disque disque = new Disque(id, nom);
				d.add(disque);
			}
			return d;

		} catch (SQLException e) {
			throw new RuntimeException("Impossible de réaliser l(es) opération(s)", e);
		}
	}

	public Disque add(Disque disque) {

		try {
		String sqlQuery = "INSERT INTO `disques`(id,nom) VALUES (?,?)";

		PreparedStatement statement = connection.prepareStatement(sqlQuery);


		statement.setString(1, disque.getCodeBarre());
		statement.setString(2, disque.getNom());

		statement.executeUpdate();

		return disque;
		}
		
		catch (SQLException e) {
			throw new RuntimeException("Impossible de réaliser l(es) opération(s)", e);
		}
		
	}

	public void update(Disque disque) {
		try {
			String sqlQuery = "update `disques` set nom=? where id=?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, disque.getNom());
			statement.setString(2, disque.getCodeBarre());

			statement.executeUpdate();

			}
			
			catch (SQLException e) {
				throw new RuntimeException("Impossible de réaliser l(es) opération(s)", e);
			}
		
	}

	public void delete(String id) {

		try {
			String sqlQuery = "DELETE FROM `disques` where id=?";

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setString(1, id);

		statement.executeUpdate();
		}
		
		catch (SQLException e) {
			throw new RuntimeException("Impossible de réaliser l(es) opération(s)", e);
		}

	}
}

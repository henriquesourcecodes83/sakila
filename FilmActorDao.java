package javawebappconnection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebappconnection.model.ConnectionFactory;
import javawebappconnection.model.FilmActor;

public class FilmActorDao {
	
public List<FilmActor> getFilmActorListById(int id){
		
		List<FilmActor> films = null;
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			System.out.println("Connection ok ...");
			
			String sqlQuery = "SELECT a.first_name, a.last_name, f.title, f.description\r\n"
					+ "FROM actor a\r\n"
					+ "INNER JOIN film_actor fa\r\n"
					+ "USING (actor_id)\r\n"
					+ "INNER JOIN film f\r\n"
					+ "USING (film_id)\r\n"
					+ "WHERE a.actor_id = ?";
			
			PreparedStatement stmt = connection.prepareStatement(sqlQuery);
			
			stmt.setInt(1, id);
			
			ResultSet result = stmt.executeQuery();
			
			films = new ArrayList<>();
			
			while(result.next()) {
				FilmActor film = new FilmActor();
				
				film.setFirst_name(result.getString(1));
				film.setLast_name(result.getString(2));
				film.setTitle(result.getString(3));
				film.setDescription(result.getString(4));
				
				films.add(film);
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return films;
	}
}

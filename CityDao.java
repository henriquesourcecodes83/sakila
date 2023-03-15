package javawebappconnection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebappconnection.model.City;
import javawebappconnection.model.ConnectionFactory;

public class CityDao {
	
public List<City> getCities(){
		
		List<City> cities = null;
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			System.out.println("Connection ok ...");
			
			String sqlQuery = "SELECT city FROM city";
			
			PreparedStatement stmt = connection.prepareStatement(sqlQuery);
			
			ResultSet result = stmt.executeQuery();
			
			cities = new ArrayList<>();
			
			while(result.next()) {
				City city = new City();
				
				city.setCity(result.getString(1));
				
				cities.add(city);
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cities;
	}

}

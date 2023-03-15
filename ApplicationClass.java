package javawebappconnection.main;

import java.util.List;

import javawebappconnection.dao.FilmActorDao;
import javawebappconnection.model.FilmActor;

public class ApplicationClass {
	
	public static void main(String[] args) {
		
		FilmActorDao filmActorDao = new FilmActorDao();
		
		List<FilmActor> films = filmActorDao.getFilmActorListById(2);
		
		for(FilmActor c : films) {
			System.out.print(c.getFirst_name() 
					+ " " + c.getLast_name() 
					+ " " + c.getTitle() 
					+ " " + c.getDescription());
			
			System.out.println();
			
		}				
		
	}
	
}

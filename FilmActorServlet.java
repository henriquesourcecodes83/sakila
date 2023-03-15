package javawebappconnection.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet(urlPatterns = "/filmactor")
public class FilmActorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");		
		writer.println("<header>");
		writer.println("<title></title>");
		writer.println("</header>");
		writer.println("<body>");
		
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
			
			stmt.setInt(1, 1);
			
			ResultSet result = stmt.executeQuery();
			
			writer.println("<table>");
			
			while(result.next()) {
				
				writer.println("<tr>");
				
				writer.println("<td>" + result.getString(1) + "</td>");
				writer.println("<td>" + result.getString(2) + "</td>");
				writer.println("<td>" + result.getString(3) + "</td>");
				writer.println("<td>" + result.getString(4) + "</td>");
				
				writer.println("</tr>");
				
			}
			
			writer.println("</table>");
			
			writer.println("</body>");
			writer.println("</html>");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

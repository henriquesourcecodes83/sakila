<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javawebappconnection.dao.*" %>
<%@ page import="javawebappconnection.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% FilmActorDao filmActorDao = new FilmActorDao(); %>
	
	<% 
	int actor_id = Integer.parseInt(request.getParameter("actor_id"));
	
	List<FilmActor> films = 
			filmActorDao.getFilmActorListById(actor_id); %>
	
	<% %>
	
	<% if(films != null) {
		int count = 1;
	
	%>
	<div class="container"> 
	<table>
		<tr>
		    <th>row_number</th>
			<th>first_name</th>
			<th>last_name</th>
			<th>title</th>
			<th>description</th>
		</tr>
		<% for(FilmActor c : films) { %>
			<tr>
				<td> <% out.println(count); %> </td>
				<td> <% out.println(c.getFirst_name()); %> </td>
				<td> <% out.println(c.getLast_name()); %> </td> 
				<td> <% out.println(c.getTitle()); %> </td> 
				<td> <% out.println(c.getDescription()); %> </td> 
			</tr>			
		<% count++; } %> 
	</table>
	</div>
	<% 
		
	} %>  	
		
</body>
</html>
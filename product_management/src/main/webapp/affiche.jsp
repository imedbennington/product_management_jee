<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="com.dao.*"%>
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/gestioncomm?useTimezone=true&serverTimezone=UTC";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> l = (List<Product>) request.getAttribute("listeP"); %>

<div class="container mt-4">
	<h1>Liste des produits</h1>
	<div class="my-3">
		<a href="addProduit" class="btn btn-primary">Ajouter un nouveau produit</a>
	</div>
	<table border ="1">
		<tr>
			<th>#</th>
			<th>NOM</th>
			<th>PRIX</th>
			<th>QUANTITE</th>
			<th>ACTION</th>
		</tr>
		<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from produit";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("nom") %></td>
<td><%=resultSet.getString("prix") %></td>
<td><%=resultSet.getString("quantite") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
		<%--
		<% for(Product p:l){ %>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getName() %></td>
				<td><%= p.getPrice() %></td>
				<td><%= p.getQuantity() %></td>
				<td><a href="suppProduit?id=<%= p.getId() %>" onclick="return confirm('Voulez vous vraiment supprimer ce produit?')" class="btn btn-danger">Supprimer</a>
				<a href="modifProduit?id=<%= p.getId() %>" class="btn btn-warning">modifier</a>
				</td>
			</tr>
		<% } %>
		 --%>
		
	</table>
</div>
</body>
</body>
</html>
package com.dao;
import java.sql.*;
public class Db_connect {
private static Connection cnx;
public Db_connect() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncomm?useTimezone=true&serverTimezone=UTC","root","");
		System.out.println("connexion �tablie...");
	} catch (ClassNotFoundException e) {
		System.out.println("Probl�me chargement pilote...");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("Probl�me �tablissement connexion...");
		e.printStackTrace();
	}	
}
public static Connection getConnection()
{
	if(cnx==null)
		new Db_connect();
	return cnx;
}
}

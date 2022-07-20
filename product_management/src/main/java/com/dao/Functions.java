package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sun.jdi.connect.spi.Connection;

public class Functions implements Ifnctns{
	//Connection cnx = (Connection) Db_connect.getConnection();
	java.sql.Connection cnx = Db_connect.getConnection();
	@Override
	public void ajoutProduit(Product p) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps=((java.sql.Connection) cnx).prepareStatement("insert into produit(nom,prix,quantite) values(?,?,?)");
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimeProduit(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps = ((java.sql.Connection) cnx).prepareStatement("delete from produit where id=? ");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Product rechercheParId(int id) {
		// TODO Auto-generated method stub
		Product p=null;
		PreparedStatement ps;
		try {
			ps = ((java.sql.Connection) cnx).prepareStatement("select * from produit where id=? ");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				p=new Product(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> getAllProduits() {
		// TODO Auto-generated method stub
		List<Product>liste=new ArrayList<Product>();
		PreparedStatement ps;
		try {
			ps = ((java.sql.Connection) cnx).prepareStatement("select * from produit");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				{
					Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
					liste.add(p);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Product> getProduitParNom(String nom) {
		// TODO Auto-generated method stub
		List<Product>liste=new ArrayList<Product>();
		PreparedStatement ps;
		try {
			ps = ((java.sql.Connection) cnx).prepareStatement("select * from produit where nom like ?");
			ps.setString(1, "%" + nom + "%");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				{
					Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
					liste.add(p);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public void modifProduit(Product p) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps = ((java.sql.Connection) cnx).prepareStatement("update produit set nom=?, prix=?, quantite=? where id=?");
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setInt(4, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}

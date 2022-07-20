package com.dao;
import java.util.List;
public interface Ifnctns {
	public void ajoutProduit(Product p);
	public void supprimeProduit(int id);
	public Product rechercheParId(int id);
	public List<Product> getAllProduits();
	public List<Product> getProduitParNom(String nom);
	public void modifProduit(Product p);
}

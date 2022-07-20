package com.dao;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nom) {
		this.name = nom;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double prix) {
		this.price = prix;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantite) {
		this.quantity = quantite;
	}
	
	public Product(int id, String nom, double prix, int quantite) {
		super();
		this.id = id;
		this.name = nom;
		this.price = prix;
		this.quantity = quantite;
	}
	public Product(String nom, double prix, int quantite) {
		super();
		this.name = nom;
		this.price = prix;
		this.quantity = quantite;
	}
	public Product() {
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + "nom=" + name + ", prix=" + price + ", quantite=" + quantity + "]";
	}
}

package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;
import java.util.List;
/**
 * Servlet implementation class Product_servlet
 */
@WebServlet(urlPatterns = { "/listeProduits", "/addProduit", "/suppProduit", "/modifProduit" })
public class Product_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    Ifnctns management;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		management = new Functions();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = request.getServletPath(); //retourne l'url pattern d'appel de la servlet
		if(path.equals("/listeProduits")) {
			List<Product> liste = management.getAllProduits();
			request.setAttribute("listeP", liste);
			request.getRequestDispatcher("affiche.jsp").forward(request, response);	
		} else if (path.equals("/addProduit")) {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		else if (path.equals("/suppProduit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			management.supprimeProduit(id);
			response.sendRedirect(request.getContextPath()+"/listeProduits");
		}else if (path.equals("/modifProduit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("produit", management.rechercheParId(id));
			request.getRequestDispatcher("update.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String path = request.getServletPath();
		String page="";
		if(path.equals("/addProduit")) {
			try {
				String nom = request.getParameter("nom");
				double prix = Double.parseDouble(request.getParameter("prix"));
				int quantite = Integer.parseInt(request.getParameter("quantite"));
				management.ajoutProduit(new Product(nom, prix, quantite));
				System.out.print("added");
				
				//request.getRequestDispatcher("add_confirm.jsp").forward(request, response);
				//response.sendRedirect("add_confirm.jsp");
			}
			catch(Exception e) {
				page="error.jsp";
			}finally {page="confirm.jsp";}
			RequestDispatcher dd=request.getRequestDispatcher(page);
			dd.forward(request, response);
		}else if (path.equals("/modifProduit")) {
			int id = Integer.parseInt(request.getParameter("id")); 
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			management.modifProduit(new Product(id,nom, prix, quantite));
			response.sendRedirect(request.getContextPath()+"/listeProduits");
		
			
		}
	}
	}


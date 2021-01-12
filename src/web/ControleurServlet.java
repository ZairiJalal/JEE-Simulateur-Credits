package web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetier;
import metier.CreditMetierImpl;


@WebServlet( name="servletCredit" ,  urlPatterns = {"/servletAppelation", "*.php"}  ) 
public class ControleurServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CreditMetier creditMetier;  
	   
	@Override
	public void init() throws ServletException {
		creditMetier= new CreditMetierImpl(); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		  req.setAttribute("creditModel", new CreditModel(0.0, 0.0, 0, 0.0));
		  req.getRequestDispatcher("VueIndexSimulateur.jsp").forward(req, resp);
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // 1 ere etape : on recupere les donnees saisies
		Double capital = Double.parseDouble(req.getParameter("capital"));
		Double taux = Double.parseDouble(req.getParameter("taux"));
		int duree = Integer.parseInt(req.getParameter("duree"));
		  
		//2 eme etape : on doit instancier le model et stocker les donnees saisies dans le model 
		CreditModel creditModel=new CreditModel(); //on instance le constructeur par defaut PUIS on donne les valeurs saisie dans le formulaire  aux attributs de ce modele --> "credit" 
		
		creditModel.setCapital(capital);
		creditModel.setTaux(taux);
		creditModel.setDuree(duree);		
		creditModel.setMensualite(creditMetier.calculMensualite(capital,taux,duree));
		
	    req.setAttribute("creditModel", creditModel);  
	    req.getRequestDispatcher("VueIndexSimulateur.jsp").forward(req, resp); 
		 
	}

}

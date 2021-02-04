package fr.epsi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.service.FactureService;


@WebServlet("/Facture")
public class FactureServlet extends HttpServlet{
	@EJB
	private FactureService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		
		  if(req.getParameter("action").equals("list")) {
			  
			  req.setAttribute("listFacture", service.getFactureList());
			  this.getServletContext().getRequestDispatcher("/WEB-INF/pages/FactureList.jsp").forward(req, resp);
			  
		  }	  
	    }
}

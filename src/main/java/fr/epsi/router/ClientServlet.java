package fr.epsi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.service.ClientService;


@WebServlet("/Client")
public class ClientServlet extends HttpServlet{
	
	@EJB
	private ClientService service;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		
		  if(req.getParameter("action").equals("list")) {
			  
			  req.setAttribute("listClient", service.getClientList());
			  this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ClientList.jsp").forward(req, resp);
			  
		  }else if(req.getParameter("action").equals("create")){
			   
			  this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ClientCreate.jsp").forward(req, resp);
			  
		  } 		  
	    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
				if(req.getParameter("actionPost").equals("formCreate")) {
				 Client c = new Client();
				 c.setNom(req.getParameter("Cnom"));
				 c.setAdresse(req.getParameter("Cadresse"));
			     service.create(c);
		    	 req.setAttribute("listClient", service.getClientList());
		    	 this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ClientList.jsp").forward(req, resp);
		    }
	    }
}

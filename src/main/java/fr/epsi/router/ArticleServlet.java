package fr.epsi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.service.ArticleService;


@WebServlet("/Article")
public class ArticleServlet extends HttpServlet{
	
	@EJB
	private ArticleService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		
		  if(req.getParameter("action").equals("list")) {
			  
			  req.setAttribute("listArticle", service.getArticleList());
			  this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ArticleList.jsp").forward(req, resp);
			  
		  }else if(req.getParameter("action").equals("create")){
			   
			  this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ArticleCreate.jsp").forward(req, resp);
			  
		  } 		  
	    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
				if(req.getParameter("actionPost").equals("formCreate")) {
				 Article a = new Article();
				 a.setnom(req.getParameter("Anom"));
				 a.setprix(Double.parseDouble(req.getParameter("Aprix")));
			     service.create(a);
		    	 req.setAttribute("listArticles", service.getArticleList());
		    	 this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ArticleList.jsp").forward(req, resp);
		    }
	    }

}

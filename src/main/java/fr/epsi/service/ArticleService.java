package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ArticleDaoImpl;
import fr.epsi.entite.Article;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArticleService implements IArticleService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Article> getArticleList() {
		ArticleDaoImpl dao =  new ArticleDaoImpl(em, utx);
		return dao.getListArticles();
	}
	
	public void create(Article a) {
		ArticleDaoImpl dao =  new ArticleDaoImpl(em, utx);
		dao.create(a);
	}
}

package fr.epsi.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.entite.LigneFacture;

public class ArticleDaoImpl implements ArticleDao{

	EntityManager em;
	UserTransaction utx;
	public ArticleDaoImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	public void create(Article a) {
			try {
				utx.begin();
				Article newArticle = new Article();
				newArticle.setnom(a.getnom());
				newArticle.setprix(a.getprix());
				List<LigneFacture> ligneFacture = em.createQuery("select l from LigneFacture where l.id =:id",LigneFacture.class)
											.setParameter("id",a.getligneFactureList())
											.getResultList();
				newArticle.setLigneFactureList(a.getligneFactureList());
			} catch (NotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			em.persist(a);
			try {
				utx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	@EJB
	public List<Article> getListArticles() {
		return em.createQuery("select a from Article a order by a.nom asc", Article.class)
				 .getResultList();
	}
		
	}
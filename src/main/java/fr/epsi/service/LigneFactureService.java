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
import fr.epsi.dao.LigneFactureDaoImpl;
import fr.epsi.entite.Article;
import fr.epsi.entite.LigneFacture;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class LigneFactureService implements ILigneFactureService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;


	public List<LigneFacture> getListLigneFacture() {
		LigneFactureDaoImpl dao = new LigneFactureDaoImpl(em,utx);
		return dao.getListLigneFacture();
	}
}

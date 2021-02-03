package fr.epsi.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Facture;
import fr.epsi.entite.LigneFacture;

public class LigneFactureDaoImpl implements LigneFactureDao {
	
	EntityManager em;
	UserTransaction utx;
	public LigneFactureDaoImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void create(LigneFacture l) {
		try {
			utx.begin();
		} catch (NotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.persist(l);
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
	public List<LigneFacture> getListLigneFacture() {
		return em.createQuery("select l from LigneFacture l order by a.nom asc", LigneFacture.class)
				 .getResultList();
	}

}

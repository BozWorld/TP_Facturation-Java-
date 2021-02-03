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

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.entite.LigneFacture;

public class ClientDaoImpl implements ClientDao {
	
	EntityManager em;
	UserTransaction utx;
	public ClientDaoImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void create(Client c) {
		try {
			utx.begin();
			Client newClient = new Client();
			newClient.setNom(c.getnom());
			newClient.setAdresse(c.getadresse());
		} catch (NotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.persist(c);
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
	public List<Client> getListClient() {
		return em.createQuery("select c from Client c order by a.nom asc", Client.class)
				 .getResultList();
	}

}

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
import fr.epsi.dao.ClientDaoImpl;
import fr.epsi.entite.Article;
import fr.epsi.entite.Client;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientService implements IClientService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Client> getClientList() {
		ClientDaoImpl dao =  new ClientDaoImpl(em, utx);
		return dao.getListClient();
	}
	public void create(Client c) {
		ClientDaoImpl dao =  new ClientDaoImpl(em, utx);
		dao.create(c);
	}
}

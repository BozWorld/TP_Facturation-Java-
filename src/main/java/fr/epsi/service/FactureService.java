package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ClientDaoImpl;
import fr.epsi.dao.FactureDaoImpl;
import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureService implements IFactureService{
	
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;
	
	public List<Facture> getFactureList() {
		FactureDaoImpl dao =  new FactureDaoImpl(em, utx);
		return dao.getListFacture();
	}
	public void create(Facture f) {
		FactureDaoImpl dao =  new FactureDaoImpl(em, utx);
		dao.create(f);
	}

}

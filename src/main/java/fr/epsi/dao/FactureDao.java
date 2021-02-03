package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Article;
import fr.epsi.entite.Facture;

public interface FactureDao {
	
	void create(Facture f);
	
	List<Facture> getListFacture();
}

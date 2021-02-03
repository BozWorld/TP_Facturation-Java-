package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Article;
import fr.epsi.entite.LigneFacture;

public interface LigneFactureDao {
	
	void create(LigneFacture l);
	
	List<LigneFacture> getListLigneFacture();
}

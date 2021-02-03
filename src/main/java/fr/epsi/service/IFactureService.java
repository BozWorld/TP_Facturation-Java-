package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;

public interface IFactureService  {
	List<Facture> getFactureList();
}

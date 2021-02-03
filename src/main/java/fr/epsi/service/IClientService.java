package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;

public interface IClientService {
	
	List<Client> getClientList();
}

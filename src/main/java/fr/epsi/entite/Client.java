package fr.epsi.entite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private String adresse;
	@OneToMany
	@JoinTable(name = "facture")
	private Set<Facture> factureList;
	
	public String getnom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getadresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse ;
	}
	
	public Set<Facture> getFactureList() {
		return factureList;
	}
	
	public void setFactureList(Set<Facture> factureList) {
		this.factureList = factureList;
	}
}

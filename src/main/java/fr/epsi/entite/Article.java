package fr.epsi.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private double prix;
	
	@OneToMany
	private List<LigneFacture> ligneFactureList;

	
	public String getnom() {
		return nom;
	}
	
	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public double getprix() {
		return prix;
	}
	public void setprix(double prix) {
		this.prix = prix;
	}
	
	public List<LigneFacture> getligneFactureList() {
		return ligneFactureList;
	}
	
	public void setLigneFactureList(List<LigneFacture> ligneFactureList) {
		this.ligneFactureList = ligneFactureList;
	}
	

	
}

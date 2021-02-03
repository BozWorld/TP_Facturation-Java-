package fr.epsi.entite;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
	private String numero;
	
	private double prix;
	
	@ManyToOne
	private Client client;
	
	@OneToMany
	private List<LigneFacture> ligneFactureList;
	
	public Date getdate() {
		return date;
	}
	
	public void setdate(Date date) {
		this.date = date;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	 
	public List<LigneFacture> getLigneFactureList() {
		return ligneFactureList;
	}
	
	public void setLigneFactureList(List<LigneFacture> lignefacturelist) {
		this.ligneFactureList = lignefacturelist;
	}
	
	
}

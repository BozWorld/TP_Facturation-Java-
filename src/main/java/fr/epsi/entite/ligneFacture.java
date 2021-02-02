package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class ligneFacture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int qte;
	
	private double prix;
	
	@OneToOne
	@JoinTable(name = "Facture")
	private Facture facture;
	
	@OneToOne
	@JoinTable(name = "Article")
	private Article article;
	
	public int getqte() {
		return qte;
	}

	public void setqte(int qte) {
		this.qte = qte;
	}
	
	public double getprix() {
		return prix;
	}

	public void setprix(double prix) {
		this.prix = prix;
	}
	
	public Facture getFacture() {
		return facture;
	}
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	public Article getArticle() {
		return article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
}

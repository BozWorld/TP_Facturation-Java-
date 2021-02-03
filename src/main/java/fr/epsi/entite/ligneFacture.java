package fr.epsi.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LigneFacture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int qte;
	
	private double prix;
	
	@ManyToOne
	private Facture facture;
	
	@ManyToOne
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

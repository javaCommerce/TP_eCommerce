package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IProduitService {	
	
	
/**Déclaration des méthodes de produit service*/
	
	
	
	public Produit addProduit(Produit p, Categorie cat);
	
	public List<Produit> getProduitByKeyWord (Produit p);
	
	public int supprProduit(Produit p, Categorie cat);
	
	public Produit modifProduit(Produit p, Categorie cat);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	public Produit getProduitById (Produit p, Categorie cat);

}

package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IProduitService {	
	
	
/**Déclaration des méthodes de produit service*/
	
	
	
	public Produit addProduit(Produit p, Categorie cat);
	
	public Produit getProduitById (Produit p, Categorie cat);
	
	public Produit supprProduit(Produit p, Categorie cat);
	
	public Produit modifPoduit(Produit p, Categorie cat);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	

}

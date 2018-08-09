package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IAdminService {
	
	
	/**Déclaration des méthodes de admin dao*/
	
	public Produit addProduit(Produit p, Categorie cat);
	
	public Produit getProduitById (Produit p);
	
	public Produit supprProduit(Produit p);
	
	public Produit modifPoduit(Produit p);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	public Admin isExist(Admin a);
	

	
	public Categorie addCategorie(Categorie cat);
	
	public Categorie supprCategorie(Categorie cat);
	
	public Categorie modifCategorie(Categorie cat);
	
	public Categorie getCategorieByName(Categorie cat);
	
	
}

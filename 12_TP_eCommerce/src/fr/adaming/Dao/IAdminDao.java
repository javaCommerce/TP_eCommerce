package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IAdminDao {
	
	/**Déclaration de la méthode isExist*/
	
	
	public Admin isExist(Admin a);
	
	
	
	
	
	
	public Produit addProduit(Produit p, Categorie cat);
	
	public Produit getProduitById (Produit p);
	
	public Produit supprProduit(Produit p);
	
	public Produit modifPoduit(Produit p);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	
	
	
	
	
	
	
	public Categorie addCategorie(Categorie cat);
	
	public Categorie supprCategorie(Categorie cat);
	
	public Categorie modifCategorie(Categorie cat);
	
	public Categorie getCategorieByName(Categorie cat);
}

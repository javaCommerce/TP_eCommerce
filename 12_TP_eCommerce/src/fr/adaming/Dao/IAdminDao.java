package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IAdminDao {
	
	/**Déclaration des méthodes de admin dao*/
	
	public Produit addProduit(Produit p, Categorie cat);
	
	public Produit getProduitById (Produit p);
	
	public Produit supprProduit(Produit p);
	
	public Produit modifPoduit(Produit p);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	public Admin isExist(Admin a);
	

}

package fr.adaming.service;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Local

public interface IAdminService {
	
	
	/**D�claration des m�thodes de admin dao*/
	
	public Produit addProduit(Produit p);
	
	public Produit getProduitById (Produit p);
	
	public Produit supprProduit(Produit p);
	
	public Produit modifPoduit(Produit p);
	
	public Produit getAllProduit(Produit p);
	
	public Admin isExist(Admin a);
	

}

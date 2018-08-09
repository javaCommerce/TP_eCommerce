package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IProduitDao {
	
	
	
/**D�claration des m�thodes de produit dao*/
	
	public Produit addProduit(Produit p);
	
	public Produit getProduitById (Produit p);
	
	public Produit supprProduit(Produit p);
	
	public Produit modifPoduit(Produit p);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	
	
	
	
	
	
	
	
	

}

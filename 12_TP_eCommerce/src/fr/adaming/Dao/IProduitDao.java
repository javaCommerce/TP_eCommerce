package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IProduitDao {
	
	
	
/**Déclaration des méthodes de produit dao*/
	
	public Produit addProduit(Produit p);
	
	public List<Produit> getProduitByKeyWord (Produit p);
	
	public int supprProduit(Produit p);
	
	public int modifPoduit(Produit p);
	
	public List<Produit> getAllProduit(Categorie cat);
	
	public Produit getProduitById (Produit P);
	
	
	
	
	
	
	
	

}

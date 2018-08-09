package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

/**
 * Définition de l'interface Client Dao
 * 
 * @author inti0489
 *
 */

@Local
public interface IClientDao {

	public List<Categorie> getAllCategories();

	public List<Produit> getAllProduits(Categorie cat);

	public Produit addProduit();

}

package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;

@Local

public interface ICategorieDao {
	
	

	public Categorie addCategorie(Categorie cat);
	
	public int supprCategorie(Categorie cat);
	
	public int modifCategorie(Categorie cat);
	
	public Categorie getCategorieById(Categorie cat);
	
	public List<Categorie> getAllCategorie();
	
	
	
	
	
	
	
	
	
	
	
	

}

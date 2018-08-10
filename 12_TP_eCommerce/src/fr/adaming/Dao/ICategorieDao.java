package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;

@Local

public interface ICategorieDao {
	
	

	public Categorie addCategorie(Categorie cat);
	
	public Categorie supprCategorie(Categorie cat);
	
	public Categorie modifCategorie(Categorie cat);
	
	public Categorie getCategorieById(Categorie cat);
	
	public List<Categorie> getAllCategorie();
	
	
	
	
	
	
	
	
	
	
	
	

}

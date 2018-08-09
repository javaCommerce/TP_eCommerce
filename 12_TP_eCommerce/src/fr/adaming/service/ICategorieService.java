package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;

@Local

public interface ICategorieService {
	
	
	
	public Categorie addCategorie(Categorie cat);
	
	public Categorie supprCategorie(Categorie cat);
	
	public Categorie modifCategorie(Categorie cat);
	
	public Categorie getCategorieByName(Categorie cat);
	
	public List<Categorie> getAllCategorie();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

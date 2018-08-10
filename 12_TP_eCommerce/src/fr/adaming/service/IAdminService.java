package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IAdminService {
	
	
	/**Déclaration de la méthodes is exist*/
	
	
	
	public Admin isExist(Admin a);
	

	
	
}

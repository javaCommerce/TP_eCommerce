package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local

public interface IAdminDao {
	
	/**D�claration de la m�thode isExist*/
	
	
	public Admin isExist(Admin a);
	
	
	
	
	
	
}

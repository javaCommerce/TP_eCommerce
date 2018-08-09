package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;

/**
 * Définition de l'interface Client de la couche service
 * @author inti0489
 *
 */

@Local
public interface IClientService {

	public List<Categorie> getAllCategoriesService();
	
	
}

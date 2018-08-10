package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

/**
 * Définition de l'interface Client de la couche service
 * 
 * @author inti0489
 *
 */

@Local
public interface IClientService {

	public Client addClient(Client c);
	
	public int deleteClient(Client c);
	
	public int updateClient(Client c);
	
	public Client getClientByNom(Client c);
	
	public List<Client> getAllClient();

	public List<Categorie> getAllCategoriesService();

	public List<Produit> getAllProduitsService(Categorie cat);

}

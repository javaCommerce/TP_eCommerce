package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

@Stateful
public class ClientServiceImpl implements IClientService {

	/**
	 * Transformation de l'association UML en Java Annotation permettant de
	 * faire l'injection de l'EJB
	 */
	@EJB
	IClientDao clDao;

	public List<Categorie> getAllCategoriesService() {
		return clDao.getAllCategories();
	}

	public List<Produit> getAllProduitsService(Categorie cat) {
		return clDao.getAllProduits(cat);
	}

	public Client addClient(Client c) {
		return clDao.addClient(c);
	}

	public List<Client> getAllClient() {
		return clDao.getAllClient();
	}

}

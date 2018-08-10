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


	public Client addClient(Client c) {
		return clDao.addClient(c);
	}

	public List<Client> getAllClient() {
		return clDao.getAllClient();
	}

	public int deleteClient(Client c) {

		/**
		 * Récupérer le client qui va être supprimé
		 */
		Client clientDelete = this.getClientByNom(c);

		if (clientDelete != null) {
			return clDao.deleteClient(clientDelete);

		}

		return 0;

	}

	public Client getClientByNom(Client c) {
		return clDao.getClientByNom(c);
	}

	public List<Categorie> getAllCategoriesService() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produit> getAllProduitsService(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateClient(Client c) {	
		return clDao.updateClient(c);
	}

}

package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.IClientService;

/**
 * D�finition du managedBean Client
 * @author inti0489
 *
 */

/**
 * Annotation pour nomm� le managedBean Annotation pour d�finir la port�e du
 * managedBean
 * 
 * @author inti0489
 *
 */

@ManagedBean(name = "clMB")
@SessionScoped
public class ClientManagedBean implements Serializable {

	/**
	 * Transformation de l'association UML en Java
	 */
	@EJB
	IClientService clService;

	/**
	 * D�claration des attributs du managedBean
	 */
	private Client client;
	private Categorie categorie;

	
	
	

	/**
	 * D�claration du constructeur vide
	 */

	public ClientManagedBean() {
		super();
		this.client = new Client();
		this.categorie = new Categorie();

	}

	/**
	 * D�claration des getters et setters
	 */

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	


	/**
	 * D�finition des m�thodes du managedBean
	 */

	public String addClient() {

		/**
		 * Appel de la m�thode service pour ajouter le client
		 */
		Client clientOut = clService.addClient(this.client);

		if (clientOut.getIdClient() != 0) {

			/**
			 * R�cup�rer la liste des clients qui existent
			 */
			List<Client> listeClient = clService.getAllClient();

			/**
			 * Ajout du client dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeClient);

			return "accueilClient";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La cr�ation de votre compte a �chou� !"));
			return "accueilClient";

		}

	}

	public String deleteClient() {

		int clVerif = clService.deleteClient(this.client);

		if (clVerif != 0) {

			/**
			 * R�cup�rer la liste des clients qui existent pour la mettre � jour
			 */
			List<Client> listeClient = clService.getAllClient();

			/**
			 * Ajout du client dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeClient);

			return "accueilClient";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La suppression de votre compte a �chou� !"));
			return "supprimerClient";
		}
	}

	public String updateClient() {

		int clVerif = clService.updateClient(this.client);

		if (clVerif != 0) {
			/**
			 * R�cup�rer la liste des clients qui existent pour la mettre � jour
			 */
			List<Client> listeClient = clService.getAllClient();

			/**
			 * Ajout du client dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeClient);

			return "accueilClient";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Vos informations de compte n'ont pas pu �tre modifi�es !"));
			return "modifierClient";
		}

	}

	public String getAllCategories() {

		/**
		 * R�cup�rer la liste des cat�gories
		 */
		List<Categorie> listeCatOut = clService.getAllCategoriesService();

		if (listeCatOut != null) {

			/**
			 * Ajouter la liste trouv�e dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("catListe", listeCatOut);

			return "accueilClient";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("D�sol�, cette cat�gorie n'est pas encore disponible chez nous !"));
			return "accueilClient";
		}

	}

	public String getAllProduits() {

		/**
		 * R�cup�rer la liste des produits
		 */
		List<Produit> listeProOut = clService.getAllProduitsService(this.categorie);

		if (listeProOut != null) {

			/**
			 * Ajouter la liste trouv�e dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("proListe", listeProOut);

			return "accueilClient";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Les produits de cette cat�gorie ne sont pas encore disponibles !"));
			return "accueilClient";
		}

	}

}

package fr.adaming.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.IClientService;

/**
 * Définition du managedBean Client
 * @author inti0489
 *
 */

/**
 * Annotation pour nommé le managedBean Annotation pour définir la portée du
 * managedBean
 * 
 * @author inti0489
 *
 */

@ManagedBean(name = "clMB")
@SessionScoped
public class ClientManagedBean {

	/**
	 * Transformation de l'association UML en Java
	 */
	@EJB
	IClientService clService;

	/**
	 * Déclaration des attributs du managedBean
	 */
	private Client client;
	private Categorie categorie;

	/**
	 * Déclaration du constructeur vide
	 */

	public ClientManagedBean() {
		super();
		this.client = new Client();
	}

	/**
	 * Déclaration des getters et setters
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
	 * Définition des méthodes du managedBean
	 */

	public String addClient() {

		/**
		 * Appel de la méthode service pour ajouter le client
		 */
		Client clientOut = clService.addClient(this.client);

		if (clientOut.getIdClient() != 0) {

			/**
			 * Récupérer la liste des clients qui existent
			 */
			List<Client> listeClient = clService.getAllClient();

			/**
			 * Ajout du client dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeClient);

			return "accueilClient";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La création de votre compte a échoué !"));
			return "accueilClient";

		}

	}

	public String getAllCategories() {

		/**
		 * Récupérer la liste des catégories
		 */
		List<Categorie> listeCatOut = clService.getAllCategoriesService();

		if (listeCatOut != null) {

			/**
			 * Ajouter la liste trouvée dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeCatOut);

			return "accueilClient";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Désolé, cette catégorie n'est pas encore disponible chez nous !"));
			return "accueilClient";
		}

	}

	public String getAllProduits() {

		/**
		 * Récupérer la liste des produits
		 */
		List<Produit> listeProOut = clService.getAllProduitsService(this.categorie);

		if (listeProOut != null) {

			/**
			 * Ajouter la liste trouvée dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeProOut);

			return "accueilClient";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Les produits de cette catégorie ne sont pas encore disponibles !"));
			return "accueilClient";
		}

	}

}

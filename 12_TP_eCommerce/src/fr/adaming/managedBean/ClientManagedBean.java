package fr.adaming.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
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
	Client client;

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

	/**
	 * Définition des méthodes du managedBean
	 */

	public void getAllCategories() {

		/**
		 * Récupérer la liste des catégories
		 */
		List<Categorie> listeCatOut = clService.getAllCategoriesService();

		if (listeCatOut != null) {

			/**
			 * Ajouter la liste trouvée dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeCatOut);

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Il n'y a pas de catégories à afficher"));
		}

	}

}

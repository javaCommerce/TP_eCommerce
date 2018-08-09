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
public class ClientManagedBean {

	/**
	 * Transformation de l'association UML en Java
	 */
	@EJB
	IClientService clService;

	/**
	 * D�claration des attributs du managedBean
	 */
	Client client;

	/**
	 * D�claration du constructeur vide
	 */

	public ClientManagedBean() {
		super();
		this.client = new Client();
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

	/**
	 * D�finition des m�thodes du managedBean
	 */

	public void getAllCategories() {

		/**
		 * R�cup�rer la liste des cat�gories
		 */
		List<Categorie> listeCatOut = clService.getAllCategoriesService();

		if (listeCatOut != null) {

			/**
			 * Ajouter la liste trouv�e dans la session http
			 */
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clSession", listeCatOut);

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Il n'y a pas de cat�gories � afficher"));
		}

	}

}

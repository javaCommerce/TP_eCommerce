package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.UploadedFile;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@ManagedBean(name = "aMB")
@RequestScoped

public class AdminManagedBean implements Serializable {

	/** Declaration de l'uml en java et injection de ejb */

	@EJB
	private IAdminService aService;
	@EJB
	private IClientService clService;

	/** Déclaration des attribus */

	private Produit produit;
	private Admin admin;
	private Categorie cat;

	private UploadedFile file;

	/** Constructeur vide */

	public AdminManagedBean() {
		super();
		this.admin = new Admin();
		this.cat = new Categorie();
	}

	/** getter et setter */

	public IAdminService getaService() {
		return aService;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setaService(IAdminService aService) {
		this.aService = aService;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	
	
	
	
	/** Autre méthode (Connection et déconnection) */
	
	
	
	/**Développement de la méthode se connecter*/

	public String connection() {

		Admin aOut = aService.isExist(admin);

		if (aOut != null) {

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aSession", aOut);

			return "accueil";

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail ou mot de passe incorrect"));
			return "login";

		}

	}
	
	
	/**développement de la méthode se déconnecter*/
	
	
	public String logout(){
 		FacesContext context = FacesContext.getCurrentInstance();
 		ExternalContext ec = context.getExternalContext();
 
 		final HttpServletRequest request = (HttpServletRequest)ec.getRequest();
 	     request.getSession( false ).invalidate();
 	  
 	     
 	     return "login";
 	}
	
	
	
	

}

package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="proMB")
@RequestScoped

public class ProduitManagedBean implements Serializable{
	
	
	/** Declaration de l'uml en java et injection de ejb */
	@EJB
	private IProduitService proService;

	
	/**Declaration des attribus de produits MB*/
	
	private Produit pro;
	private Categorie cat;
	
	
	/** Constructeur vide et instanciation des objets utilisé */
	
	public ProduitManagedBean() {
		super();
		this.pro = new Produit();
		this.cat = new Categorie();
	}


	
	/**getter et setter*/
	
	public IProduitService getProService() {
		return proService;
	}


	public void setProService(IProduitService proService) {
		this.proService = proService;
	}


	public Produit getPro() {
		return pro;
	}


	public void setPro(Produit pro) {
		this.pro = pro;
	}


	public Categorie getCat() {
		return cat;
	}


	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	
	
	
	/**Autre méthode : CRUD*/
	
	
	
	public String ajouterProduit() {

		Produit pAjout = proService.addProduit(this.pro, this.cat);

		if (pAjout.getIdProduit() != 0) {

			List<Produit> listeProduit = proService.getAllProduit(cat);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListe", listeProduit);

			return "accueil";
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout n'à pas été effectué"));
			return "ajoutProduit";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

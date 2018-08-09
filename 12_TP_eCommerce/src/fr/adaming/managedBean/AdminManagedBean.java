package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@ManagedBean(name="aMB")
@RequestScoped


public class AdminManagedBean implements Serializable{
	
	
	
	/**Declaration de l'uml en java et injection de ejb*/
	
	@EJB
	private IAdminService aService;
	@EJB
	private IClientService clService;
	
	/**Déclaration des attribus*/
	
	private Produit produit;
	private Admin admin;
	private Categorie cat;
	
	
	/**Constructeur vide*/
	
	public AdminManagedBean() {
		super();
		this.admin=new Admin();
	}


	/**getter et setter*/
	
	
	
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
	
	
	/**Autre méthode (CRUD)*/
	
	
	
	public String connection(){
		
	Admin aOut = aService.isExist(admin);
	
	if(aOut!=null){
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aSession", aOut);
		
		return "accueil";
		
	}else{
	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail ou mot de passe incorrect"));
		return "login";
	
	}
	
	}
	
	
	
	public String ajouterProduit() {

		Produit pAjout = aService.addProduit(this.produit, this.cat);

		if (pAjout.getIdProduit() != 0) {

			List<Produit> listeProduit = aService.getAllProduit(cat);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListe", listeProduit);

			return "accueil";
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout n'à pas été effectué"));
			return "ajoutProduit";
		}
	}
	
	
	
	
	public String ajouterCategorie(){	
		

	Categorie catAjout = aService.addCategorie(this.cat);
		
	if (catAjout.getIdCategorie() != 0){
		
		
		List<Categorie> listeCategorie = clService.getAllCategoriesService();
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieListe", listeCategorie);
		
		return "accueil";
	}else{
	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout n'à pas été effectué"));
		return "ajoutCategorie";
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}

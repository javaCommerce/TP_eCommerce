package fr.adaming.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.message.Message;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;

@ManagedBean(name="aMB")
@RequestScoped


public class AdminManagedBean implements Serializable{
	
	
	
	/**Declaration de l'uml en java et injection de ejb*/
	
	@EJB
	private IAdminService aService;
	
	
	/**Déclaration des attribus*/
	
	private Produit produit;
	private Admin admin;

	/**Constructeur vide*/
	
	public AdminManagedBean() {
		super();
	}


	/**getter et setter*/
	
	
	
	public IAdminService getaService() {
		return aService;
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
	
	
	//public String ajouterProduit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}

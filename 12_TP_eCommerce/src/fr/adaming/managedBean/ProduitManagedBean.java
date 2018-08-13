package fr.adaming.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "prMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	// transformation de l'association UML en JAVA
	@EJB
	private IProduitService prService;

	private Produit pro;
	private UploadedFile file;
	private Categorie cat;

	public ProduitManagedBean() {
		this.pro = new Produit();
		this.cat = new Categorie();
	}

	public Produit getPro() {
		return pro;
	}

	public void setPro(Produit pro) {
		this.pro = pro;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	
	
	/** Autre m�thode (CRUD)*/
	

	/** Ajouter un produit*/
	
	public String ajouterProduit() {

		pro.setPhoto(file.getContents());

		Produit prOut = prService.addProduit(pro, cat);

		System.out.println(this.pro.getDescription());
		return null;
	}
	
	
	
	/**Get produit par son id*/
	
	
	public String getProduitById(){
		
		Produit pRech=prService.getProduitById(pro, cat);
		System.out.println("***********************************************"+pRech);
		if(pRech!=null){
			
			this.pro=pRech;
			
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La recherche du produit a �chou�"));
		}
		
		return "rechercheProduit";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

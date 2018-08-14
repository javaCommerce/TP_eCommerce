package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

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
	
	
	/** Autre méthode (CRUD)*/
	

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
		
		if(pRech!=null){
			
			this.pro=pRech;
			
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La recherche du produit a échoué"));
		
		}
		return "rechercheProduit";
		
		
	}
	
	
	public String supprProduit(){
		
		int verif = prService.supprProduit(pro, cat);
		
		if (verif!=0){
			
			List<Produit> listeProduit = prService.getAllProduit(cat);
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListe", listeProduit);
		
			return "accueil";
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression n'a pas pu être efectué"));
		
			return "supprProduit";
			
		}
				
	}
	
	
	public String getAllProduit(){
		
		List<Produit> listeProduit = prService.getAllProduit(cat);
		
		if(listeProduit!=null){
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListe", listeProduit);
			
			return "listeProduit";
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ces produits n'existent pas"));
			return "accueil";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

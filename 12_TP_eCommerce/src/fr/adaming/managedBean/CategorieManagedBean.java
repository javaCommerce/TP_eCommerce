package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "catMB")
@RequestScoped

public class CategorieManagedBean implements Serializable {

	/** Declaration de l'uml en java et injection de ejb */

	@EJB
	private ICategorieService catService;
	
	

	/** Déclaration des attribus */

	private Categorie cat;
	private UploadedFile file;
	
	

	/** Constructeur vide */

	public CategorieManagedBean() {
		super();
		this.cat = new Categorie();
	}
	
	

	/** getter et setter */

	public ICategorieService getCatService() {
		return catService;
	}

	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	
	/** Autre méthode (CRUD) */
	
	
	public String ajouterCategorie() {

		this.cat.setPhoto(file.getContents());
		
		Categorie catAjout = catService.addCategorie(this.cat);

		if (catAjout.getIdCategorie() != 0) {

			List<Categorie> listeCategorie = catService.getAllCategorie();

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieListe",
					listeCategorie);

			return "accueil";
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout n'à pas été effectué"));
			return "ajoutCategorie";
		}
	}
	
	
	public String rechCatById(){
		
		Categorie catCherch=catService.getCategorieById(cat);
		
		if (catCherch!=null){
			
			this.cat=catCherch;
			
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la reche de la categorie à échoué"));
		}
		
		return "rechercheCategorie";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

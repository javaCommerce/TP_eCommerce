package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.ICategorieDao;
import fr.adaming.entities.Categorie;

@Stateful

public class CategorieServiceImpl implements ICategorieService{
	
	
	/**Déclaration de l'association uml en java et injecter ejb*/
	
	@EJB
	private ICategorieDao catDao;
	
	

	public Categorie addCategorie(Categorie cat) {
		
		return catDao.addCategorie(cat);
		
		
	}
	
	
	
	

	public int supprCategorie(Categorie cat) {
		Categorie catSuppr=this.getCategorieById(cat);
		
		if(catSuppr!=null){
			return catDao.supprCategorie(catSuppr);
		}
				return 0;
	}
	
	
	
	
	

	public int modifCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return catDao.modifCategorie(cat);
	}

	
	
	public Categorie getCategorieById(Categorie cat) {

		return catDao.getCategorieById(cat);
	}
		
	
	
	
	
	
	public List<Categorie> getAllCategorie() {
		
		return catDao.getAllCategorie();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

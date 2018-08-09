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

	public Categorie supprCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Categorie modifCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Categorie getCategorieByName(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categorie> getAllCategorie() {
		
		return catDao.getAllCategorie();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

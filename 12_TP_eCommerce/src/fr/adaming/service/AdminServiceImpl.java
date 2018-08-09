package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateful
public class AdminServiceImpl implements IAdminService {
	
	
	/**Déclaration de l'association uml en java et injecter ejb*/
	@EJB
	private IAdminDao aDao;
	
	
	
	/**Déclaration des méthodes du CRUD*/
	

	public Produit addProduit(Produit p, Categorie cat) {
		p.setCat(cat);
		return aDao.addProduit(p, cat);
	}

	
	
	public Produit getProduitById(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit supprProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit modifPoduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin isExist(Admin a) {
		
		return aDao.isExist(a);
	}


	public List<Produit> getAllProduit(Categorie cat) {
		
		return aDao.getAllProduit(cat);
	}








	public Categorie addCategorie(Categorie cat) {
		
		return aDao.addCategorie(cat);
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

}

package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Stateful
public class AdminServiceImpl implements IAdminService {
	
	
	/**Déclaration de l'association uml en java et injecter ejb*/
	@EJB
	private IAdminDao aDao;
	
	
	
	/**Déclaration des méthodes du CRUD*/
	

	public Produit addProduit(Produit p) {
		
		return aDao.addProduit(p);
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

	public Produit getAllProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}








	public Admin isExist(Admin a) {
		
		return aDao.isExist(a);
	}

}

package fr.adaming.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Stateless

public class AdminDaoImpl implements IAdminDao {
	
	/**Déclaration du persistence context*/
	
	@PersistenceContext(unitName="PU_eCommerce")
	private EntityManager em;
	
	
	
	
	/**Déclaration des méthodes du CRUD*/
	

	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
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
	
	
	

	
	


	
	
	
	
	
}

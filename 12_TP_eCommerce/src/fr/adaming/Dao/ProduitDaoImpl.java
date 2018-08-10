package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless

public class ProduitDaoImpl implements IProduitDao{
	
	
	
	/**Déclaration du persistence context*/
	
	@PersistenceContext(unitName="PU_eCommerce")
	private EntityManager em;
	
	
	
	/**Déclaration des méthodes du CRUD de produit*/
	
	

	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Produit> getProduitByKeyWord(Produit p) {
		
		String req = "SELECT p FROM Produit AS p WHERE p.designation IN p.description";
		
		Query query = em.createQuery(req);
		
		return query.getResultList();
	}
	
	

	public Produit supprProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit modifPoduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Produit> getAllProduit(Categorie cat) {
		
		String req = "SELECT p FROM Produit As p WHERE p.categorie=:pId";
		
		Query query = em.createQuery(req);
		
		query.setParameter("pId", cat.getIdCategorie());
		
		return query.getResultList();
	}
	
	
	
	
	
	

	
	
	
	

}

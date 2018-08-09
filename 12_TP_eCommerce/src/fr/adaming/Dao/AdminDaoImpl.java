package fr.adaming.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

@Stateless

public class AdminDaoImpl implements IAdminDao {
	
	/**D�claration du persistence context*/
	
	@PersistenceContext(unitName="PU_eCommerce")
	private EntityManager em;
	
	
	
	
	/**D�claration des m�thodes du CRUD*/
	

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



	/**Developpement de la m�thode isExist pour cr�er une session admin*/

	public Admin isExist(Admin a) {
		
		try{
			
			String req="SELECT admin FROM Admin AS admin WHERE admin.mail=:pMail AND admin.mdp=:pMdp";
			
			Query query=em.createQuery(req);
			
			query.setParameter("pMail", a.getMail());
			query.setParameter("pMdp", a.getMdp());
			
			return (Admin) query.getSingleResult();
			
		}catch(NoResultException ex){
			
			ex.printStackTrace();
		}
		
		
		return null;
	}
	

	

	
	


	
	
	
	
	
}
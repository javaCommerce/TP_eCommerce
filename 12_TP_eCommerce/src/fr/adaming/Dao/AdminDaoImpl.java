package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless

public class AdminDaoImpl implements IAdminDao {
	
	/**Déclaration du persistence context*/
	
	@PersistenceContext(unitName="PU_eCommerce")
	private EntityManager em;
	
	


	/**Developpement de la méthode isExist pour créer une session admin*/

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

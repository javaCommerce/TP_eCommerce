package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao{
	
	
	
	
/**D�claration du persistence context*/
	
	@PersistenceContext(unitName="PU_eCommerce")
	private EntityManager em;
	
	
	
	
	/**D�claration des m�thodes du CRUD*/
	
	
	
	
	/***************************Ajouter des cat�gories*/

	public Categorie addCategorie(Categorie cat) {
		em.persist(cat);
		return cat;
	}
	
	
	
	

	public int supprCategorie(Categorie cat) {
		try{
			em.remove(cat);
			return 1;
		}catch (Exception ex){
			
		}
		return 0;
	}
	
	
	
	

	public int modifCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

	public Categorie getCategorieById(Categorie cat) {
		return em.find(Categorie.class, cat.getIdCategorie());
	}

	
	
	
	
	
	/***************************Liste des cat�gories*/	
	
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategorie() {

		/**
		 * cr�ation de la requ�te JPQL qui r�cup�re toutes les cat�gories
		 */
		String req = "SELECT cat FROM Categorie cat";

		/**
		 * cr�ation du query pour envoyer la requ�te JPQL
		 */
		Query query = em.createQuery(req);

		/**
		 * retourne la liste des cat�gories trouv�e
		 */

		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

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

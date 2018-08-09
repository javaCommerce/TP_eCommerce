package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao{
	
	
	
	
/**Déclaration du persistence context*/
	
	@PersistenceContext(unitName="PU_eCommerce")
	private EntityManager em;
	
	
	
	
	/**Déclaration des méthodes du CRUD*/
	
	
	
	
	/***************************Ajouter des catégories*/

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

	/***************************Liste des catégories*/	
	
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategorie() {

		/**
		 * création de la requête JPQL qui récupère toutes les catégories
		 */
		String req = "SELECT cat FROM Categorie cat";

		/**
		 * création du query pour envoyer la requête JPQL
		 */
		Query query = em.createQuery(req);

		/**
		 * retourne la liste des catégories trouvée
		 */

		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

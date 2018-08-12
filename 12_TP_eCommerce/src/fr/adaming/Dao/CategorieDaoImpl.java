package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

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
	
	
	
	

	public int supprCategorie(Categorie cat) {
		try{
			em.remove(cat);
			return 1;
		}catch (Exception ex){
			
		}
		return 0;
	}
	
	
	
	

	public int modifCategorie(Categorie cat) {

		/**Requete JPQL*/
		
		String req="UPDATE Categorie cat SET cat.description=:pDescription, cat.nomCategorie=:pNomCategorie, cat.photo=:pPhoto WHERE cat.idCategorie=:pIdCategorie";
		
		/**Créer le query*/
		
		Query query = em.createQuery(req);
		
		/**passage des parametres*/
		
		query.setParameter("pDescription", cat.getDescription());
		query.setParameter("pNomCategorie", cat.getNomCategorie());
		query.setParameter("pPhoto", cat.getPhoto());
		query.setParameter("pIdCategorie", cat.getIdCategorie());
		
		
		
		return query.executeUpdate();
	}
	
	
	
	

	public Categorie getCategorieById(Categorie cat) {
		
		String req="Select cat From Categorie as cat where cat.id=:pId";
		
		
		Query query = em.createQuery(req);
		
		/**passage de parametres*/
		
		query.setParameter("pId", cat.getIdCategorie());
		
		Categorie catOut = (Categorie) query.getSingleResult();		
		
		cat.setImage("data:image/png;base64," + Base64.encodeBase64String(cat.getPhoto()));
		

		return catOut;
	
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

		List<Categorie> listeCats = query.getResultList();

		for (Categorie cat : listeCats) {
			cat.setImage("data:image/png;base64," + Base64.encodeBase64String(cat.getPhoto()));
		}

		return listeCats;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

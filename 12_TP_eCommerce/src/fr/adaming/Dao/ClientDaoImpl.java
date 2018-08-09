package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext(unitName = "PU_eCommerce")
	private EntityManager em;

	
	/**
	 * Définition de la méthode client pour consulter toutes les catégories :
	 * Elle n'accepte rien en entrée et retourne une liste de catégories
	 */
	
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategories() {

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

	public List<Produit> getAllProduits(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit addProduit() {
		// TODO Auto-generated method stub
		return null;
	}

}

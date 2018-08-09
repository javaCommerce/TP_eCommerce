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

	@SuppressWarnings("unchecked")
	public List<Produit> getAllProduits(Categorie cat) {

		/**
		 * Création de la requête JPQL qui récupère les produits d'une catégorie
		 */
		String req = "SELECT p FROM Produit p WHERE p.categorie.id=:pId";

		/**
		 * Création du query pour envoyer la requête JPQL
		 */
		Query query = em.createQuery(req);

		/**
		 * Passage des paramètres
		 */
		query.setParameter("pId", cat.getIdCategorie());

		return query.getResultList();
	}

	public Produit addProduit() {
		// TODO Auto-generated method stub
		return null;
	}

}

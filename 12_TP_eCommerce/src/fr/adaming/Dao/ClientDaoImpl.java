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
	 * D�finition de la m�thode client pour consulter toutes les cat�gories :
	 * Elle n'accepte rien en entr�e et retourne une liste de cat�gories
	 */
	
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategories() {

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

	public List<Produit> getAllProduits(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit addProduit() {
		// TODO Auto-generated method stub
		return null;
	}

}

package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
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

		List<Categorie> listeCats = query.getResultList();

		for (Categorie cat : listeCats) {
			cat.setImage("data:image/png;base64," + Base64.encodeBase64String(cat.getPhoto()));
		}

		return listeCats;
	}

	@SuppressWarnings("unchecked")
	public List<Produit> getAllProduits(Categorie cat) {

		/**
		 * Cr�ation de la requ�te JPQL qui r�cup�re les produits d'une cat�gorie
		 */
		String req = "SELECT p FROM Produit p WHERE p.categorie.id=:pId";

		/**
		 * Cr�ation du query pour envoyer la requ�te JPQL
		 */
		Query query = em.createQuery(req);

		/**
		 * Passage des param�tres
		 */
		query.setParameter("pId", cat.getIdCategorie());

		return query.getResultList();
	}

	public Produit addProduit() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produit> getProduitByKeyWord(Categorie cat) {

		/**
		 * Cr�ation de la requ�te JPQL qui r�cup�re le/les produit(s)
		 */
		String req = "SELECT p FROM Produit p WHERE p.designation IN p.description";

		return null;
	}

	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Client> getAllClient() {

		/**
		 * Cr�ation de la requ�te JPQL pour r�cup�rer les clients
		 */
		String req = "SELECT cl FROM Client cl";

		/**
		 * Cr�ation du query
		 */
		Query query = em.createQuery(req);

		/**
		 * Retourne la liste trouv�e
		 */

		return query.getResultList();
	}

	public int deleteClient(Client c) {
		try {
			/**
			 * remove le client
			 */
			em.remove(c);
			return 1;
		} catch (Exception arg) {
			arg.printStackTrace();

		}
		return 0;

	}

	public Client getClientByNom(Client c) {

		/**
		 * Cr�ation de la requ�te JPQL
		 */
		String req = "SELECT cl FROM Client cl WHERE cl.nomClient=:pNom";

		/**
		 * Cr�ation du query
		 */
		Query query = em.createQuery(req);

		/**
		 * Passage des param�tres
		 */
		query.setParameter("pNom", c.getNomClient());

		return (Client) query.getSingleResult();
	}

	public int updateClient(Client c) {

		try {
			/**
			 * r�cup�rer le client � modifier
			 */
			em.find(Client.class, c.getIdClient());
			/**
			 * merge le client
			 */
			em.merge(c);
			return 1;
		} catch (Exception arg) {
			arg.printStackTrace();

		}
		return 0;
	}

}

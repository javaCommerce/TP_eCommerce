package fr.adaming.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.CategorieDaoImpl;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateful

public class ProduitServiceImpl implements IProduitService{
	
	
	/**Déclaration de l'association uml en java et injecter ejb*/
	@EJB
	private IProduitService proDao;
	
	
	/**Déclaration des méthodes du CRUD*/

	public Produit addProduit(Produit p, Categorie cat) {
		p.setCat(cat);
		return proDao.addProduit(p, cat);
	}
	
	

	public Produit getProduitById(Produit p, Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit supprProduit(Produit p, Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit modifPoduit(Produit p, Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produit> getAllProduit(Categorie cat) {
		
		return proDao.getAllProduit(cat);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

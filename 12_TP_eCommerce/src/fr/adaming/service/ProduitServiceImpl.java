package fr.adaming.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.CategorieDaoImpl;
import fr.adaming.Dao.ICategorieDao;
import fr.adaming.Dao.IProduitDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateful

public class ProduitServiceImpl implements IProduitService{
	
	
	/**Déclaration de l'association uml en java et injecter ejb*/
	@EJB
	private IProduitDao proDao;
	
	@EJB
	private ICategorieDao catDao;
	
	
	/**Déclaration des méthodes du CRUD*/

	public Produit addProduit(Produit p, Categorie cat) {
		
		Categorie catOut=catDao.getCategorieById(cat);
		p.setCat(catOut);
		return proDao.addProduit(p);
	}
	
	

	public List<Produit> getProduitByKeyWord(Produit p) {
	
		return proDao.getProduitByKeyWord(p);
	}
	
	

	
	
	public int supprProduit(Produit p, Categorie cat) {
		
		Produit pSuppr=this.getProduitById(p, cat);
		
		if(pSuppr!=null){
			
			return proDao.supprProduit(pSuppr);
			
		}
		
		return 0;
	}

	
	
	
	
	
	public Produit modifProduit(Produit p, Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public List<Produit> getAllProduit(Categorie cat) {
		
		return proDao.getAllProduit(cat);
	}

	
	

	/**Methode get produit par son id*/

	@Override
	public Produit getProduitById(Produit p, Categorie cat) {
		p.setCat(cat);
		
		Produit pOut=proDao.getProduitById(p);
		
		if(pOut!=null){
		if(pOut.getCat().getIdCategorie()==cat.getIdCategorie()){
			
			return pOut;
		}
			
			
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

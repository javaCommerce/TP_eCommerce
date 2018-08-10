package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateful
public class AdminServiceImpl implements IAdminService {
	
	
	/**Déclaration de l'association uml en java et injecter ejb*/
	@EJB
	private IAdminDao aDao;
	
	
	
	

	public Admin isExist(Admin a) {
		
		return aDao.isExist(a);
	}


	
}

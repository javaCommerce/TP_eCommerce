package fr.adaming.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")

public class Categorie {

	/** déclaration de l'association uml en java */

	@OneToMany(mappedBy = "cat", cascade = CascadeType.PERSIST)
	private List<Produit> listeProduit;

	/** déclaration des attribus */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cat")
	private long idCategorie;
	private String nomCategorie;
	private byte photo;
	private String description;

	/** Déclaration des constructeurs */

	public Categorie(List<Produit> listeProduit, long idCategorie, String nomCategorie, byte photo,
			String description) {
		super();
		this.listeProduit = listeProduit;
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	public Categorie(List<Produit> listeProduit, String nomCategorie, byte photo, String description) {
		super();
		this.listeProduit = listeProduit;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	public Categorie() {
		super();
	}

	public Categorie(long idCategorie, String nomCategorie, byte photo, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	public Categorie(String nomCategorie, byte photo, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}
	
	/**Déclaration des getter et setter*/

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**Declaration de la méthode to string*/
	
	@Override
	public String toString() {
		return "Categorie [listeProduit=" + listeProduit + ", idCategorie=" + idCategorie + ", nomCategorie="
				+ nomCategorie + ", photo=" + photo + ", description=" + description + "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}

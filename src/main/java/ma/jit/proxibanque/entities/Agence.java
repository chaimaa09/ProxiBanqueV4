/**
 * 
 */
package ma.jit.proxibanque.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Groupe D
 *
 */
@Entity
public class Agence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String adresse;
	
	@OneToOne(mappedBy = "agence",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private Gerant gerant;
	
	@OneToOne(mappedBy = "agence",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
	private CompteAgence compteAgence;
	
	
	
	/**
	 * 
	 */
	public Agence() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param nom
	 * @param adresse
	 * @param gerant
	 * @param compteAgence
	 */
	public Agence(String nom, String adresse, Gerant gerant, CompteAgence compteAgence) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.gerant = gerant;
		this.compteAgence = compteAgence;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}



	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}



	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}



	/**
	 * @return the compteAgence
	 */
	public CompteAgence getCompteAgence() {
		return compteAgence;
	}



	/**
	 * @param compteAgence the compteAgence to set
	 */
	public void setCompteAgence(CompteAgence compteAgence) {
		this.compteAgence = compteAgence;
	}

}

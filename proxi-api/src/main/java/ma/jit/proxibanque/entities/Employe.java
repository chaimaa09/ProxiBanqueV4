package ma.jit.proxibanque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employe {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	
	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	

	public Employe() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	

}

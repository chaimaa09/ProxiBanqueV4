/**
 * 
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Groupe D
 *
 */
@Entity
public class Client implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String ville;
    private String codePostale;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Compte> listeComptes = new ArrayList<Compte>();
    
	/**
	 * constructeur sans parametres
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructeur avec parametres
	 */
	public Client(String nom, String prenom, String email, String adresse, String ville, String codePostale,
			List<Compte> listeComptes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostale = codePostale;
		this.listeComptes = listeComptes;
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

}

/**
 * c'est une classe qui represente un client
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Groupe D
 *
 */
@Entity
@Table(name="client",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
	
	@Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String nom;
	
	@Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String prenom;
	
	@Size(min = 1, max = 50)
	private String adresse;
	
	@NotEmpty(message = "Email address cannot be empty")
    @Email(message = "Invalid email address, e.g. valid email address: example@gmail.com")
	private String email;
	
    private String ville;
    private String codePostale;
    
//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    private List<Compte> listeComptes = new ArrayList<Compte>();
    
    @OneToOne(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
    private CompteCourant compteCourant;
    
    @OneToOne(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
    private CompteEpargne compteEpargne;
    
    @ManyToOne
	@JoinColumn(name="code_conseiller")
    @JsonIgnoreProperties("clients")
    private Conseiller conseiller;
    
	/**
	 * constructeur sans parametres
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructeur avec parametres
	 */
//	public Client(String nom, String prenom, String email, String adresse, String ville, String codePostale,
//			List<Compte> listeComptes) {
//		super();
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//		this.adresse = adresse;
//		this.ville = ville;
//		this.codePostale = codePostale;
//		this.listeComptes = listeComptes;
//	}
	
	public Client(
			@Size(min = 1, max = 25) @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces") String nom,
			@Size(min = 1, max = 25) @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces") String prenom,
			@Size(min = 1, max = 50) String adresse,
			@NotEmpty(message = "Email address cannot be empty") @Email(message = "Invalid email address, e.g. valid email address: example@gmail.com") String email,
			String ville, String codePostale, CompteCourant compteCourant, CompteEpargne compteEpargne,
			Conseiller conseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.ville = ville;
		this.codePostale = codePostale;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.conseiller = conseiller;
	}

	/**
	 * @param code
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param email
	 * @param ville
	 * @param codePostale
	 * @param compteCourant
	 * @param compteEpargne
	 * @param conseiller
	 */
	public Client(Long code,
			@Size(min = 1, max = 25) @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces") String nom,
			@Size(min = 1, max = 25) @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces") String prenom,
			@Size(min = 1, max = 50) String adresse,
			@NotEmpty(message = "Email address cannot be empty") @Email(message = "Invalid email address, e.g. valid email address: example@gmail.com") String email,
			String ville, String codePostale, CompteCourant compteCourant, CompteEpargne compteEpargne,
			Conseiller conseiller) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.ville = ville;
		this.codePostale = codePostale;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.conseiller = conseiller;
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
	
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}
	
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}
	
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	
	public Conseiller getConseiller() {
		return conseiller;
	}
	
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email="
				+ email + ", ville=" + ville + ", codePostale=" + codePostale + ", compteCourant=" + compteCourant
				+ ", compteEpargne=" + compteEpargne + ", conseiller=" + conseiller + "]";
	}
	
	public void addCompte(CompteCourant compte) {
		this.setCompteCourant(compte);
        
        compte.setClient(this);
    }

//	@JsonIgnore
//	public List<Compte> getListeComptes() {
//		return listeComptes;
//	}
//
//	public void setListeComptes(List<Compte> listeComptes) {
//		this.listeComptes = listeComptes;
//	}
	
	

}

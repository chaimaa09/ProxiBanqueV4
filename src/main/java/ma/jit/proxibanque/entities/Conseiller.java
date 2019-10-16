/**
 * c'est une classe qui represente un conseiller
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Groupe D
 *
 */
@Entity
public class Conseiller implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String prenom;
	private String nom;
	private String login;
	private String password;
	
	@OneToMany(mappedBy = "conseiller",fetch=FetchType.LAZY)
	private List<Client> client;
	
	@ManyToOne
	@JoinColumn(name="code_gerant")
	private Gerant gerant;

	/**
	 * constructeur sans parametres
	 */
	public Conseiller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param prenom
	 * @param nom
	 * @param login
	 * @param password
	 * @param client
	 */
	public Conseiller(String prenom, String nom, String login, String password, List<Client> client) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the client
	 */
	public List<Client> getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(List<Client> client) {
		this.client = client;
	}

}

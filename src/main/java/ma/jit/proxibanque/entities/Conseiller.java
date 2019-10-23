/**
 * c'est une classe qui represente un conseiller
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Groupe D
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Conseiller extends Employe implements Serializable {
	
	private String login;
	private String password;
	
	@OneToMany(mappedBy = "conseiller",fetch=FetchType.LAZY)
	@JsonIgnoreProperties("conseiller")
	@JsonBackReference
	private List<Client> client;
	
	@ManyToOne
	@JoinColumn(name="code_gerant")
	private Gerant gerant;

	/**
	 * constructeur sans parametres
	 */
	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param prenom
	 * @param nom
	 * @param login
	 * @param password
	 * @param client
	 */
//	public Conseiller(String prenom, String nom, String login, String password, List<Client> client) {
//		super();
//		this.prenom = prenom;
//		this.nom = nom;
//		this.login = login;
//		this.password = password;
//		this.client = client;
//	}


	public Conseiller(String nom, String prenom, String login, String password, List<Client> client, Gerant gerant) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
		this.client = client;
		this.gerant = gerant;
	}




	public Conseiller() {
		// TODO Auto-generated constructor stub
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

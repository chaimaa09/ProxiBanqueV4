/**
 * c'est une classe qui represente un gerant
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class Gerant extends Employe implements Serializable {


	private String login;
	private String password;
	
	@OneToMany(mappedBy = "gerant",fetch=FetchType.LAZY)
	private List<Conseiller> conseiller = new ArrayList<Conseiller>();;
	/**
	 * constructeur sans parametres
	 */
	
	/**
	 * @param prenom
	 * @param nom
	 * @param login
	 * @param password
	 * @param conseiller
	 */
//	public Gerant(String prenom, String nom, String login, String password, List<Conseiller> conseiller) {
//		super();
//		this.prenom = prenom;
//		this.nom = nom;
//		this.login = login;
//		this.password = password;
//		this.conseiller = conseiller;
//	}
	
	public Gerant(String nom, String prenom) {
		super(nom, prenom);
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
	 * @return the conseiller
	 */
	public List<Conseiller> getConseiller() {
		return conseiller;
	}
	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(List<Conseiller> conseiller) {
		this.conseiller = conseiller;
	}
	

}

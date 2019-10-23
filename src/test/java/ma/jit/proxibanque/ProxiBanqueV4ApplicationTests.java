package ma.jit.proxibanque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ma.jit.proxibanque.dao.ClientRepository;
import ma.jit.proxibanque.entities.Client;
import ma.jit.proxibanque.entities.CompteCourant;
import ma.jit.proxibanque.entities.Conseiller;
import ma.jit.proxibanque.metier.IClientMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxiBanqueV4ApplicationTests {

	@Autowired
	private IClientMetier clientMetier;

	@MockBean
	private ClientRepository clientRepository;

	@Test
	public void listeClientsTest() {
		when(clientRepository.findAll()).thenReturn(Stream
				.of(new Client(1L, "karama", "basma", "lol", "bk@gmail.com", "casa", "2300", null, null, null),
						new Client(2L, "karam", "basim", "lol", "bki@gmail.com", "casa", "2300", null, null, null))
				.collect(Collectors.toList()));
		assertEquals(2, clientMetier.listeClients().size());
	}

	@Test
	public void ajouterClientTest() {
		Client client = new Client(1L, "karama", "basma", "lol", "bk@gmail.com", "casa", "2300");
		when(clientRepository.save(client)).thenReturn(client);
		assertEquals(client, clientMetier.ajouterClient( client));
	}

	@Test
	public void supprimerClientTest() {
		Client client = new Client(1L,"karama","basma","lol","bk@gmail.com","casa","2300", null, null, null);
		clientMetier.supprimerClient(1L);
		verify(clientRepository,times(1)).deleteById(1L);
	}

	@Test
	public void consulterClientTest() {
		Long id = 1L;
		Client client = new Client(1L, "karama", "basma", "lol", "bk@gmail.com", "casa", "2300", null, null, null);
		when(clientRepository.getOne(id)).thenReturn(client);
		assertEquals(client, clientMetier.consulterClient(id));

	}
//	@Test
//	public void ajouterClientTest() {
//	Client client = new Client();
////	CompteCourant compteCourant = new CompteCourant();
////	compteCourant.setSolde(500);
//	client.setNom("Abaach");
//	client.setPrenom("Mohammed");
//	client.setEmail("mohamed.abaach@gmail.com");
//	client.setAdresse("Casa");
////	client.setCompteCourant(compteCourant);
////	compteCourant.setClient(client);
//	Mockito.when(clientRepository.save(client)).thenReturn(client);
//	assertThat(clientMetier.ajouterClient(client)).isEqualTo(client);
//	}
	
	@Test
	public void ctest() {
		Client client = new Client();
		Conseiller conseiller = new Conseiller();
		CompteCourant compte = new CompteCourant();
		client.setNom("Abaach");
		client.setPrenom("Mohammed");
		client.setEmail("mohamed.abaach@gmail.com");
		client.setAdresse("Casa");
		client.setCodePostale("Casa");
        compte.setSolde(78);
//        compte.setDateCreation(new Date());
        client.setCompteCourant(compte);
        compte.setClient(client);
        conseiller.getClient().add(client);
        Mockito.when(clientRepository.save(client)).thenReturn(client);
        assertThat(clientMetier.ajouterClient(client)).isEqualTo(client);
	}
	
}

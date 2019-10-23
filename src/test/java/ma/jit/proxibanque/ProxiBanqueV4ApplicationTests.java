package ma.jit.proxibanque;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ma.jit.proxibanque.dao.ClientRepository;
import ma.jit.proxibanque.entities.Client;
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
				.of(new Client(1L, "baaziz", "chaimaa", "anfa", "chai@gmail.com", "casa", "2300", null, null, null),
						new Client(2L, "boo", "rania", "racine", "ran@gmail.com", "casa", "23900", null, null, null))
				.collect(Collectors.toList()));
		assertEquals(2, clientMetier.listeClients().size());
	}

	@Test
	public void ajouterClientTest() {
		Client client = new Client(1L, "baaziz", "chaimaa", "anfa", "chai@gmail.com", "casa", "2300");
		when(clientRepository.save(client)).thenReturn(client);
		assertEquals(client, clientMetier.ajouterClient( client));
	}

	@Test
	public void supprimerClientTest() {
		Client client = new Client(1L, "baaziz", "chaimaa", "anfa", "chai@gmail.com", "casa", "2300", null, null, null);
		clientMetier.supprimerClient(1L);
		verify(clientRepository,times(1)).deleteById(1L);
	}

	@Test
	public void consulterClientTest() {
		Long id = 1L;
		Client client = new Client(1L, "baaziz", "chaimaa", "anfa", "chai@gmail.com", "casa", "2300", null, null, null);
		when(clientRepository.getOne(id)).thenReturn(client);
		assertEquals(client, clientMetier.consulterClient(id));

	}

	@Test
	public void updateClientTest() {
	    Client oldClient = new Client(1L, "baa", "chaima", "maarif", "baa@g;com", "casa", "1223");
	    when(clientRepository.getOne(1L)).thenReturn(oldClient);
	    System.out.println(oldClient.toString());
	    oldClient.setCode(2L);
	    oldClient.setNom("baaziz");
	    oldClient.setPrenom("chaimaa");
	    oldClient.setAdresse("anfa");
	    oldClient.setEmail("chaimaa@gmail.com");
	    
	    Client newClient = oldClient;
	    System.out.println(oldClient.toString());
	    
	    when(clientRepository.save(oldClient)).thenReturn(oldClient);
	    assertEquals(newClient, clientMetier.ajouterClient(oldClient));
	}
	
}

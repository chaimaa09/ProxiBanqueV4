package ma.jit.proxibanque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProxiBanqueV4Application {
	 private static final Logger logger = (Logger) LogManager.getLogger();
	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueV4Application.class, args);	 
		
		   logger.info("test");		
		
	}

}

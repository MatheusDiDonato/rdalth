package sp.gov.br.iamspe.sabi.rdalth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories(basePackages = "sp.gov.br.iamspe.sabi.rdalth.repository")
public class RdalthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdalthApplication.class, args);
	}

}

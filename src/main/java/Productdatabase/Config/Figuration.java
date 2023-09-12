package Productdatabase.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "Productdatabase")
public class Figuration {
	@Bean
	public EntityManager getem()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sridhar");
		EntityManager em=emf.createEntityManager();
		return em;
	}

	}



package co.edu.usbcali.projectmanager.fcd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:errmessages.properties")
@ComponentScan("co.edu")
@EnableJpaRepositories("co.edu.usbcali.projectmanager")
@EntityScan("co.edu")
@PropertySource(value ={"file:${co.edu.usbcali.projectmanager.home}/application.properties"}, ignoreResourceNotFound = true)
public class Application {

	public static final String ENV_PATH = "co.edu.usbcali.projectmanager.home";

public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}

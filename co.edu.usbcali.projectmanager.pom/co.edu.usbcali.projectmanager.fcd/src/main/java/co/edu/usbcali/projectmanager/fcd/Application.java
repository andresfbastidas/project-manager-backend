package co.edu.usbcali.projectmanager.fcd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@PropertySource("classpath:errmessages.properties")
@ComponentScan("co.edu")
@PropertySource(value ={"file:${co.edu.usbcali.projectmanager.home}/application.properties"}, ignoreResourceNotFound = true)
public class Application {
	
	public static final String ENV_PATH = "co.edu.usbcali.projectmanager.home";
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}

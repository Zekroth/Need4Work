package it.itsrizzoli.N4W.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class N4WApplication {

	public static void main(String[] args) {
		SpringApplication.run(N4WApplication.class, args);
	}

}

package br.gov.sp.fatec.bptopics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BptopicsApplication {

	public static void main(String[] args) {
		// run with: mvn spring-boot:run
		// to access controllers via REST: https://8080-barbaraport-bptopics-78ip1ooq506.ws-us67.gitpod.io/
		// username: admin
		// password: admin
		// Authorization Bearer {token}
		SpringApplication.run(BptopicsApplication.class, args);
	}

}

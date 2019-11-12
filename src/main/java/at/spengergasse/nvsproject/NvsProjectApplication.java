package at.spengergasse.nvsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NvsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NvsProjectApplication.class, args);
	}

}

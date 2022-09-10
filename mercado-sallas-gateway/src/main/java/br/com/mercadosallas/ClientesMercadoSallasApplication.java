package br.com.mercadosallas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientesMercadoSallasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesMercadoSallasApplication.class, args);
	}

}

package com.proyectocabin.proyectojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProyectoJpaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProyectoJpaApplication.class);
		Environment env = app.run(args).getEnvironment();
		System.out.println("Server Port: " + env.getProperty("server.port"));


	}

}

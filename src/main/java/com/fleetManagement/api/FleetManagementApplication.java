package com.fleetManagement.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class FleetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetManagementApplication.class, args);
	}

@Bean
public OpenAPI headOpenApi() {
	return new OpenAPI()
			.info(new Info()
					.title("FleetManagement<<REST API>>")
					.version("0,1")
					.description("REST API with Spring Boot for querying taxis locations"));
	//uno
        }
}
package com.vwits.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.vwits.accounts.controller") })
@EnableJpaRepositories("com.vwits.accounts.repository")
@EntityScan("com.vwits.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "EazyBank Accounts microservice REST API Documentation",
				version = "v2.0",
				contact = @Contact(
						name = "Shubham Thakur",
						email = "shubhamthakur614@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "EazyBank Accounts microservice REST API Documentation",
				url = ""
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

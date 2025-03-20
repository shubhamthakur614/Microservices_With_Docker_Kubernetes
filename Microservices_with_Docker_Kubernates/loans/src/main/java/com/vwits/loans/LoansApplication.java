package com.vwits.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.vwits.loans.controller") })
@EnableJpaRepositories("com.vwits.loans.repository")
@EntityScan("com.vwits.loans.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = " Loans microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
						name = "Shubham Thakur",
						email = "shubhamthakur614@gmail.com",
                        url = ""
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Loans microservice REST API Documentation",
                url = "https://github.com/shubhamthakur614/Microservices_With_Docker_Kubernetes/tree/master/Microservices_with_Docker_Kubernates/loans"
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }
}
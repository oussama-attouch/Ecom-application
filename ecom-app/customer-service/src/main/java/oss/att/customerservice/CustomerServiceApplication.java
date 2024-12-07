package oss.att.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import oss.att.customerservice.config.CustomerConfigParams;
import oss.att.customerservice.entities.Customer;
import oss.att.customerservice.repositories.CustomerRepository;

import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class  CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repoRestConfiguration) {
		return args -> {
			repoRestConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(Customer.builder()
					.name("o1")
					.email("o1@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("o2")
					.email("o2@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("o3")
					.email("3@gmail.com")
					.build());
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}

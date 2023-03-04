package com.example.demo;

import com.example.demo.Customer.Customer;
import com.example.demo.Customer.CustomerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class PdmBookingSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(PdmBookingSystemApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
//		return args -> {
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("Customer.json");
//
//			try{
//				List<Customer> customers = mapper.readValue(inputStream, typeReference);
//				customerRepository.saveAll(customers);
//				System.out.println("Customers Saved!");
//			}catch (Exception e){
//				System.out.println("Unable to save customer: " + e.getMessage());
//			}
//		};
//	}
}

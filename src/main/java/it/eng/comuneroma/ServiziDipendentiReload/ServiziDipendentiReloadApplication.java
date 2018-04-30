package it.eng.comuneroma.ServiziDipendentiReload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import it.eng.comuneroma.ServiziDipendentiReload.entity.Customer;
import it.eng.comuneroma.ServiziDipendentiReload.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Stream;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ServiziDipendentiReloadApplication {

	private static final Logger log = LoggerFactory.getLogger(ServiziDipendentiReloadApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ServiziDipendentiReloadApplication.class, args);
	}
	
//	@Bean
//	public ServiziDipendentiReloadApplication demo(CustomerRepository repository) {
//
//			log.info("DEMOOOO!!!");
//			
//			return new ServiziDipendentiReloadApplication();
//					
//	}
	
	@Bean	
	public CommandLineRunner demo(CustomerRepository repository) {
					
		return (args) -> {
			
			
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
			
			long conteggio = repository.countByLastName("Bauer");
			
			log.info("conteggio Bauer:" + conteggio);
			
			
			repository.findCustomerDistinctByLastNameOrFirstName("Bauer","Kim").forEach(bauer -> {
				log.info(bauer.toString());
			});			
			
		
			
			
			repository.find("Bauer","Kim").forEach(bauer -> {
				log.info(bauer[0].toString() + '-' + bauer[1].toString());
			});		
			
		
			
			repository.findFirst11ByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.getFirstName()+ '-' + bauer.getLastName());
			});	
//			

//			try (Stream<Customer> stream = repository.readAllByFirstNameNotNull()) {
//				  stream.iterator(); 
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}


			
		};		
		
		 
	}
}

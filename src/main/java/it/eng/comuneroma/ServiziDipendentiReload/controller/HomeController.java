package it.eng.comuneroma.ServiziDipendentiReload.controller;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.eng.comuneroma.ServiziDipendentiReload.ServiziDipendentiReloadApplication;
import it.eng.comuneroma.ServiziDipendentiReload.entity.Customer;
import it.eng.comuneroma.ServiziDipendentiReload.repository.CustomerRepository;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/home")
	@Transactional
	public String helloWorld() {
 
		try (Stream<Customer> stream = repository.readAllByFirstNameNotNull()) {
			stream.forEach(bauer -> {
				log.info(bauer.getFirstName() + '-' + bauer.getLastName());
			});		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "home";
	}
	
}

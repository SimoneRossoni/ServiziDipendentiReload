package it.eng.comuneroma.serviziDipendentiReload.avvisi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.eng.comuneroma.serviziDipendentiReload.avvisi.entity.Avvisi;
import it.eng.comuneroma.serviziDipendentiReload.avvisi.service.AvvisiService;

@RestController
@RequestMapping("/avvisi")
public class RestAvvisiController {
	public static final Logger logger = LoggerFactory.getLogger(RestAvvisiController.class);

    @Autowired
    AvvisiService avvisiService;	
    
    //@Autowired
    //UserService userService;
    
    // -------------------Restituisce tutti gli avvisi -------------------------------------------    
    @RequestMapping(value = "/getAll/", method = RequestMethod.GET)
    public ResponseEntity<List<Avvisi>> listAllAvvisi() {
        
    	logger.debug("chiamata metodo listAllAvvisi - INIZIO");
    	logger.info("chiamata metodo listAllAvvisi - INIZIO");
    	
    	List<Avvisi> avvisi = avvisiService.findAllAvvisi();
        
        if (avvisi.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        
        logger.debug("chiamata metodo listAllAvvisi - FINE");       
        return new ResponseEntity<List<Avvisi>>(avvisi, HttpStatus.OK);
    	
    }   
	
    // -------------------Retrieve All Users---------------------------------------------    
//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if (users.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            // You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    } 	
}

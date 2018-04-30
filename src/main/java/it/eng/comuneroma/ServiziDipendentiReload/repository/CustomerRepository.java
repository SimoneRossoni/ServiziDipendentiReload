package it.eng.comuneroma.ServiziDipendentiReload.repository;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.eng.comuneroma.ServiziDipendentiReload.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
	
	long countByLastName(String lastName);
	
	List<Customer> findCustomerDistinctByLastNameOrFirstName(String lastName, String firstName);
	
    @Query("SELECT distinct p.lastName, p.firstName FROM Customer p WHERE LOWER(p.lastName) = LOWER(:lastName) or LOWER(p.firstName) = LOWER(:firstName)")
    public List<Object[]> find(@Param("lastName") String lastName, @Param("firstName") String firstName);
    
    List<Customer> findDistinctByLastName(String lastName);
	
    List<Customer> findFirst11ByLastName(String lastName);
    
    Stream<Customer> readAllByFirstNameNotNull();
}

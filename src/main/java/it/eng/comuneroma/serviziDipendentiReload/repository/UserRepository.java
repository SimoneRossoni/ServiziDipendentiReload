package it.eng.comuneroma.serviziDipendentiReload.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eng.comuneroma.serviziDipendentiReload.entity.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
    User findByName(String name);
 
}

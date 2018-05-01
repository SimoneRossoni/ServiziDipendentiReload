package it.eng.comuneroma.ServiziDipendentiReload.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eng.comuneroma.ServiziDipendentiReload.entity.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
    User findByName(String name);
 
}

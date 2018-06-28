package it.eng.comuneroma.serviziDipendentiReload.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.eng.comuneroma.serviziDipendentiReload.security.entity.RolesDipendenti;



public interface RolesDipendentiRepository extends CrudRepository<RolesDipendenti, Long> {

	@Query("select a.id.role from RolesDipendenti a where a.id.cddipend=:username")
    List<RolesDipendenti> findRoleByCddipend( @Param("username") String username );    

    
}

package it.eng.comuneroma.serviziDipendentiReload.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.eng.comuneroma.serviziDipendentiReload.security.entity.AnagraficaGenerale;


public interface AnagraficaGeneraleRepository extends CrudRepository<AnagraficaGenerale, Long>{

    @Query("SELECT distinct a.cddipend,a.nome,a.cognome FROM AnagraficaGenerale a WHERE LOWER(a.codFiscale) = LOWER(:codFiscale) ")
    public List<Object[]> find(@Param("codFiscale") String cod_fiscale);
    
    List<AnagraficaGenerale> findDistinctByCodFiscale( String cod_fiscale);    
}

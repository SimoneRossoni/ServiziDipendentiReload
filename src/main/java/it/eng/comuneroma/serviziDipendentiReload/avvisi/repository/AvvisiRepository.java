package it.eng.comuneroma.serviziDipendentiReload.avvisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eng.comuneroma.serviziDipendentiReload.avvisi.entity.Avvisi;

public interface AvvisiRepository extends JpaRepository<Avvisi, Long> {

}

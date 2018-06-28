package it.eng.comuneroma.serviziDipendentiReload.avvisi.service;

import java.util.List;

import it.eng.comuneroma.serviziDipendentiReload.avvisi.entity.Avvisi;

public interface AvvisiService {

	List<Avvisi> findAllAvvisi();
}

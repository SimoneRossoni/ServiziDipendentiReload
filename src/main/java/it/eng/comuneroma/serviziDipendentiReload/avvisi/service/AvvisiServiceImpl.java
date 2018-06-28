package it.eng.comuneroma.serviziDipendentiReload.avvisi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.eng.comuneroma.serviziDipendentiReload.avvisi.entity.Avvisi;
import it.eng.comuneroma.serviziDipendentiReload.avvisi.repository.AvvisiRepository;

@Service("avvisiService")
@Transactional
public class AvvisiServiceImpl implements AvvisiService{

    @Autowired
    private AvvisiRepository avvisiRepository;
    
	@Override
	public List<Avvisi> findAllAvvisi() {
		return (List<Avvisi>) avvisiRepository.findAll();
	}

}

package it.eng.comuneroma.serviziDipendentiReload.security;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.eng.comuneroma.serviziDipendentiReload.security.domain.Dipendente;
import it.eng.comuneroma.serviziDipendentiReload.security.domain.PortalDipendente;
import it.eng.comuneroma.serviziDipendentiReload.security.entity.AnagraficaGenerale;
import it.eng.comuneroma.serviziDipendentiReload.security.entity.RolesDipendenti;
import it.eng.comuneroma.serviziDipendentiReload.security.repository.AnagraficaGeneraleRepository;
import it.eng.comuneroma.serviziDipendentiReload.security.repository.RolesDipendentiRepository;
import it.eng.comuneroma.serviziDipendentiReload.security.service.RicercaUtenteOnMassenzioService;
import it.eng.comuneroma.serviziDipendentiReload.security.util.PersonaXMLParser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	RicercaUtenteOnMassenzioService ricercaUtenteOnMassenzioService;

	@Autowired
	AnagraficaGeneraleRepository anagraficaGeneraleRepository;
	
	@Autowired
	RolesDipendentiRepository rolesDipendentiRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SecurityContextHolder.getContext().getAuthentication();
		Dipendente dip = null;
		PortalDipendente cu =null;

		SecurityContextHolder.getContext().getAuthentication();
		
		/*
		 * Here we are using dummy data, you need to load user data from database or
		 * other third party application
		 */
//		User user = findUserbyUsername(username);

		
		
		// SecurityContextHolder.getContext().getAuthentication();

//		UserBuilder builder = null;
		if (username != null) {
//			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//			builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//			builder.roles(user.getRoles());

			// richiamo la servlet per ottenere i dati utente in base all'username
			byte[] xmlPersona = ricercaUtenteOnMassenzioService.getXMLPersona(username);

			if (xmlPersona != null) {
				PersonaXMLParser parser = new PersonaXMLParser();
				
				dip = parser.getDipendente(xmlPersona);
				
				if (dip == null) {
					//logger.info(this.messageResourcesSpring.getMessage(this.MSG_LOG, null, null) + "AccessoDaPortale: KO - utente " + username + " non trovato su MASSENZIO");
					throw new AccessDeniedException("User not found");
				}					
			}

			String codiceFiscaleUser = "";
			
			
			if (dip != null) {
				// modifica per utente di test cambio codice fiscale di Brusca
				// Davide
				if ("BRSDVD72A05G698X".equals(dip.getCodiceFiscale()))
					dip.setCodiceFiscale("DLFSSY73C64C034K");
				// fine modifica

				codiceFiscaleUser = dip.getCodiceFiscale();

				// this.email = dip.getEmail();
				String email = dip.getEmail();
				
				//recuero il cddipend (che rappresenta lo username) dall'anagrafica_generale
				List<AnagraficaGenerale>listaAnagraficaGenerale = anagraficaGeneraleRepository.findDistinctByCodFiscale(codiceFiscaleUser);
				
				if(listaAnagraficaGenerale!=null && listaAnagraficaGenerale.size()>0)
				{
					String cddipend = String.valueOf(listaAnagraficaGenerale.get(0).getCddipend());
					
					//recupero la lista dei ruoli dalla tabella roles_dipendenti
					List<RolesDipendenti> ruoli = rolesDipendentiRepository.findRoleByCddipend(cddipend);
				
					String roles=StringUtils.collectionToCommaDelimitedString(ruoli);
					List<GrantedAuthority> ruoliXAutorities = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
					
					//creo l'oggetto che rappresenta il nostro "PRINCIPAL"
					cu = new PortalDipendente(cddipend,"iv-user-cdr", true, ruoliXAutorities , dip.getNome(), dip.getCognome(), dip.getCodiceFiscale(), dip.getUsername(), dip.getEmail(), new Date(), new Date());
				}
				else
				{
					throw new UsernameNotFoundException("User not found.");
				}
				
				//List<AnagraficaGenerale> listaAnagrafica = userRepository.findDistinctByCodFiscale(codiceFiscaleUser);
				
				//System.out.println(test);
			}
			
			
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		//return builder.build();
		return cu;
	}

//	private User findUserbyUsername(String username) {
//
//		if (username.equalsIgnoreCase("giovanni.riu")) {
//			return new User(username, "iv-user-cdr", "DIRIGENTE");
//		} else if (username.equalsIgnoreCase("cinzia.capotosti")) {
//			return new User(username, "iv-user-cdr", "DIPENDENTE");
//		}
//
//		return null;
//	}
}
package it.eng.comuneroma.serviziDipendentiReload.security.domain;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;




public class PortalDipendente extends User {

	
	private static final long serialVersionUID = 346769626328336305L;
		private String nome;
		private String cognome;
		private String codiceFiscale;
		private String portalUsername;
		private String email;
		private Date datacreazione;
		private Date datamodifica; 
		private String isModalitaDemo;
		
		public PortalDipendente(String username, String password, boolean isEnabled, Collection<? extends GrantedAuthority> authorities, String nome, String cognome,String codiceFiscale, String portalUsername,String email, Date datacreazione, Date datamodifica){
			super(username, password, isEnabled, true, true, true, authorities);
			this.nome = nome;
			this.cognome = cognome;
			this.portalUsername = portalUsername;
			this.email = email;
			this.codiceFiscale = codiceFiscale;
			this.datacreazione = datacreazione;
			this.datamodifica = datamodifica;
		}

//		public PortalDipendente(String username, String nome, String cognome, String codiceFiscale,String portalUsername,String email, Date datacreazione, Date datamodifica) {
//		        this(u.getUsername(), u.getPassword(), u.isEnabled(), u.getAuthorities(), nome, cognome, codiceFiscale,portalUsername, email, datacreazione, datamodifica);
//		        
//		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public Date getDatacreazione() {
			return datacreazione;
		}

		public void setDatacreazione(Date datacreazione) {
			this.datacreazione = datacreazione;
		}

		public Date getDatamodifica() {
			return datamodifica;
		}

		public void setDatamodifica(Date datamodifica) {
			this.datamodifica = datamodifica;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
 
		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}
		  
		/*
		 * metodo inserito per sovrascrivere
		 * il vecchio metodo del Bean Dipendente
		*/
		public int getCdDipend() {
			return Integer.parseInt(this.getUsername());
		}
        // campo aggiunto perchè nella tabella dei ruoli username è il cddipend
		public String getPortalUsername() {
			return portalUsername;
		}

		public void setPortalUsername(String portalUsername) {
			this.portalUsername = portalUsername;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getIsModalitaDemo() {
			return isModalitaDemo;
		}

		public void setIsModalitaDemo(String isModalitaDemo) {
			this.isModalitaDemo = isModalitaDemo;
		}
		
	    public boolean hasRole(String role) {
	        // get security context from thread local
	    	Collection<GrantedAuthority> ruoli = super.getAuthorities();

			for (Iterator<GrantedAuthority> iterator = ruoli.iterator(); iterator.hasNext();) {
				GrantedAuthority ruolo = iterator.next();
	
				if (ruolo.getAuthority().equals(role)) {
					return true;
				}
			}
	    	
	        return false;
	    }		
	}

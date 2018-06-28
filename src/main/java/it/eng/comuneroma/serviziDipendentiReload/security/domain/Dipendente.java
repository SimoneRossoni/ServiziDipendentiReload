package it.eng.comuneroma.serviziDipendentiReload.security.domain;

import java.io.Serializable;

public class Dipendente implements Serializable {

	private static final long serialVersionUID = -568184432020127021L;
	
	private int azienda;
	private int cdDipend;
	private String cognome;
	private String nome;
	private String codiceFiscale;
	private String email;
	private String username;
	private String struttura;
	public int getAzienda() {
		return azienda;
	}
	public void setAzienda(int azienda) {
		this.azienda = azienda;
	}
	public int getCdDipend() {
		return cdDipend;
	}
	public void setCdDipend(int cdDipend) {
		this.cdDipend = cdDipend;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStruttura() {
		return struttura;
	}
	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}
	
	
}

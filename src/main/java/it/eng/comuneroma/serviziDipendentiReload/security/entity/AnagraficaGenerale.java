package it.eng.comuneroma.serviziDipendentiReload.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anagrafica_generale")
public class AnagraficaGenerale {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "cddipend")
    private Long cddipend;
    
    @Column(name = "cognome")
    private String cognome;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "cod_fiscale")
    private String  codFiscale;
    
	public Long getCddipend() {
		return cddipend;
	}

	public void setCddipend(Long cddipend) {
		this.cddipend = cddipend;
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

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}    
    
    
}

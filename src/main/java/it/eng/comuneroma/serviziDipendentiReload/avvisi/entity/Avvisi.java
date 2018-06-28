package it.eng.comuneroma.serviziDipendentiReload.avvisi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Avvisi {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "idAvviso")
    private Long id;
    
    @Column(name = "ordine")
    private Long ordine;
    
    @Column(name = "visibile")
    private Long visibile;        
       
    @Lob
    @Column(length=10000,name="descrizione")
    private byte[] descrizione;    
 
    @Lob
    @Column(length=10000, name="allegato")
    private byte[] allegato;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrdine() {
		return ordine;
	}

	public void setOrdine(Long ordine) {
		this.ordine = ordine;
	}

	public Long getVisibile() {
		return visibile;
	}

	public void setVisibile(Long visibile) {
		this.visibile = visibile;
	}

	public byte[] getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(byte[] descrizione) {
		this.descrizione = descrizione;
	}

	public byte[] getAllegato() {
		return allegato;
	}

	public void setAllegato(byte[] allegato) {
		this.allegato = allegato;
	}
  
        
}

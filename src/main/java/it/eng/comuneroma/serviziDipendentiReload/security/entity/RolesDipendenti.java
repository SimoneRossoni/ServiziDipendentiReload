package it.eng.comuneroma.serviziDipendentiReload.security.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.eng.comuneroma.serviziDipendentiReload.security.domain.RolesDipendentiPk;

@Entity
@Table(name = "ROLES_DIPENDENTI")
public class RolesDipendenti {

    @EmbeddedId
    private RolesDipendentiPk id;


	@Column(name = "date_created")
	private Date dataCreated;

	@Column(name = "cod_str_resp")
	private String codStrResp;

	public RolesDipendentiPk getId() {
		return id;
	}

	public void setId(RolesDipendentiPk id) {
		this.id = id;
	}

	public Date getDataCreated() {
		return dataCreated;
	}

	public void setDataCreated(Date dataCreated) {
		this.dataCreated = dataCreated;
	}

	public String getCodStrResp() {
		return codStrResp;
	}

	public void setCodStrResp(String codStrResp) {
		this.codStrResp = codStrResp;
	}



}

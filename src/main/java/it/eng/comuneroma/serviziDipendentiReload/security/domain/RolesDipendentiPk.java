package it.eng.comuneroma.serviziDipendentiReload.security.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RolesDipendentiPk implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cddipend")
    private String cddipend;
    
    @Column(name = "role")
    private String role;
 
    @Column(name = "is_role_enabled")
    private String isRoleEnabled;

	public String getCddipend() {
		return cddipend;
	}

	public void setCddipend(String cddipend) {
		this.cddipend = cddipend;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsRoleEnabled() {
		return isRoleEnabled;
	}

	public void setIsRoleEnabled(String isRoleEnabled) {
		this.isRoleEnabled = isRoleEnabled;
	}    
        
}

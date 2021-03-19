package ec.edu.uce.comiteEtica.jsf.springSecutiry;

import org.springframework.security.core.GrantedAuthority;

public class ProveedorPermisos implements GrantedAuthority {
	private static final long serialVersionUID = 8645782513098410909L;
	private String rol;

	public ProveedorPermisos(String rol) {

		this.rol = rol;
	}

	@Override
	public String getAuthority() {

		return "ROLE_" + rol;
	}
}
package udemy.aplicacion.services;

import udemy.aplicacion.dto.LoginRequest;
import udemy.aplicacion.dto.LoginResponse;
import udemy.aplicacion.persistence.entities.Usuario;

public interface UsuarioService {
	
	public LoginResponse login(LoginRequest request);
	public Usuario registro(Usuario usuario);

}

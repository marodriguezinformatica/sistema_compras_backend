package udemy.aplicacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import udemy.aplicacion.dto.LoginRequest;
import udemy.aplicacion.dto.LoginResponse;
import udemy.aplicacion.persistence.entities.Usuario;
import udemy.aplicacion.persistence.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public LoginResponse login(LoginRequest request) {
		/*Usuario usuario = usuarioRepository.findByUsernameAndPassword(request.getUsername(),request.getPassword());
		return usuario;*/
		 Usuario usuario = usuarioRepository
			        .findByUsername(request.getUsername());
		 
		 	if (usuario == null) {
		        throw new RuntimeException("Usuario no existe");
		    }
			      
			    if (!passwordEncoder.matches(
			            request.getPassword(),
			            usuario.getPassword()
			    )) {
			        throw new RuntimeException("Password incorrecto");
			    }

			    return new LoginResponse(usuario.getId(), usuario.getUsername(), usuario.getNombre() );
	}

	@Override
	public Usuario registro(Usuario usuario) {
		usuario.setPassword(
		        passwordEncoder.encode(usuario.getPassword())
		    );
		    return usuarioRepository.save(usuario);
	}

}

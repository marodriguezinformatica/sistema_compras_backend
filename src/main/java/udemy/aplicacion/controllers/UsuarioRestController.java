package udemy.aplicacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import udemy.aplicacion.dto.LoginRequest;
import udemy.aplicacion.dto.LoginResponse;
import udemy.aplicacion.persistence.entities.Usuario;
import udemy.aplicacion.services.UsuarioService;


@RestController
@RequestMapping("auth")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request){
		LoginResponse usuario = usuarioService.login(request);
		
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("registro")
	public ResponseEntity<?> registro(@RequestBody Usuario usuario){
		Usuario usu = usuarioService.registro(usuario);
		return ResponseEntity.ok(usu);
	}
	

}

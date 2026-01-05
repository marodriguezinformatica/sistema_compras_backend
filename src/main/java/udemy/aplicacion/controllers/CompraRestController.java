package udemy.aplicacion.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import udemy.aplicacion.dto.CompraRequest;
import udemy.aplicacion.persistence.entities.Compra;
import udemy.aplicacion.services.CompraService;


@RestController
@RequestMapping("/compras")
public class CompraRestController {
	
	@Autowired
	private CompraService compraService;
	
	@GetMapping
	public ResponseEntity<?> getCompras(@RequestParam String username){
		List<Compra> compras = compraService.getCompras(username);
		
		return ResponseEntity.ok(compras);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCompra(@PathVariable int id){
		Compra compra = compraService.getCompra(id);
		
		return ResponseEntity.ok(compra);
	}
	
	@PostMapping
	public ResponseEntity<?> addCompra(@Valid @RequestBody CompraRequest request){
		Compra c = compraService.addCompra(request);
		return ResponseEntity.ok(c);
	}
	
	/*@PutMapping
	public ResponseEntity<?> updateCompra(@RequestBody Compra compra){
		Compra c = compraService.updateCompra(compra);
		return ResponseEntity.ok(c);
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCompra(
	        @PathVariable int id,
	        @RequestBody Compra compra) {

	    compra.setId(id);
	    return ResponseEntity.ok(compraService.updateCompra(compra));
	}

	
	/*@DeleteMapping
	public ResponseEntity<?> deleteCompra(@RequestParam int id){
		Compra compra = compraService.deleteCompra(id);
		return ResponseEntity.ok(compra);
	}*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompra(@PathVariable int id) {
	    return ResponseEntity.ok(compraService.deleteCompra(id));
	}

	

}

package udemy.aplicacion.services;

import java.util.List;

import udemy.aplicacion.dto.CompraRequest;
import udemy.aplicacion.persistence.entities.Compra;
import udemy.aplicacion.persistence.entities.Usuario;
public interface CompraService {

	List<Compra> getCompras(String username);
	Compra getCompra(int id);
	Compra addCompra(CompraRequest request);
	Compra updateCompra(Compra compra);
	Compra deleteCompra(int id);
	
}

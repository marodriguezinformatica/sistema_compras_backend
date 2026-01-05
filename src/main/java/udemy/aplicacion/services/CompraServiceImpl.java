package udemy.aplicacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.aplicacion.dto.CompraRequest;
import udemy.aplicacion.persistence.entities.Compra;
import udemy.aplicacion.persistence.entities.Usuario;
import udemy.aplicacion.persistence.repositories.CompraRepository;
import udemy.aplicacion.persistence.repositories.UsuarioRepository;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Compra> getCompras(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		List<Compra> compras = compraRepository.findAllByUsuario(usuario);
		return compras;
	}

	@Override
	public Compra addCompra(CompraRequest request) {
		Usuario usuario = usuarioRepository.findById(request.getUsuario_id()).orElseThrow();
		Compra compra = new Compra();
		compra.setTitulo(request.getTitulo());
		compra.setComentarios(request.getComentarios());
		compra.setFecha(request.getFecha());
		compra.setLista(request.getLista());
		compra.setTienda(request.getTienda());
		compra.setUsuario(usuario);
		Compra comp = compraRepository.save(compra);
		return comp;
	}

	@Override
	public Compra updateCompra(Compra compra) {
		Compra c = compraRepository.findById(compra.getId()).orElseThrow();
		if (c != null) {
			c.setTitulo(compra.getTitulo());
			c.setLista(compra.getLista());
			c.setTienda(compra.getTienda());
			c.setFecha(compra.getFecha());
			c.setComentarios(compra.getComentarios());
			return compraRepository.save(c);
		}
		return null;
		
	}

	@Override
	public Compra deleteCompra(int id) {
		Compra c = compraRepository.findById(id).orElseThrow();
		if (c != null) {
			compraRepository.delete(c);
			return c;
		}
		return null;
		
	}

	@Override
	public Compra getCompra(int id) {
		Compra c = compraRepository.findById(id).orElseThrow();
		
		if (c != null) {
			return c;
		}
		return null;
	}

}

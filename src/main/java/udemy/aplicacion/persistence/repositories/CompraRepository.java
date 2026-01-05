package udemy.aplicacion.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udemy.aplicacion.persistence.entities.Compra;
import udemy.aplicacion.persistence.entities.Usuario;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer>{
	
	List<Compra> findAllByUsuario(Usuario usuario);

}

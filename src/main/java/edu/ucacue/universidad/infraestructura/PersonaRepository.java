package edu.ucacue.universidad.infraestructura;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 
import edu.ucacue.universidad.modelo.universidad;

 
public interface PersonaRepository  extends JpaRepository<universidad, Integer>{

	List<universidad> findByNombreLike(String id);
	 List<universidad> findByNombreAndApellido(String nombre, String apellido);

	 List<universidad> findByNombre(String nombre);
	// JPQL
		 
		
		@Query("select p from Persona p where p.apellido like :nombre")
		List<universidad> buscarPorNombreLike(@Param("id") String id);
		
	}
 

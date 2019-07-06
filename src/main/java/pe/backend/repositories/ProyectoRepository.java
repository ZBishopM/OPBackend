package pe.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Proyecto;

@Repository
public interface ProyectoRepository 
				extends JpaRepository<Proyecto, Integer> {
	
    public Optional<List<Proyecto>> getProyectosFromSueldo(double sueldo);		
    public List<Proyecto> getProyectosFromTipo(String tipoProyecto);	
	
	public Proyecto findProyectoByName(String name);

}

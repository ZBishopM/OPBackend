package pe.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Proyecto;

@Repository
public interface ProyectoRepository 
				extends JpaRepository<Proyecto, Integer> {
	
    public List<Proyecto> getProyectosFromSueldo(float id);		
    public List<Proyecto> getProyectosFromTipo(String id);	
	
	public Proyecto findProyectoByName(String name);

}

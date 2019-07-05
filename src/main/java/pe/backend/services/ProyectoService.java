package pe.backend.services;

import java.util.List;
import java.util.Optional;

import pe.backend.entities.Proyecto;

public interface ProyectoService {
	
	public boolean insertar(Proyecto entity);
	
	public List<Proyecto> listarTodas();
	
	public Optional<Proyecto> buscarPorID(int id);
	
	public boolean actualizar(Proyecto entity);
	
	public boolean eliminar(int id);

    public List<Proyecto> getProyectosFromSueldo(float id);		
    public List<Proyecto> getProyectosFromTipo(String id);	
	
	
	public Proyecto findProyectoByName(String name);

}

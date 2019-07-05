package pe.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.backend.entities.Proyecto;
import pe.backend.entities.Team;
import pe.backend.repositories.ProyectoRepository;
import pe.backend.services.ProyectoService;
import pe.backend.services.TeamService;


@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	ProyectoRepository ProyectoRepo;
	

	@Override
	public boolean insertar(Proyecto entity) {
		boolean flag = false;
		if (ProyectoRepo.findProyectoByName(entity.getNombre())==null)
		{
			try {
				ProyectoRepo.save(entity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {System.out.println("Jugador con el mismo nombre");}
		
		return flag;
	}

	@Override
	public List<Proyecto> listarTodas() {
        List<Proyecto> aux = ProyectoRepo.findAll();	
        System.out.println("Luego");
        System.out.println(aux);
		return aux;
	}



	@Override
	public boolean eliminar(int id) {
		return false;
	}
	

	@Override
	public Proyecto findProyectoByName(String name) {
		Proyecto Proyecto = new Proyecto();
		Proyecto = ProyectoRepo.findProyectoByName(name);
		return Proyecto;
	}

    @Override
    public Optional<Proyecto> buscarPorID(int id) {
        return null;
    }

    @Override
    public boolean actualizar(Proyecto entity) {
        return false;
    }

    @Override
    public List<Proyecto> getProyectosFromSueldo(float id) {
        List<Proyecto> aux = ProyectoRepo.getProyectosFromSueldo(id);	
		return aux;
    }

    @Override
    public List<Proyecto> getProyectosFromTipo(String id) {
        List<Proyecto> aux = ProyectoRepo.getProyectosFromTipo(id);	
		return aux;
    }
	
	
}

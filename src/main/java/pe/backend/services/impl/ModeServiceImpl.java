package pe.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.backend.entities.Mode;
import pe.backend.repositories.ModeRepository;
import pe.backend.services.ModeService;

@Service
public class ModeServiceImpl implements ModeService {
	@Autowired
	ModeRepository modeRepo;
	@Override
	public boolean insertar(Mode objMode) {
		boolean flag = false;
		try {
			if(modeRepo.save(objMode) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Mode> listarTodas() {
		// TODO Auto-generated method stub
		return modeRepo.findAll();
	}

	@Override
	public Optional<Mode> buscarPorID(int id) {
		Optional<Mode> objMode = null;
		try {
			objMode = modeRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objMode;
	}

	@Override
	public boolean actualizar(Mode objMode) {
		boolean flag = false;
		try {
			if( objMode.getId() >1) { //Ejemplo de aplicacion de logica, solo actualizar si hay un ID
				if(modeRepo.save(objMode) != null) {
					flag = true;
				}	
			}					
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean eliminar(int id) {
		boolean flag = false;
		try {
			if(id>1) { //Ejemplo de aplicacion de logica, solo eliminar si hay un ID
				modeRepo.deleteById(id);
				flag = true;
			}else {
				flag = false;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

}

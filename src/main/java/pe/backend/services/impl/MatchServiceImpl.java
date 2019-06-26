package pe.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.backend.entities.Match;
import pe.backend.repositories.MatchRepository;
import pe.backend.services.MatchService;


@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchRepository matchRepo;

	@Override
	public boolean insertar(Match entity) {
		boolean flag = false;
		try {
			if(matchRepo.save(entity) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Match> listarTodas() {
		return matchRepo.findAll();
	}

	@Override
	public Optional<Match> buscarPorID(int id) {
		Optional<Match> entity = null;
		try {
			entity = matchRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return entity;
	}

	@Override
	public boolean actualizar(Match entity) {
		boolean flag = false;
		try {
			if( entity.getId() >1) {
				if(matchRepo.save(entity) != null) {
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
			if(id>1) { 
				matchRepo.deleteById(id);
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

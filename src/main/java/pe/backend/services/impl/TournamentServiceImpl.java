package pe.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.backend.entities.Tournament;
import pe.backend.repositories.TournamentRepository;
import pe.backend.services.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService {
	@Autowired
	TournamentRepository tournamentRepo;

	@Override
	public boolean insertar(Tournament objTournament) {
		boolean flag = false;
		try {
			if(tournamentRepo.save(objTournament) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Tournament> listarTodas() {
		
		return tournamentRepo.findAll();
	}

	@Override
	public Optional<Tournament> buscarPorID(int id) {
		Optional<Tournament> objTournament = null;
		try {
			objTournament = tournamentRepo.findById(id);
			objTournament.get().getPlayer().setTeam(null);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objTournament;
	}

	@Override
	public boolean actualizar(Tournament objTournament) {
		boolean flag = false;
		try {
			if( objTournament.getId() >1) { 
				if(tournamentRepo.save(objTournament) != null) {
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
				tournamentRepo.deleteById(id);
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

package pe.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.backend.entities.Player;
import pe.backend.entities.Team;
import pe.backend.repositories.TeamRepository;
import pe.backend.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	TeamRepository teamRepo;

	@Override
	public boolean insertar(Team entity) {
		boolean flag = false;
		try {
			if(teamRepo.save(entity) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Team> listarTodas() {
		return teamRepo.findAll();
	}

	@Override
	public Optional<Team> buscarPorID(int id) {
		Optional<Team> entity = null;
		try {
			entity = teamRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return entity;
	}

	@Override
	public boolean actualizar(Team entity) {
		boolean flag = false;
		try {
			if( entity.getId() >1) { 
				if(teamRepo.save(entity) != null) {
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
				teamRepo.deleteById(id);
				flag = true;
			}else {
				flag = false;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	@Override
	public List<Team> getTeamsByTournamentId(int id)
	{
		List<Team> teams = teamRepo.getTeamsByTournamentId(id);
		
		for (int i = 0; i<teams.size(); i++)
		{
			teams.get(i).setTournament(null);
		}
		return teams;
		
	}
}

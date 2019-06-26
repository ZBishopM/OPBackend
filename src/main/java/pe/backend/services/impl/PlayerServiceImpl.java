package pe.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.backend.entities.Player;
import pe.backend.repositories.PlayerRepository;
import pe.backend.services.PlayerService;


@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;

	@Override
	public boolean insertar(Player entity) {
		boolean flag = false;
		try {
			if(playerRepo.save(entity) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Player> listarTodas() {
		return playerRepo.findAll();
	}

	@Override
	public Optional<Player> buscarPorID(int id) {
		Optional<Player> entity = null;
		try {
			entity = playerRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return entity;
	}

	@Override
	public boolean actualizar(Player entity) {
		boolean flag = false;
		try {
			if( entity.getId() >1) {
				if(playerRepo.save(entity) != null) {
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
				playerRepo.deleteById(id);
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
	public List<Player> getPlayersFromTeamId(int id)
	{
		List<Player> players = playerRepo.getPlayersFromTeamId(id);
		
		for (int i = 0; i<players.size(); i++)
		{
			players.get(i).setTeam(null);
		}
		return players;
	}
	
	
}

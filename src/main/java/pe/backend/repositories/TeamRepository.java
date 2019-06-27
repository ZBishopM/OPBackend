package pe.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Team;

@Repository
public interface TeamRepository 
				extends JpaRepository<Team, Integer> {
	
	public List<Team> getTeamsByTournamentId(int id);

}

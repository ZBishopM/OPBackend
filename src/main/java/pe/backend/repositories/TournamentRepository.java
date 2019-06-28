package pe.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Tournament;

@Repository
public interface TournamentRepository 
				extends JpaRepository<Tournament, Integer> {

}

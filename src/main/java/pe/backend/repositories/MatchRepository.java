package pe.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Match;

@Repository
public interface MatchRepository 
				extends JpaRepository<Match, Integer> {

}

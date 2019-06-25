package pe.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Mode;

@Repository
public interface ModeRepository 
				extends JpaRepository<Mode, Integer> {

}

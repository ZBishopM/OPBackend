package pe.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.backend.entities.Statistics;

@Repository
public interface StatisticsRepository 
				extends JpaRepository<Statistics, Integer> {

}

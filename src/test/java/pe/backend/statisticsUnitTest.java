package pe.backend;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pe.backend.entities.Match;
import pe.backend.entities.Mode;
import pe.backend.entities.Player;
import pe.backend.entities.Statistics;
import pe.backend.entities.Tournament;
import pe.backend.repositories.ModeRepository;
import pe.backend.repositories.StatisticsRepository;
import pe.backend.repositories.TournamentRepository;
import pe.backend.services.impl.ModeServiceImpl;
import pe.backend.services.impl.StatisticsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class statisticsUnitTest {

	@Autowired
	private StatisticsServiceImpl statServiceImpl;
	
	@MockBean
	StatisticsRepository statRepo;
	
	@MockBean
	TournamentRepository tournamentRepo;
	
	@Test
	public void insertar() {
		Statistics stats = new Statistics();
		stats.setId(2);
		stats.setDamage(300);
		stats.setAssits(20);
		stats.setKills(13);
		stats.setDeaths(6);
		
		Match match = new Match();
		match.setId(2);
		match.setFase(2);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		stats.setPlayer(jugador);
		stats.setMatch(match);
		
		Mockito.when(statRepo.save(stats)).thenReturn(stats);

		boolean respuesta = statServiceImpl.insertar(stats);
		
		Assert.assertTrue(respuesta);
	}

	@Test
	public void listarTodos() {
		Mockito.when(statRepo.findAll()).thenReturn(new ArrayList<Statistics>());

		List<Statistics> respuesta = statServiceImpl.listarTodas();
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void buscarPorId() {
		Statistics stats = new Statistics();
		stats.setId(2);
		stats.setDamage(300);
		stats.setAssits(20);
		stats.setKills(13);
		stats.setDeaths(6);
		
		Match match = new Match();
		match.setId(2);
		match.setFase(2);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		stats.setPlayer(jugador);
		stats.setMatch(match);
		
		Optional<Statistics> optmode = Optional.of(stats);
		
		Mockito.when(statRepo.findById(1)).thenReturn(optmode);

		Optional<Statistics> respuesta = statServiceImpl.buscarPorID(1);
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void actualizar() {
		Statistics stats = new Statistics();
		stats.setId(2);
		stats.setDamage(300);
		stats.setAssits(20);
		stats.setKills(13);
		stats.setDeaths(6);
		
		Match match = new Match();
		match.setId(2);
		match.setFase(2);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		stats.setPlayer(jugador);
		stats.setMatch(match);
		
		Optional<Statistics> optmode = Optional.of(stats);

		Mockito.when(statRepo.findById(1)).thenReturn(optmode);
		Mockito.when(statRepo.save(stats)).thenReturn(stats);

		boolean respuesta = statServiceImpl.actualizar(stats);
		
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void eliminar() {
		Statistics stats = new Statistics();
		stats.setId(2);
		stats.setDamage(300);
		stats.setAssits(20);
		stats.setKills(13);
		stats.setDeaths(6);
		
		Match match = new Match();
		match.setId(2);
		match.setFase(2);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		stats.setPlayer(jugador);
		stats.setMatch(match);
		
		doNothing().when(statRepo).deleteById(2);
		
		boolean respuesta = statServiceImpl.eliminar(2);
		
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void StatisticsPorPlayerID() {		
		List<Statistics> respuesta = statServiceImpl.StatisticsPorPlayerID(1);
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void statisticsByMatchId() {		
		List<Statistics> respuesta = statServiceImpl.statisticsByMatchId(1);
		
		Assert.assertNotNull(respuesta);
	}
	
}

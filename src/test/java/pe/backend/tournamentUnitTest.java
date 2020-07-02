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
import pe.backend.entities.Team;
import pe.backend.entities.Tournament;
import pe.backend.repositories.TournamentRepository;
import pe.backend.services.impl.TournamentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class tournamentUnitTest {
	
	@Autowired
	private TournamentServiceImpl tourServiceImpl;
	
	@MockBean
	TournamentRepository tourRepo;
	
	@Test
	public void insertar() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		Mockito.when(tourRepo.FindTournamentByName("the international")).thenReturn(null);
		Mockito.when(tourRepo.findByHostId(2)).thenReturn(null);
		Mockito.when(tourRepo.save(tour)).thenReturn(tour);
		
		boolean respuesta = tourServiceImpl.insertar(tour);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void listarTodos() {		
		Mockito.when(tourRepo.findAll()).thenReturn(new ArrayList<Tournament>());

		List<Tournament> respuesta = tourServiceImpl.listarTodas();
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void buscarPorId() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		Optional<Tournament> opttour = Optional.of(tour);
		
		Mockito.when(tourRepo.findById(2)).thenReturn(opttour);
		
		Optional<Tournament> respuesta = tourServiceImpl.buscarPorID(2);
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void actualizar() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		Mockito.when(tourRepo.save(tour)).thenReturn(tour);
		
		boolean respuesta = tourServiceImpl.actualizar(tour);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void eliminar() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		doNothing().when(tourRepo).deleteById(2);
		
		boolean respuesta = tourServiceImpl.eliminar(2);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void CanGenerate() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		Optional<Tournament> opttour = Optional.of(tour);
		
		Mockito.when(tourRepo.findById(2)).thenReturn(opttour);
		
		boolean respuesta = tourServiceImpl.CanGenerate(2);
		Assert.assertTrue(respuesta);
	}
	
	public void Handler() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		Optional<Tournament> opttour = Optional.of(tour);
		
		Mockito.when(tourRepo.findById(2)).thenReturn(opttour);
		
		boolean respuesta = tourServiceImpl.Handler(2);
		Assert.assertTrue(respuesta);
	}
	
	public void FindTournamentByName() {
		List<Tournament> tours = new ArrayList<>();
		
		Mockito.when(tourRepo.FindTournamentByName("Nav")).thenReturn(tours);
		
		List<Tournament> respuesta = tourServiceImpl.FindTournamentByName("Nav");
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void findByHostId() {
		Tournament tour = new Tournament();
		tour.setId(2);
		tour.setGame("Dota 2");
		tour.setName("The International");
		
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");

		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tour);
		mode.setTournaments(tournaments);
		
		List<Match> matches = new ArrayList<>();
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		tour.setMode(mode);
		tour.setMatches(matches);
		tour.setPlayer(jugador);
		
		Mockito.when(tourRepo.findByHostId(2)).thenReturn(tour);
		
		Tournament respuesta = tourServiceImpl.findByHostId(2);
		Assert.assertNotNull(respuesta);
	}
}

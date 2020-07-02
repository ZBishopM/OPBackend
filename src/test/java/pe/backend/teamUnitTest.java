package pe.backend.unitTests;

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

import pe.backend.entities.Player;
import pe.backend.entities.Team;
import pe.backend.entities.Tournament;
import pe.backend.repositories.TeamRepository;
import pe.backend.services.impl.TeamServiceImpl;
import pe.backend.services.impl.TournamentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class teamUnitTest {

	@Autowired
	private TeamServiceImpl teamServiceImpl;
	
	@MockBean
	TeamRepository teamRepo;
	
	@MockBean
	TournamentServiceImpl tourServiceMock;
	
	@Test
	public void insertar() {
		Team team = new Team();
		team.setId(3);
		team.setName("Navi");
		team.setNMembers(3);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		Player jugador2 = new Player();
		jugador.setId(3);
		jugador.setName("Carlos");
		jugador.setGamePreferences("Dota");
		
		Player jugador3 = new Player();
		jugador.setId(4);
		jugador.setName("Piero");
		jugador.setGamePreferences("Dota");

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		List<Player> players = new ArrayList<>();
		players.add(jugador);
		players.add(jugador2);
		players.add(jugador3);
		
		team.setPlayers(players);
		team.setTournament(tournament1);
		
		Optional<Tournament> opttour = Optional.of(tournament1);
		
		Mockito.when(teamRepo.findTeamsWithPartOfName("team")).thenReturn(null);
		Mockito.when(teamRepo.save(team)).thenReturn(team);
		Mockito.when(tourServiceMock.buscarPorID(2)).thenReturn(opttour);
		Mockito.when(tourServiceMock.actualizar(tournament1)).thenReturn(true);
		
		boolean respuesta = teamServiceImpl.insertar(team);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void listarTodos() {		
		Mockito.when(teamRepo.findAll()).thenReturn(new ArrayList<Team>());

		List<Team> respuesta = teamServiceImpl.listarTodas();
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void buscarPorId() {
		Team team = new Team();
		team.setId(3);
		team.setName("Navi");
		team.setNMembers(3);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		Player jugador2 = new Player();
		jugador.setId(3);
		jugador.setName("Carlos");
		jugador.setGamePreferences("Dota");
		
		Player jugador3 = new Player();
		jugador.setId(4);
		jugador.setName("Piero");
		jugador.setGamePreferences("Dota");

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		List<Player> players = new ArrayList<>();
		players.add(jugador);
		players.add(jugador2);
		players.add(jugador3);
		
		team.setPlayers(players);
		team.setTournament(tournament1);
		
		Optional<Team> opteam = Optional.of(team);
		
		Mockito.when(teamRepo.findById(2)).thenReturn(opteam);

		Optional<Team> respuesta = teamServiceImpl.buscarPorID(3);
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void actualizar() {
		Team team = new Team();
		team.setId(3);
		team.setName("Navi");
		team.setNMembers(3);
		
		Player jugador = new Player();
		jugador.setId(2);
		jugador.setName("Luis");
		jugador.setGamePreferences("Dota");
		
		Player jugador2 = new Player();
		jugador.setId(3);
		jugador.setName("Carlos");
		jugador.setGamePreferences("Dota");
		
		Player jugador3 = new Player();
		jugador.setId(4);
		jugador.setName("Piero");
		jugador.setGamePreferences("Dota");

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		List<Player> players = new ArrayList<>();
		players.add(jugador);
		players.add(jugador2);
		players.add(jugador3);
		
		team.setPlayers(players);
		team.setTournament(tournament1);
		
		Optional<Tournament> opttour = Optional.of(tournament1);
		Optional<Team> opteam = Optional.of(team);
		
		Mockito.when(teamRepo.findTeamsWithPartOfName("team")).thenReturn(null);
		Mockito.when(teamRepo.save(team)).thenReturn(team);
		Mockito.when(tourServiceMock.buscarPorID(2)).thenReturn(opttour);
		Mockito.when(tourServiceMock.actualizar(tournament1)).thenReturn(true);
		
		//boolean respuesta = teamServiceImpl.actualizar(team);
		boolean respuesta = teamServiceImpl.insertar(team);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void getTeamsByTournamentId() {
		List<Team> teams = new ArrayList<>();
		
		Mockito.when(teamRepo.getTeamsByTournamentId(2)).thenReturn(teams);
		
		List<Team> respuesta = teamServiceImpl.getTeamsByTournamentId(3);
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void findTeamsWithPartOfName() {
		List<Team> teams = new ArrayList<>();
		
		Mockito.when(teamRepo.findTeamsWithPartOfName("navi")).thenReturn(teams);
		
		List<Team> respuesta = teamServiceImpl.findTeamsWithPartOfName("Nav");
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void getPlayerId() {		
		List<Team> teams = new ArrayList<>();
		
		Mockito.when(teamRepo.getPlayerId(3)).thenReturn(teams);
		
		List<Team> respuesta = teamServiceImpl.getPlayerId(3);
		Assert.assertNotNull(respuesta);
	}
}

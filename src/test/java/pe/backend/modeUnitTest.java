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

import pe.backend.entities.Mode;
import pe.backend.entities.Player;
import pe.backend.entities.Team;
import pe.backend.entities.Tournament;
import pe.backend.repositories.ModeRepository;
import pe.backend.repositories.TournamentRepository;
import pe.backend.services.impl.ModeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class modeUnitTest {
	
	@Autowired
	private ModeServiceImpl modeServiceImpl;
	
	@MockBean
	ModeRepository modeRepo;
	
	@MockBean
	TournamentRepository tournamentRepo;
	
	@Test
	public void insertar() {
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");
		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tournament1);
		mode.setTournaments(tournaments);
		
		Mockito.when(modeRepo.save(mode)).thenReturn(mode);

		boolean respuesta = modeServiceImpl.insertar(mode);
		
		Assert.assertTrue(respuesta);
	}

	@Test
	public void listarTodos() {
		Mockito.when(modeRepo.findAll()).thenReturn(new ArrayList<Mode>());

		List<Mode> respuesta = modeServiceImpl.listarTodas();
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void buscarPorId() {
		Mode mode = new Mode();
		mode.setId(1);
		mode.setFormat("Deathmatch");
		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tournament1);
		mode.setTournaments(tournaments);
		
		Optional<Mode> optmode = Optional.of(mode);
		
		Mockito.when(modeRepo.findById(1)).thenReturn(optmode);

		Optional<Mode> respuesta = modeServiceImpl.buscarPorID(1);
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void actualizar() {
		Mode mode = new Mode();
		mode.setId(2);
		mode.setFormat("Deathmatch");
		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tournament1);
		mode.setTournaments(tournaments);
		
		Optional<Mode> optjugador = Optional.of(mode);
		
		Mockito.when(modeRepo.findById(2)).thenReturn(optjugador);
		Mockito.when(modeRepo.save(mode)).thenReturn(mode);

		boolean respuesta = modeServiceImpl.actualizar(mode);
		
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void eliminar() {
		Mode mode = new Mode();
		mode.setId(2);
		mode.setFormat("Deathmatch");
		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		List<Tournament> tournaments = new ArrayList<>();
		tournaments.add(tournament1);
		mode.setTournaments(tournaments);
		
		doNothing().when(modeRepo).deleteById(2);
		
		boolean respuesta = modeServiceImpl.eliminar(2);
		
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void trueResults() {
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team.setId(5);
		team.setName("Evil Genises");
		team.setNMembers(5);
		
		List<Team> teams = new ArrayList<>();
		teams.add(team);
		teams.add(team2);
		
		Team respuesta = modeServiceImpl.TrueResults(teams);
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void randomTeams() {
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team.setId(5);
		team.setName("Evil Genises");
		team.setNMembers(5);
		
		List<Team> teams = new ArrayList<>();
		teams.add(team);
		teams.add(team2);
		
		List<Team> respuesta = modeServiceImpl.randomTeams(teams);
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void GenerateMatchesMode1() {
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team.setId(5);
		team.setName("Evil Genises");
		team.setNMembers(5);
		
		List<Team> teams = new ArrayList<>();
		teams.add(team);
		teams.add(team2);
		
		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		Optional<Tournament> opttour = Optional.of(tournament1);
		
		Mockito.when(tournamentRepo.findById(2)).thenReturn(opttour);
		
		String respuesta = modeServiceImpl.GenerateMatchesMode1(teams, 2, 2);
		Assert.assertNotNull(respuesta);
	}
}
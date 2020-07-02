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
import pe.backend.entities.Team;
import pe.backend.entities.Tournament;
import pe.backend.repositories.MatchRepository;
import pe.backend.services.impl.MatchServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class matchUnitTest {
	
	@Autowired
	private MatchServiceImpl matchServiceImpl;
	
	@MockBean
	MatchRepository matchRepo;

	@Test
	public void insertar() {
		Match match = new Match();
		match.setId(2);
		match.setFase(2);

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team2.setId(5);
		team2.setName("Evil Genises");
		team2.setNMembers(5);
		
		match.setTeam1(team);
		match.setTeam2(team2);
		match.setTournament(tournament1);;

		
		Mockito.when(matchRepo.save(match)).thenReturn(match);

		boolean respuesta = matchServiceImpl.insertar(match);
		
		Assert.assertTrue(respuesta);
	}

	@Test
	public void listarTodos() {
		Mockito.when(matchRepo.findAll()).thenReturn(new ArrayList<Match>());

		List<Match> respuesta = matchServiceImpl.listarTodas();
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void buscarPorId() {
		Match match = new Match();
		match.setId(2);
		match.setFase(2);

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team2.setId(5);
		team2.setName("Evil Genises");
		team2.setNMembers(5);
		
		match.setTeam1(team);
		match.setTeam2(team2);
		match.setTournament(tournament1);
		
		Optional<Match> optmatch = Optional.of(match);
		
		Mockito.when(matchRepo.findById(1)).thenReturn(optmatch);

		Optional<Match> respuesta = matchServiceImpl.buscarPorID(1);
		
		Assert.assertNotNull(respuesta);
	}
	
	@Test
	public void actualizar() {
		Match match = new Match();
		match.setId(2);
		match.setFase(2);

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team2.setId(5);
		team2.setName("Evil Genises");
		team2.setNMembers(5);
		
		match.setTeam1(team);
		match.setTeam2(team2);
		match.setTournament(tournament1);
		
		Optional<Match> optmatch = Optional.of(match);
		
		Mockito.when(matchRepo.findById(1)).thenReturn(optmatch);
		Mockito.when(matchRepo.save(match)).thenReturn(match);

		boolean respuesta = matchServiceImpl.actualizar(match);
		
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void eliminar() {
		Match match = new Match();
		match.setId(2);
		match.setFase(2);

		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team2.setId(5);
		team2.setName("Evil Genises");
		team2.setNMembers(5);
		
		match.setTeam1(team);
		match.setTeam2(team2);
		match.setTournament(tournament1);
		
		doNothing().when(matchRepo).deleteById(2);
		
		boolean respuesta = matchServiceImpl.eliminar(2);
		
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void GenerateMatches() {
		Match match = new Match();
		match.setId(2);
		match.setFase(2);

		Match match2 = new Match();
		match2.setId(3);
		match2.setFase(3);
		
		Tournament tournament1 = new Tournament();
		tournament1.setId(2);
		tournament1.setGame("Dota 2");
		tournament1.setName("The International");
		
		Team team = new Team();
		team.setId(4);
		team.setName("Navi");
		team.setNMembers(5);
		
		Team team2 = new Team();
		team2.setId(5);
		team2.setName("Evil Genises");
		team2.setNMembers(5);
		
		match.setTeam1(team);
		match.setTeam2(team2);
		match.setTournament(tournament1);
		match2.setTeam1(team);
		match2.setTeam2(team2);
		match2.setTournament(tournament1);
		
		List<Match> matches = new ArrayList<>();
		matches.add(match);
		matches.add(match2);
		
		int respuesta = matchServiceImpl.GenerateMatches1(matches);
		
		Assert.assertNotNull(respuesta);
	}

	@Test
	public void MatchesPorTournamentID() {		
		List<Match> respuesta = matchServiceImpl.MatchesPorTournamentID(1);
		
		Assert.assertNotNull(respuesta);
	}

	
}

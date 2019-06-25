package pe.backend.services;

import java.util.List;
import java.util.Optional;

import pe.backend.entities.Tournament;


public interface TournamentService {

	public boolean insertar(Tournament objTournament);
	
	public List<Tournament> listarTodas();
	
	public Optional<Tournament> buscarPorID(int id);
	
	public boolean actualizar(Tournament objTournament);
	
	public boolean eliminar(int id);	
	
}

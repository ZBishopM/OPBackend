package pe.backend.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tournaments")
/*@NamedQueries({
	@NamedQuery(
			name="Categoria.buscarPorNombre", 
			query="select c from Categoria c where c.nombre like concat(?1, '%')" // like '%texto%'
			//query="select c from Categoria c where c.nombre like concat(:nombreParam, '%')" // like '%texto%'
	),
	@NamedQuery(
			name="Categoria.buscarPorEstado", 
			query="select c from Categoria c where c.estado = ?1"
	)
})*/
@ApiModel(value="Representa la tabla torneos.")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","inpesction"})
public class Tournament{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="Es la PK de la tabla, entero, auto incremental")
	private int Id;
	@NotNull(message = "El valor no puede ser nulo")
	@Size(min = 3, max = 75, message = "El nombre debe estar contenido entre 3 y 75 caracteres")
	private String Name;
	@Future(message = "La fecha debe ser como minima en las siguientes 24horas")
	private Date Date;
	@Size(min = 3, max = 75, message = "El ganador debe estar contenido entre 3 y 75 caracteres")
	private String Winner;
	@NotNull(message = "El valor no puede ser nulo")
	@Size(min = 3, max = 75, message = "El juego debe estar contenido entre 3 y 75 caracteres")
	private String Game;
	@NotNull(message = "El valor no puede ser nulo")
	private int NTeams;
	
	@JsonIgnoreProperties("tournament") 
	@ManyToOne(fetch = FetchType.LAZY)
	private Player Player;								   
	
	@JsonIgnoreProperties("tournament") 
	@ManyToOne(fetch = FetchType.LAZY)	
	private Mode mode;
	
	@JsonIgnoreProperties("tournament")
	@OneToMany(mappedBy="Tournament", fetch=FetchType.LAZY)
	private List<Match> Matches;
	
	@JsonIgnoreProperties("tournament")
	@OneToMany(mappedBy="Tournament", fetch=FetchType.LAZY)
	private List<Team> Team;

	@JsonBackReference(value="match-tournament")
	public List<Match> getMatches() {
		return Matches;
	}

	public void setMatches(List<Match> matches) {
		Matches = matches;
	}


	public int getId() {
		return Id;
	}

	@JsonBackReference(value="team-tournament")
	public List<Team> getTeam() {
		return Team;
	}

	public void setTeam(List<Team> team) {
		Team = team;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getWinner() {
		return Winner;
	}

	public void setWinner(String winner) {
		Winner = winner;
	}

	public String getGame() {
		return Game;
	}

	public void setGame(String game) {
		Game = game;
	}

	public int getNTeams() {
		return NTeams;
	}

	public void setNTeams(int nTeams) {
		NTeams = nTeams;
	}

	//@JsonManagedReference(value="player-tournament")
	public Player getPlayer() {
		return Player;
	}

	public void setPlayer(Player player) {
		Player = player;
	}

	//@JsonManagedReference(value="mode-tournament")
	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
}
package pe.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="match")
@ApiModel(value="Representa la tabla match.")
public class Match{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@JsonIgnoreProperties("match")
	@OneToOne(mappedBy="match", fetch=FetchType.LAZY)
	private Team Winner;
	
	private int Fase;
	
	@JsonIgnoreProperties("match")
	@OneToOne(mappedBy="match", fetch=FetchType.LAZY)
	private Team Team1;
	
	@JsonIgnoreProperties("match")
	@OneToOne(mappedBy="match", fetch=FetchType.LAZY)
	private Team Team2;
	
	@JsonIgnoreProperties("match")
	@ManyToOne(fetch=FetchType.LAZY)
	private Tournament Tournament;

	@JsonIgnoreProperties("match")
	@OneToMany(mappedBy="match", fetch=FetchType.LAZY)
	private List<Statistics> Statistics;
	
	public int getId() {
		return Id;
	}

	public List<Statistics> getStatistics() {
		return Statistics;
	}

	public void setStatistics(List<Statistics> statistics) {
		Statistics = statistics;
	}

	public void setId(int id) {
		Id = id;
	}

	public Team getWinner() {
		return Winner;
	}

	public void setWinner(Team winner) {
		Winner = winner;
	}

	public int getFase() {
		return Fase;
	}

	public void setFase(int fase) {
		Fase = fase;
	}

	public Team getTeam1() {
		return Team1;
	}

	public void setTeam1(Team team1) {
		Team1 = team1;
	}

	public Team getTeam2() {
		return Team2;
	}

	public void setTeam2(Team team2) {
		Team2 = team2;
	}

	public Tournament getTournament() {
		return Tournament;
	}

	public void setTournament(Tournament tournament) {
		Tournament = tournament;
	}
}
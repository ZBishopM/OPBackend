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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="team")
@ApiModel(value="Representa la tabla team.")
public class Team{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private int NMembers;	
		
	@JsonIgnoreProperties("team")
	@ManyToOne(fetch=FetchType.LAZY)
	private Tournament Tournament;
	
	@JsonIgnoreProperties("team")
	@OneToMany(mappedBy="team", fetch=FetchType.LAZY)
	private List<Player> Players;

	public int getId() {
		return Id;
	}

	public List<Player> getPlayers() {
		return Players;
	}

	public void setPlayers(List<Player> players) {
		Players = players;
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

	public int getNMembers() {
		return NMembers;
	}

	public void setNMembers(int nMembers) {
		NMembers = nMembers;
	}

	public Tournament getTournament() {
		return Tournament;
	}

	public void setTournament(Tournament tournament) {
		Tournament = tournament;
	}
}
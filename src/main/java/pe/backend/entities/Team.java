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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="teams")
@ApiModel(value="Representa la tabla team.")
public class Team{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="Es la PK de la tabla, entero, auto incremental")
	private int Id;
	
	@NotNull(message = "El valor no puede ser nulo")
	@Size(min = 3, max = 75, message = "El nombre debe estar contenido entre 3 y 75 caracteres")
	private String Name;
	
	@NotNull(message = "El valor no puede ser nulo")
	@Min(value = 0, message = "La cantidad de miembros no debe ser menor a 0")
	private int NMembers;	
		
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	private Tournament Tournament;
	
	@JsonManagedReference
	@OneToMany(mappedBy="Team", fetch=FetchType.LAZY)
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
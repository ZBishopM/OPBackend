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
@Table(name="statistics")
@ApiModel(value="Representa la tabla statistics.")
public class Statistics{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@JsonIgnoreProperties("statistics")
	@ManyToOne(fetch=FetchType.LAZY)
	private Match Match;
	
	@JsonIgnoreProperties("statistics")
	@ManyToOne(fetch=FetchType.LAZY)
	private Player Player;
	
	private float Kills;
	private float Deaths;
	private float Assits;
	private float Damage;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Match getMatch() {
		return Match;
	}
	public void setMatch(Match match) {
		Match = match;
	}
	public Player getPlayer() {
		return Player;
	}
	public void setPlayer(Player player) {
		Player = player;
	}
	public float getKills() {
		return Kills;
	}
	public void setKills(float kills) {
		Kills = kills;
	}
	public float getDeaths() {
		return Deaths;
	}
	public void setDeaths(float deaths) {
		Deaths = deaths;
	}
	public float getAssits() {
		return Assits;
	}
	public void setAssits(float assits) {
		Assits = assits;
	}
	public float getDamage() {
		return Damage;
	}
	public void setDamage(float damage) {
		Damage = damage;
	}
}
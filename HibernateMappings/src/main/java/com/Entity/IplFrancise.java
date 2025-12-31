package com.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class IplFrancise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int franciseId;
	private String Name;
	private String franciseState;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="ipl-players", joinColumns= {@JoinColumn(name="franicise_id")},inverseJoinColumns= {@JoinColumn(name="player_id")})
	private List<Player> players;

	public IplFrancise(String name, String franciseState, List<Player> players) {
		super();
		Name = name;
		this.franciseState = franciseState;
		this.players = players;
	}

	public IplFrancise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IplFrancise(String name, String franciseState) {
		super();
		Name = name;
		this.franciseState = franciseState;
	}

	public int getFranciseId() {
		return franciseId;
	}

	public void setFranciseId(int franciseId) {
		this.franciseId = franciseId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFranciseState() {
		return franciseState;
	}

	public void setFranciseState(String franciseState) {
		this.franciseState = franciseState;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "IplFrancise [franciseId=" + franciseId + ", Name=" + Name + ", franciseState=" + franciseState
				+ "]";
	}

}

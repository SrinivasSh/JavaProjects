package com.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int jerseyNo;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<IplFrancise> iplFrancise;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String name, int jerseyNo) {
		super();
		this.name = name;
		this.jerseyNo = jerseyNo;
	}

	public Player(String name, int jerseyNo, List<IplFrancise> iplFrancise) {
		super();
		this.name = name;
		this.jerseyNo = jerseyNo;
		this.iplFrancise = iplFrancise;
	}

	public Player(String name, List<IplFrancise> iplFrancise) {
		super();
		this.name = name;
		this.iplFrancise = iplFrancise;
	}

	public List<IplFrancise> getIplFrancise() {
		return iplFrancise;
	}

	public void setIplFrancise(List<IplFrancise> iplFrancise) {
		this.iplFrancise = iplFrancise;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJerseyNo() {
		return jerseyNo;
	}

	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", jerseyNo=" + jerseyNo + ", iplFrancise=" + iplFrancise + "]";
	}

}

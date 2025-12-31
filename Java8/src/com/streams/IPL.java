package com.streams;

public class IPL {
	
	private int no;
	private String name;
	private String team;
	private int cups;
	
	
	public IPL() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IPL(int no, String name, String team, int cups) {
		super();
		this.no = no;
		this.name = name;
		this.team = team;
		this.cups = cups;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public int getCups() {
		return cups;
	}


	public void setCups(int cups) {
		this.cups = cups;
	}


	@Override
	public String toString() {
		return "IPL [no=" + no + ", name=" + name + ", team=" + team + ", cups=" + cups + "]";
	}
	
	
	
	
	
	

}

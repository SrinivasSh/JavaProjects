package com;

public class Driver {

	private int Id;
	private String Name;
	private String Category;
	private double TotalDistance;

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(int id, String name, String category, double totalDistance) {
		super();
		Id = id;
		Name = name;
		Category = category;
		TotalDistance = totalDistance;
	}

	public int getId() {
		return Id;
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

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public double getTotalDistance() {
		return TotalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		TotalDistance = totalDistance;
	}

	@Override
	public String toString() {
		return "Driver [Id=" + Id + ", Name=" + Name + ", Category=" + Category + ", TotalDistance=" + TotalDistance
				+ "]";
	}

}

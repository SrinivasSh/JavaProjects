package com.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetImpl {
	
	public static void main(String[] args) {
		
		
		HashSet<Integer> hs=new HashSet<Integer>();
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(10);
		hs.add(20);
		hs.add(40);
		hs.add(10);
		hs.add(50);
		
		for(Integer hashSet:hs) {
			System.out.println(hashSet);
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Iterator<Integer> itr=hs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		God g1=new God(11,"Balaram");
		God g2=new God(22,"Sri Krishna");
		God g3=new God(13,"Rama");
		God g4=new God(14,"Shiva");
		God g5=new God(15,"Narayana");
		
		HashSet<God> hset=new HashSet<God>();
		hset.add(g1);
		hset.add(g2);
		hset.add(g3);
		hset.add(g4);
		hset.add(g5);
		
		for(God god:hset) {
			System.out.println(god);
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Iterator<God> hasset =hset.iterator();
		while(hasset.hasNext()) {
			System.out.println(hasset.next());
		}
	}

}

class God{
	int id;
	String name;
	
	
	public God() {
		super();
		
	}


	public God(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}

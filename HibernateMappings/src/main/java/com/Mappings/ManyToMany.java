package com.Mappings;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.IplFrancise;
import com.Entity.Player;
import com.configuration.HibernateUtil;

public class ManyToMany {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		IplFrancise iplFrancise1 = new IplFrancise("Mumbai Indians", "Mumbai");
		IplFrancise iplFrancise2 = new IplFrancise("RCB", "Bangalore");
		IplFrancise iplFrancise3 = new IplFrancise("SunRisers", "Hyderbad");

		Player player1 = new Player("Hardik Pandya", 75);
		Player player2 = new Player("Virat", 18);
		Player player3 = new Player("Nitish Reddy", 79);

		List<IplFrancise> franciseList1 = new ArrayList<IplFrancise>();
		franciseList1.add(iplFrancise1);
		franciseList1.add(iplFrancise2);

		List<IplFrancise> franciseList2 = new ArrayList<IplFrancise>();
		franciseList2.add(iplFrancise3);

		List<Player> playerList1 = new ArrayList<Player>();
		playerList1.add(player1);
		playerList1.add(player2);

		List<Player> playerList2 = new ArrayList<Player>();
		playerList2.add(player3);

		iplFrancise1.setPlayers(playerList1);
		iplFrancise2.setPlayers(playerList1);
		iplFrancise3.setPlayers(playerList2);

		player1.setIplFrancise(franciseList1);
		player2.setIplFrancise(franciseList1);
		player3.setIplFrancise(franciseList2);

		//insert(session, iplFrancise1, iplFrancise2, iplFrancise3);
		
		//select(session);
		
		//updateData(session);
		
		deleteData(session);
		
		
		

	}

	public static void deleteData(Session session) {
		Player selectPlayer=session.find(Player.class, 3);
		session.beginTransaction();
		session.remove(selectPlayer);
		session.getTransaction().commit();
	}

	public static void updateData(Session session) {
		Player player=session.find(Player.class, 1);
		session.beginTransaction();
		player.setName("Rohit Sharma");
		List<IplFrancise> francise=player.getIplFrancise();
		IplFrancise franciseName=francise.get(0);
		franciseName.setName("RCB");
		session.merge(player);
		session.getTransaction().commit();
	}

	public static void select(Session session) {
		IplFrancise ipl=session.find(IplFrancise.class,1);
		System.out.println(ipl);
		System.out.println(ipl.getPlayers());
	}

	public static void insert(Session session, IplFrancise iplFrancise1, IplFrancise iplFrancise2,
			IplFrancise iplFrancise3) {
		session.beginTransaction();
		session.persist(iplFrancise1);
		session.persist(iplFrancise2);
		session.persist(iplFrancise3);
		session.getTransaction().commit();
	}

}

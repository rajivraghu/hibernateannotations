package com.rajivraghu.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.rajivraghu.hibernate.model.Player;
import com.rajivraghu.hibernate.model.Team;
import com.rajivraghu.hibernate.model.TeamVO;
import com.rajivraghu.hibernate.model.Territory;

public class TeamPlayerCriteriaJoinDemo {
	
	
	public static void main(String[] args) {
		
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
/*	// To get records having salary more than 2000
	cr.add(Restrictions.gt("salary", 2000));

	// To get records having salary less than 2000
	cr.add(Restrictions.lt("salary", 2000));

	// To get records having fistName starting with zara
	cr.add(Restrictions.like("firstName", "zara%"));

	// Case sensitive form of the above restriction.
	cr.add(Restrictions.ilike("firstName", "zara%"));

	// To get records having salary in between 1000 and 2000
	cr.add(Restrictions.between("salary", 1000, 2000));

	// To check if the given property is null
	cr.add(Restrictions.isNull("salary"));

	// To check if the given property is not null
	cr.add(Restrictions.isNotNull("salary"));

	// To check if the given property is empty
	cr.add(Restrictions.isEmpty("salary"));

	// To check if the given property is not empty
	cr.add(Restrictions.isNotEmpty("salary"));*/
	
	/*Team team = new Team();
	team.setTeamName("RCB");
	team.setTeamOwner("United Spirits");
	team.setState("Karnataka");
	
	Team team1 = new Team();
	team1.setTeamName("CSK");
	team1.setTeamOwner("India cements");
	team1.setState("Tamil Nadu");
	
	session.save(team);
	session.save(team1);
	Player player = new Player();
	player.setPlayerName("Kohli");
	player.setPlayerType("Batsman");
	player.setTeamId(team.getTeamId());
	
	Player player2 = new Player();
	player2.setPlayerName("Dhoni");
	player2.setPlayerType("Batsman");
	player2.setTeamId(team1.getTeamId());
	session.save(player);
	session.save(player2);
	session.getTransaction().commit();*/
	
	
	/*Criteria cr = session.createCriteria(Team.class)
		    .setProjection(Projections.projectionList()
		      .add(Projections.property("teamId"), "teamId")
		      .add(Projections.property("state"), "state"))
		    .setResultTransformer(Transformers.aliasToBean(TeamVO.class));

		  List<TeamVO> list = (List<TeamVO>) cr.list();
		  System.out.println(list.size());*/
	
/*	
	Criteria criteria = session.createCriteria(Player.class);
	criteria.setProjection(Projections.property("playerName"));

	List<String> list = (List<String>)criteria.list();
	for(String s: list){
		System.out.println(s);
	}*/
	
/*	
	Criteria criteria = session.createCriteria(Player.class);
	criteria.setProjection(Projections.rowCount());
	Long uniqueResult = (Long) criteria.uniqueResult();
	System.out.println(uniqueResult);*/
	
	
	/*Player  player1 = (Player)session.get(Player.class, 515050);
	session.close();
	Session session2 = sessionFactory.openSession();
	Player  player2 = (Player)session.get(Player.class, 515050);
	System.out.println(player1.getPlayerName());
	System.out.println(player2.getPlayerName());
	session2.close();*/
	Integer userId= 18993;
	Query createQuery =session.createSQLQuery("select TERRITORY.TERRITORY_NAME from USER_TERRITORY_MAPPING join TERRITORY on TERRITORY.TERRITORY_ID=USER_TERRITORY_MAPPING.TERRITORY_ID where USER_TERRITORY_MAPPING.USER_ID = :userId ");
	//Query createQuery = session.createQuery("select t.territoryName from Territory t  INNER JOIN  UserTerritoryMapping utm ON utm.userTerritoryMappingPK.territoryId = t.territoryId  ");
	createQuery.setInteger("userId", userId);
	List<String> list =(List<String> ) createQuery.list();
	System.out.println(list.size());
	session.close();
	
	}
	
	

}

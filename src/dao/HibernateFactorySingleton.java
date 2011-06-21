package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactorySingleton {
	
	private static SessionFactory sessionFactory;
	
	
	public HibernateFactorySingleton(){
		super();
	}
	
	public static SessionFactory getInstance(){
		if(sessionFactory==null){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
}

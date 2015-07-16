package com.kolesnic;

import com.kolesnic.entity.Movies;
import com.kolesnic.entity.Tickets;
import com.kolesnic.entity.Cinemas;
import com.kolesnic.entity.Schedule;
//import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils{
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	static{
		try{
//			String[] arguments = {"-tcpAllowOthers", "-tcpPort", "9092"};
//			Server server = Server.createTcpServer(arguments).start();

			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Tickets.class);
			configuration.addAnnotatedClass(Cinemas.class);
			configuration.addAnnotatedClass(Movies.class);
			configuration.addAnnotatedClass(Schedule.class);
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);
			
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	    public static SessionFactory getSessionFactory(){
			return factory;
		}
		
		public static void shutDown(){
			getSessionFactory().close();
		}
}

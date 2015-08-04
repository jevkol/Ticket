package com.kolesnic.dao;

import com.kolesnic.HibernateUtils;
import com.kolesnic.entity.Movies;
import com.kolesnic.service.MoviesService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Администратор on 12.07.15.
 */
@Repository
@Transactional
public class HibernateMoviesRepositoryImpl implements MoviesRepository {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {return sessionFactory;}

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Transactional
    public Long addMovies(Movies movies){
        return (Long)sessionFactory.getCurrentSession().save(movies);

    }

    @Transactional
    public List<Movies> getMovies(){
        return (List<Movies>) sessionFactory.getCurrentSession().createQuery("from Movies m").list();
    }

    public void updateMovies(Movies movies){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx =  null;
        try{
            tx = session.beginTransaction();
            session.update(movies);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleetMovies(Movies movies){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(movies);
            tx.commit();
        }  catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public  List<Movies> generateMovies() {
        List<Movies> movieList = new ArrayList<Movies>();
        Movies movies1 = new Movies();

        movies1.setName("Godzila");
        movies1.setDescription("Grrrrr");
        movieList.add(movies1);

        Movies movies2 = new Movies();
        movies2.setName("Godzila2");
        movies2.setDescription("Grrrrrr2");
        movieList.add(movies2);

        Movies movies3 = new Movies();
        movies3.setName("Godzzzzzila3");
        movies3.setDescription("Vsex sogral grrrrrrr");
        movieList.add(movies3);

        return movieList;
    }


}

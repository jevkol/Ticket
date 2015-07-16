package com.kolesnic.dao;

import com.kolesnic.HibernateUtils;
import com.kolesnic.entity.Movies;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Администратор on 12.07.15.
 */
public class MoviesDao {

    public Long addMovies(Movies movies){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Long movieID = null;
        try{
            tx = session.beginTransaction();
            movieID =  (Long) session.save(movies);
            tx.commit();

        }catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return movieID;
    }

    public List<Movies> getMovies(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<Movies> movieList = new ArrayList<Movies>();
        try{
            tx = session.beginTransaction();
            List moviesL = session.createQuery("FROM MOVIES").list();
            for(Iterator iterator = moviesL.iterator(); iterator.hasNext();){
                Movies movies = (Movies) iterator.next();
                movieList.add(movies);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return movieList;
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

    public void deletMovies(Movies movies){
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
}

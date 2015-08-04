package com.kolesnic.dao;

import com.kolesnic.HibernateUtils;
import com.kolesnic.entity.Cinemas;
import com.kolesnic.entity.Movies;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 28.07.15.
 */
@Repository
@Transactional
public class HibernateCinemasRepositoryImpl implements CinemasRepository {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {return sessionFactory;}

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Long addCinemas(Cinemas cinema) throws SQLException {
        return (Long)sessionFactory.getCurrentSession().save(cinema);

//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Transaction tx = null;
//        Long cinemaID = null;
//        try {
//            tx = session.beginTransaction();
//            cinemaID =  (Long) session.save(cinema);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return cinemaID;
    }

    public void updateCinemas(Cinemas cinema) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(cinema);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public Cinemas getCinemasById(Long id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Cinemas element = null;

        try {
            tx = session.beginTransaction();
            element = (Cinemas) session.get(Cinemas.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return element;
    }

    public List<Cinemas> getAllCinemas() throws SQLException {
        return (List<Cinemas>) sessionFactory.getCurrentSession().createQuery("from Cinemas c").list();


//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Transaction tx = null;
//        List<Cinemas> cinemasList = new ArrayList<Cinemas>();
//
//        try {
//            tx = session.beginTransaction();
//            cinemasList = session.createCriteria(Cinemas.class).list();
//            tx.commit();
//
//        } catch (HibernateException e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return cinemasList;
    }

    public List<Cinemas> findAllWithDetail() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<Cinemas> cinemasList = new ArrayList<Cinemas>();

        try {
            tx = session.beginTransaction();
            cinemasList = (List<Cinemas>) session.getNamedQuery("Contact.findAllWithDetail").list();
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cinemasList;

    }


    public void deleteCinemas(Cinemas cinema) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(cinema);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public  List<Cinemas> generateCinemas() {
        List<Cinemas> cinemaList = new ArrayList<Cinemas>();
        Cinemas cinemas1 = new Cinemas();

        cinemas1.setName("Pravda");
        cinemas1.setLocation("bul Pravda, 73");
        cinemas1.setNumberOfSeats(100);
        cinemaList.add(cinemas1);

        Cinemas cinemas2 = new Cinemas();

        cinemas2.setName("Karavan");
        cinemas2.setLocation("str Niznedneprovskay, 17");
        cinemas2.setNumberOfSeats(50);
        cinemaList.add(cinemas2);

        Cinemas cinemas3 = new Cinemas();

        cinemas3.setName("Daffi");
        cinemas3.setLocation("bul Stars, 1");
        cinemas3.setNumberOfSeats(2);
        cinemaList.add(cinemas3);

        return cinemaList;
    }
}

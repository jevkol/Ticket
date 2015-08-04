package com.kolesnic.dao;

import com.kolesnic.HibernateUtils;
import com.kolesnic.entity.Schedule;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 29.07.15.
 */
@Repository
@Transactional
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {return sessionFactory;}

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Long addSchedule(Schedule schedule) throws SQLException {
        return (Long)sessionFactory.getCurrentSession().save(schedule);

    }

    @Transactional
    public List<Schedule> getAllSchedule() throws SQLException {
        return (List<Schedule>) sessionFactory.getCurrentSession().createQuery("from Schedule s").list();

    }


    public Collection getCinemasByMovieId(Long id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<Schedule> elementList = new ArrayList<Schedule>();

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Schedule.class).add(Restrictions.eq("movieId", id));
            elementList = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return elementList;
    }

    public List<Schedule> getSessionsStart(Long movieID, Long cinemaID) {


            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = null;
            List<Schedule> elementList = new ArrayList<Schedule>();

            try {
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(Schedule.class);
                criteria.add(Restrictions.eq("movieId", movieID));
                criteria.add(Restrictions.eq("cinemaId", cinemaID));
                elementList = criteria.list();
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }

            return elementList;

    }


    public void updateSchedule(Schedule schedule) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(schedule);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public Schedule getScheduleById(Long id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Schedule element = null;

        try {
            tx = session.beginTransaction();
            element = (Schedule) session.get(Schedule.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return element;
    }


    public void deleteSchedule(Schedule schedule) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(schedule);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

     public List<Schedule> generateSchedule() {

         List<Schedule> scheduleList = new ArrayList<Schedule>();
         Calendar calendar;
         calendar = Calendar.getInstance();
         Long cinemaId;
         Long movieId;
         Schedule schedule;

//         Для первого кинотеатра
         schedule = new Schedule();
         cinemaId = 1L;
         movieId = 1L;

         calendar.set(2015, Calendar.AUGUST, 1, 12, 0);
         schedule.setCinemaID(cinemaId);
         schedule.setMovieID(movieId);
         schedule.setDate(calendar);
         scheduleList.add(schedule);


         schedule = new Schedule();
         calendar = Calendar.getInstance();
         calendar.set(2015, Calendar.AUGUST, 1, 15, 0);
         schedule.setCinemaID(1L);
         schedule.setMovieID(2L);
         schedule.setDate(calendar);
         scheduleList.add(schedule);

         schedule = new Schedule();
         calendar = Calendar.getInstance();
         calendar.set(2015, Calendar.AUGUST, 1, 20, 0);
         schedule.setCinemaID(1L);
         schedule.setMovieID(3L);
         schedule.setDate(calendar);
         scheduleList.add(schedule);

//         Для кинотеатра с ID = 2

         schedule = new Schedule();
         calendar = Calendar.getInstance();
         calendar.set(2015, Calendar.AUGUST, 1, 15, 0);
         schedule.setCinemaID(2L);
         schedule.setMovieID(1L);
         schedule.setDate(calendar);
         scheduleList.add(schedule);

         schedule = new Schedule();
         calendar = Calendar.getInstance();
         calendar.set(2015, Calendar.AUGUST, 1, 18, 0);
         schedule.setCinemaID(2L);
         schedule.setMovieID(2L);
         schedule.setDate(calendar);
         scheduleList.add(schedule);

//         Для кинотеатра с ID = 3
         schedule = new Schedule();
         calendar = Calendar.getInstance();
         calendar.set(2015, Calendar.AUGUST, 2, 15, 0);
         schedule.setCinemaID(3L);
         schedule.setMovieID(2L);
         schedule.setDate(calendar);
         scheduleList.add(schedule);

         schedule = new Schedule();
         calendar = Calendar.getInstance();
         calendar.set(2015, Calendar.AUGUST, 3, 10, 0);
         schedule.setCinemaID(3L);
         schedule.setMovieID(3L);
         schedule.setDate(calendar);
         scheduleList.add(schedule);

         return scheduleList;
     }
}

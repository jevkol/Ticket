package com.kolesnic.service;

import com.kolesnic.dao.MoviesRepository;
import com.kolesnic.dao.ScheduleRepository;

import java.sql.SQLException;

/**
 * Created by Администратор on 29.07.15.
 */
public interface ScheduleService {
    ScheduleRepository getScheduleRepository();
    void setScheduleRepository(ScheduleRepository scheduleRepository);
    void setTableSchedule() throws SQLException;
}

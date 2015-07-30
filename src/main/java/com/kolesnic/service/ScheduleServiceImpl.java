package com.kolesnic.service;

import com.kolesnic.dao.ScheduleRepository;
import com.kolesnic.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 29.07.15.
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleServiceImpl() {
    }

    public ScheduleRepository getScheduleRepository() {
        return this.scheduleRepository;
    }

    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void setTableSchedule() throws SQLException {
        List<Schedule> scheduleList = scheduleRepository.generateSchedule();
        for (Schedule schedule : scheduleList) {
            schedule.setId(scheduleRepository.addSchedule(schedule));
        }


    }
}

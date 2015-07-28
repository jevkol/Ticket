package com.kolesnic.service;

import com.kolesnic.dao.CinemasRepository;
import com.kolesnic.dao.MoviesRepository;
import com.kolesnic.entity.Cinemas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 28.07.15.
 */

@Service("cinemasService")
public class CinemasServiceImpl implements CinemasService {

    @Autowired
    private CinemasRepository cinemasRepository;

    public CinemasServiceImpl (CinemasRepository cinemasRepository) { this.cinemasRepository = cinemasRepository;}
    public CinemasServiceImpl(){}

    public CinemasRepository getCinemasRepository() {
        return this.cinemasRepository;
    }


    public void setCinemasRepository(CinemasRepository cinemasRepository) {
        this.cinemasRepository = cinemasRepository;
    }

    public void setTableCinemas() throws SQLException {
        List<Cinemas> cinemaList = cinemasRepository.generateCinemas();
        for (Cinemas cinemas : cinemaList) {
            cinemas.setId(cinemasRepository.addCinemas(cinemas));
        }

    }
}

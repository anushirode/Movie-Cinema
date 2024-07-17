package movieweb.example.movie.service;

import movieweb.example.movie.entity.Cinema;
import movieweb.example.movie.entity.Movie;
import movieweb.example.movie.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Cinema addnewCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> getAllCinema() {
        //return List.of();
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaByName(String name) {
        return cinemaRepository.findByName(name);
    }
}

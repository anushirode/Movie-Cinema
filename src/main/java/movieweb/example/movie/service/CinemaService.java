package movieweb.example.movie.service;

import movieweb.example.movie.entity.Cinema;
import movieweb.example.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface CinemaService {
    public Cinema addnewCinema(Cinema cinema);
    public List<Cinema> getAllCinema();
    public Cinema getCinemaByName(String name);


}

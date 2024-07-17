package movieweb.example.movie.service;

import movieweb.example.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public Movie addMovie(Movie movie);
    public List<Movie> findAllMovies();
    public Optional<Movie> getMovieByName(String name);
}

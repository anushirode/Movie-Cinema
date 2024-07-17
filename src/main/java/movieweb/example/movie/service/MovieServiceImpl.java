package movieweb.example.movie.service;

import movieweb.example.movie.entity.Cinema;
import movieweb.example.movie.entity.Movie;
import movieweb.example.movie.repository.CinemaRepository;
import movieweb.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    private CinemaRepository cinemaRepository;


    public Movie addMovie(Movie movie) {
        Set<Cinema> existingCinemas = new HashSet<>();
        for (Cinema cinema : movie.getCinemas()) {
            // Check for existing cinema by name (assuming unique names)
            Cinema existing = cinemaRepository.findByName(cinema.getName());
            if (existing != null) {
                existingCinemas.add(existing);
            } else {
                // Save only new cinemas
                Cinema savedCinema = cinemaRepository.save(cinema);
                existingCinemas.add(savedCinema);
            }
        }

        // Access movie name from JSON
        String movieName = movie.getName();

        // Handle cases where movieName might be null or empty
        if (movieName != null && !movieName.isEmpty()) {
            movie.setName(movieName);
        } else {
            // Optional: Set a default value or throw an exception
            throw new IllegalArgumentException("Movie name cannot be null or empty");
            // movie.setName("Default Movie Name"); // Example default value
        }

        movie.setCinemas(existingCinemas); // Update movie with existing cinemas
        return movieRepository.save(movie);
    }



    public Optional<Movie> getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

}

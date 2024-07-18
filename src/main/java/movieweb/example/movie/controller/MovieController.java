package movieweb.example.movie.controller;

import movieweb.example.movie.entity.Movie;
import movieweb.example.movie.repository.MovieRepository;
import movieweb.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:3000") // Allow your React frontend origin
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/addmovie")
    public Movie addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId)
    {
        return movieRepository.findById(movieId).orElseThrow();
    }

    @GetMapping("/all")
     public List<Movie> getallmovies()
     {
         return movieService.findAllMovies();
     }

    @GetMapping("/name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        Optional<Movie> movie = movieService.getMovieByName(name);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Other methods for retrieving or managing movies and cinemas
}

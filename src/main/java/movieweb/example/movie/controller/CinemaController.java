package movieweb.example.movie.controller;

import movieweb.example.movie.entity.Cinema;
import movieweb.example.movie.entity.Movie;
import movieweb.example.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @PostMapping("/add")
    public Cinema addnewCinema(@RequestBody Cinema cinema)
    {
        Cinema cine=cinemaService.addnewCinema(cinema);
        return cine;
    }

    @GetMapping("/allcinema")
    public List<Cinema> getAllCinema()
    {
        List<Cinema> allcinema=cinemaService.getAllCinema();
        return allcinema;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Cinema> getCinemaByName(@PathVariable String name) {
        Cinema cinema = cinemaService.getCinemaByName(name);
        if (cinema != null) {
            return ResponseEntity.ok(cinema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

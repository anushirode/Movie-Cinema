package movieweb.example.movie.repository;

import movieweb.example.movie.entity.Cinema;
import movieweb.example.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Integer> {

    Cinema findByName(String name);

}

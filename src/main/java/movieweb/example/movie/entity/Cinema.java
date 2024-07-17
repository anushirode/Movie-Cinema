package movieweb.example.movie.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private int cinemaId;

    @JsonProperty("cinema_name")
    private String name;

    // Relationship is owned by Movie entity (mappedBy)
    @ManyToMany(mappedBy = "cinemas")
    private List<Movie> movies = new ArrayList<>();
}

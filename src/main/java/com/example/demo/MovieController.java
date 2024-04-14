package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// ovde za url treba da koristimo ime tabele a ne movie fiksno
@RestController
@RequestMapping({"/api/${vanja.ime.tabele}"})
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies()
    {
        return ResponseEntity.ok(this.movieRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        movie = (Movie)this.movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }
}
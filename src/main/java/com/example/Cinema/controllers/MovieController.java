package com.example.Cinema.controllers;


import com.example.Cinema.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {


    @GetMapping
    public ResponseEntity<String> listOfMovies() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getMovie(@PathVariable long id) {
        return new ResponseEntity<>("Single movie", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> getMovie() {
        Movie movie = new Movie(
                "Kingdom of the Planet of the Apes",
                "PG-13",
                145);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }




}

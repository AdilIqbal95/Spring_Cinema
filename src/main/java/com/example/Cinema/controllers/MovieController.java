package com.example.Cinema.controllers;


import com.example.Cinema.models.Message;
import com.example.Cinema.models.Movie;
import com.example.Cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> listOfMovies(@RequestParam int maxDuration) {
        return new ResponseEntity<>(movieService.filterByDuration(maxDuration), HttpStatus.OK);
    } // works with the filter but can't retrieve all movies now

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable long id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Message> updateMovieById(@PathVariable long id,
                                                   @RequestBody Movie movie) {
            movieService.updateMovieById(id,movie);
            Message message = new Message("Movie was updated!");
            return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> deleteMovieById(@PathVariable long id) {
        if (movieService.getMovieById(id).isEmpty()) {
            Message message = new Message("No movie with this id!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            movieService.deleteMovieById(id);
            Message message = new Message("Movie was deleted!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }




}

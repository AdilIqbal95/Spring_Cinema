package com.example.Cinema.services;


import com.example.Cinema.models.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id);
    }


}

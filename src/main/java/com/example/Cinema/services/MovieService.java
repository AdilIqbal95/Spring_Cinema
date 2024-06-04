package com.example.Cinema.services;


import com.example.Cinema.models.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

//    Methods related to /movies endpoint
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> filterByDuration(int maxDuration) {
            return movieRepository.findAll().stream().filter(movie -> movie.getDuration() < maxDuration).toList();
    }


    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public void updateMovieById(long id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).get();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setRating(movie.getRating());
        movieToUpdate.setDuration(movie.getDuration());
        movieRepository.save(movieToUpdate);
    }

    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }






}

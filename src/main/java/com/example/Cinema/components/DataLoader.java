package com.example.Cinema.components;


import com.example.Cinema.models.Movie;
import com.example.Cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    private Movie movie1 = new Movie(
            "Kingdom of the Planet of the Apes",
            "PG-13",
            145);
    private Movie movie2 = new Movie(
            "The Batman",
            "PG-13",
            176);
    private Movie movie3 = new Movie(
            "Spider-Man: No Way Home",
            "PG-13",
            148);

    private Movie movie4 = new Movie(
            "Dune: Part Two",
            "PG-13",
            155);

    private Movie movie5 = new Movie(
            "Avatar: The Way of Water",
            "PG-13",
            162);

    private Movie movie6 = new Movie(
            "Joker",
            "18",
            122);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieService.addMovie(this.movie1);
        movieService.addMovie(this.movie2);
        movieService.addMovie(this.movie3);
        movieService.addMovie(this.movie4);
        movieService.addMovie(this.movie5);
        movieService.addMovie(this.movie6);
    }

}

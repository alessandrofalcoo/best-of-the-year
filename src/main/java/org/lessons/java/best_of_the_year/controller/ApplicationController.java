package org.lessons.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Alessandro Falco");
        return "home";
    }

    @GetMapping("/movies")
    public String movie(Model model) {
        return "movies";
    }

    @GetMapping("/songs")
    public String song(Model model) {
        return "songs";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", 1));
        movies.add(new Movie("The Matrix", 2));

        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Passa il tempo", 1));
        songs.add(new Song("What a wonderful world", 2));

        return songs;
    }
}

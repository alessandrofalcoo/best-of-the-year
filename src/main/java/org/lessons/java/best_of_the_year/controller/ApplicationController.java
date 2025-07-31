package org.lessons.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Alessandro Falco");
        return "home";
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

    @GetMapping("/movies")
    public String movie(Model model) {
        List<Movie> movies = getBestMovies();
        String movieTitles = "";
        for (Movie m : movies) {
            if (!movieTitles.isEmpty())
                movieTitles += ", ";
            movieTitles += m.getTitle();
        }
        model.addAttribute("titles", movieTitles);
        return "movies";
    }

    @GetMapping("/songs")
    public String song(Model model) {
        List<Song> songs = getBestSongs();
        String songTitles = "";
        for (Song s : songs) {
            if (!songTitles.isEmpty())
                songTitles += ", ";
            songTitles += s.getTitle();
        }
        model.addAttribute("titles", songTitles);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movieById(@PathVariable int id, Model model) {
        List<Movie> movies = getBestMovies();
        String title = "Film non trovato";
        for (Movie m : movies) {
            if (m.getId() == id) {
                title = m.getTitle();
                break;
            }
        }
        model.addAttribute("title", title);
        return "movie";
    }

    @GetMapping("/songs/{id}")
    public String songById(@PathVariable int id, Model model) {
        List<Song> songs = getBestSongs();
        String title = "Canzone non trovata";
        for (Song s : songs) {
            if (s.getId() == id) {
                title = s.getTitle();
                break;
            }
        }
        model.addAttribute("title", title);
        return "song";
    }
}

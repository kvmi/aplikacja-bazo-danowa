package com.lewandowski.aplikacjabazodanowa.service;

import com.lewandowski.aplikacjabazodanowa.domain.Movie;

import java.util.List;

public interface MovieService {

    void addMovie(Movie movie);

    List<Movie> getMovies();

    void deleteMovieById(Long id);

    void updateMovieTitle(String title, Long id);

    void updateMovieReleaseDate(int releaseDate, Long id);


}


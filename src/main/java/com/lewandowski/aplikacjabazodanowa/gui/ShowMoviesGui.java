package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;
import com.lewandowski.aplikacjabazodanowa.domain.Movie;
import com.lewandowski.aplikacjabazodanowa.service.MovieService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("show-movies")
public class ShowMoviesGui extends VerticalLayout {

    private MovieService movieService;

    @Autowired
    public ShowMoviesGui(MovieService movieService) {
        List<Movie> movieList = movieService.getMovies();

        Grid<Movie> grid = new Grid<>(Movie.class);
        grid.setItems(movieList);
        grid.setColumns("id", "title", "releaseDate");
        routerLink();
        ;
        add(grid);

    }

    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink(" Add-Movie ", AddMovieGui.class));
        menu.add(new RouterLink(" Delete-Movie ", DeleteMovieByIdGui.class));
        menu.add(new RouterLink(" Update-Movie ", UpdateMovieGui.class));
        menu.add(new RouterLink(" Show-Actors ", ShowActorsGui.class));
        add(menu);
    }
}

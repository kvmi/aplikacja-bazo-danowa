package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.domain.Movie;
import com.lewandowski.aplikacjabazodanowa.service.MovieService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add-movie")
public class AddMovieGui extends VerticalLayout {

    private MovieService movieService;

    @Autowired
    public AddMovieGui(MovieService movieService) {

        this.movieService = movieService;
        routerLink();

        TextField placeholderFieldTitle = new TextField();
        placeholderFieldTitle.setPlaceholder("Title");

        TextField placeholderFieldReleaseDate = new TextField();
        placeholderFieldReleaseDate.setPlaceholder("Release Date");

        Button addButton = new Button("Add Movie", new Icon(VaadinIcon.CAMERA));
        Dialog dialog = new Dialog(new Label("Record added to DataBase."));

        addButton.addClickListener(buttonClickEvent -> {

            Movie movie = new Movie(placeholderFieldTitle.getValue(), Integer.parseInt(placeholderFieldReleaseDate.getValue()));
            movieService.addMovie(movie);
            dialog.open();
        });

        add(placeholderFieldTitle,placeholderFieldReleaseDate, addButton);
    }

    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink(" Show-Movies ", ShowMoviesGui.class));
        menu.add(new RouterLink(" Delete-Actor ", DeleteMovieByIdGui.class));
        menu.add(new RouterLink(" Update-Actor ", UpdateMovieGui.class));
        add(menu);
    }
}

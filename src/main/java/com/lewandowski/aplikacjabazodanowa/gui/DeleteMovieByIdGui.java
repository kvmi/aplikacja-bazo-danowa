package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.service.ActorService;
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

@Route("delete-movie")
public class DeleteMovieByIdGui extends VerticalLayout {

    private MovieService movieService;

    public DeleteMovieByIdGui(MovieService movieService) {

        this.movieService = movieService;
        routerLink();

        TextField placeholderFieldId = new TextField();
        placeholderFieldId.setPlaceholder("ID");

        Button deleteButton = new Button("Delete Movie", new Icon(VaadinIcon.CAMERA));
        Dialog dialog = new Dialog(new Label("Record deleted from DataBase."));
        deleteButton.addClickListener(buttonClickEvent ->
        {
            movieService.deleteMovieById(Long.parseLong(placeholderFieldId.getValue()));
            dialog.open();
        });

        add(placeholderFieldId, deleteButton);

    }

    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink(" Add-Movie ", AddMovieGui.class));
        menu.add(new RouterLink(" Show-Movies ", ShowMoviesGui.class));
        menu.add(new RouterLink(" Update-Movie ", UpdateMovieGui.class));
        menu.add(new RouterLink(" Show-Actors ", ShowActorsGui.class));
        add(menu);
    }
}

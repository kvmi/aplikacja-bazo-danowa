package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.service.MovieService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route("update-movie")
public class UpdateMovieGui extends VerticalLayout {

    private MovieService movieService;

    @Autowired
    public UpdateMovieGui(MovieService movieService) {
        this.movieService = movieService;

        routerLink();

        TextField placeholderFieldId = new TextField();
        placeholderFieldId.setPlaceholder("Id");

        ComboBox<String> comboBox = new ComboBox<>("Modify");
        comboBox.setItems("Title", "Release Date");

        TextField placeholderFieldModifyValue = new TextField();
        placeholderFieldModifyValue.setPlaceholder("Modify chosen value");

        Button modifyButton = new Button("Modify");

        modifyButton.addClickListener(buttonClickEvent -> {
            if (comboBox.getValue().equals("Title")) {
                movieService.updateMovieTitle(placeholderFieldModifyValue.getValue(), Long.parseLong(placeholderFieldId.getValue()));
            }
            if (comboBox.getValue().equals("Release Date")) {
                movieService.updateMovieReleaseDate(Integer.parseInt(placeholderFieldModifyValue.getValue()), Long.parseLong(placeholderFieldId.getValue()));
            }
        });

        add(placeholderFieldId, comboBox, placeholderFieldModifyValue, modifyButton);
    }

    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink(" Add-Movie ", AddMovieGui.class));
        menu.add(new RouterLink(" Delete-Movie ", DeleteMovieByIdGui.class));
        menu.add(new RouterLink(" Show-Movies ", ShowMoviesGui.class));
        menu.add(new RouterLink(" Show-Actors ", ShowActorsGui.class));
        add(menu);
    }
}

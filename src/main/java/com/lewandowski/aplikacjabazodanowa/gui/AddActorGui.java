package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;
import com.lewandowski.aplikacjabazodanowa.service.ActorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("add-actor")
public class AddActorGui extends VerticalLayout {

    private ActorService actorService;

    @Autowired
    public AddActorGui(ActorService actorService) {

        this.actorService = actorService;
        routerLink();

        TextField placeholderFieldFirstName = new TextField();
        placeholderFieldFirstName.setPlaceholder("First Name");

        TextField placeholderFieldLastName = new TextField();
        placeholderFieldLastName.setPlaceholder("Last Name");

        TextField placeholderFieldBirthYear = new TextField();
        placeholderFieldBirthYear.setPlaceholder("Birth Year");

        TextField placeholderFieldMovieAppearances = new TextField();
        placeholderFieldMovieAppearances.setPlaceholder("Movie Appearances");

        Button addButton = new Button("Add Actor", new Icon(VaadinIcon.CAMERA));

        addButton.addClickListener(buttonClickEvent -> {

            Actor actor = new Actor(placeholderFieldFirstName.getValue(), placeholderFieldLastName.getValue(),
                    placeholderFieldBirthYear.getValue(), Integer.parseInt(placeholderFieldMovieAppearances.getValue()));
            actorService.addActor(actor);
        });

        add(placeholderFieldFirstName, placeholderFieldLastName, placeholderFieldBirthYear, placeholderFieldMovieAppearances, addButton);
    }

    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink(" Show-Actor ", ShowActorsGui.class));
        menu.add(new RouterLink(" Delete-Actor ", DeleteActorByIdGui.class));
        menu.add(new RouterLink(" Update-Actor ", UpdateActorGui.class));
        menu.add(new RouterLink(" Show-Movies ", ShowMoviesGui.class));
        add(menu);
    }
}
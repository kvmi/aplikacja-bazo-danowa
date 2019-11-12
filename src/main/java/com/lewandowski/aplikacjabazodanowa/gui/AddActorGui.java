package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;
import com.lewandowski.aplikacjabazodanowa.service.ActorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("add-actor")
public class AddActorGui extends VerticalLayout {

    private ActorService actorService;

    @Autowired
    public AddActorGui(ActorService actorService) {

        this.actorService = actorService;

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
           // List<Actor> actors = new ArrayList<Actor>();
           // actors.add(actor);
            actorService.addActor(actor);
        });

        add(placeholderFieldFirstName, placeholderFieldLastName, placeholderFieldBirthYear, placeholderFieldMovieAppearances, addButton);
    }
}
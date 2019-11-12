package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.domain.Actor;
import com.lewandowski.aplikacjabazodanowa.service.ActorService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("show-actors")
public class ShowActorsGui extends VerticalLayout {

    private ActorService actorService;

    @Autowired
    public ShowActorsGui(ActorService actorService) {

        List<Actor> actorList = actorService.getActors();

        Grid<Actor> grid = new Grid<>(Actor.class);
        grid.setItems(actorList);
        grid.setColumns("id", "firstName", "lastName", "birthYear",
                "movieAppearances");
        routerLink();;
        add(grid);

    }

    void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink(" Add-Actor ", AddActorGui.class));
        menu.add(new RouterLink(" Delete-Actor ", DeleteActorByIdGui.class));
        add(menu);
    }


}

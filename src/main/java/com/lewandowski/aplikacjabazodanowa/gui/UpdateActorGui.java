package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.service.ActorService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("update-actor")
public class UpdateActorGui extends VerticalLayout {

    private ActorService actorService;

    @Autowired
    public UpdateActorGui(ActorService actorService) {
        this.actorService = actorService;

        TextField placeholderFieldFirstName = new TextField();
        placeholderFieldFirstName.setPlaceholder("First Name");
    }
}

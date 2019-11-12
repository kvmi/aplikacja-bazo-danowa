package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.service.ActorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("delete-actor")
public class DeleteActorByIdGui extends VerticalLayout {

    private ActorService actorService;

    public DeleteActorByIdGui(ActorService actorService) {

        this.actorService = actorService;

        TextField placeholderFieldId = new TextField();
        placeholderFieldId.setPlaceholder("ID");

        Button deleteButton = new Button("Delete Actor", new Icon(VaadinIcon.CAMERA));

        deleteButton.addClickListener(buttonClickEvent -> actorService.deleteActorById(Long.parseLong(placeholderFieldId.getValue())));

        add(placeholderFieldId,deleteButton);

    }
}

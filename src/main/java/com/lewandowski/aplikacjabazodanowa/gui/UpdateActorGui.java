package com.lewandowski.aplikacjabazodanowa.gui;

import com.lewandowski.aplikacjabazodanowa.service.ActorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
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

        TextField placeholderFieldId = new TextField();
        placeholderFieldId.setPlaceholder("Id");

        ComboBox<String> comboBox = new ComboBox<>("Modify");
        comboBox.setItems("First Name", "Last Name", "Birth Year","Movie Appearances");

        TextField placeholderFieldModifyValue = new TextField();
        placeholderFieldModifyValue.setPlaceholder("Modify chosen value");

        Button modifyButton = new Button("Modify");

        modifyButton.addClickListener(buttonClickEvent -> {
            if(comboBox.getValue().equals("First Name")){
                actorService.updateActorFirstName(placeholderFieldModifyValue.getValue(), Long.parseLong(placeholderFieldId.getValue()));
            }
            if(comboBox.getValue().equals("Last Name")){
                actorService.updateActorLastName(placeholderFieldModifyValue.getValue(), Long.parseLong(placeholderFieldId.getValue()));
            }
            if(comboBox.getValue().equals("Birth Year")){
                actorService.updateActorBirthYear(placeholderFieldModifyValue.getValue(), Long.parseLong(placeholderFieldId.getValue()));
            }
            if(comboBox.getValue().equals("Movie Appearances")){
                actorService.updateActorMovieAppearances(Integer.parseInt(placeholderFieldModifyValue.getValue()), Long.parseLong(placeholderFieldId.getValue()));
            }
        });

        add(placeholderFieldId, comboBox, placeholderFieldModifyValue, modifyButton);
    }
}

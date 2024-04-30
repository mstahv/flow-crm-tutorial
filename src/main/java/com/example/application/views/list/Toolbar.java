package com.example.application.views.list;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class Toolbar extends Composite<HorizontalLayout> {

    TextField filterText = new TextField();

    public Toolbar(ListView listView) {
        addClassName("toolbar");
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listView.updateList());

        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(e -> listView.addContact());
        getContent().add(filterText, addContactButton);

    }

    public String getFilter() {
        return filterText.getValue();
    }
}

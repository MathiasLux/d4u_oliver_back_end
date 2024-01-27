package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("JoinSeite")
@Route("JoinSeite")
public class JoinSeite extends VerticalLayout
{
    public JoinSeite()
    {
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        H2 text = new H2("JoinSeite");
        add(text);

        //Create Components
        TextField joinCode = new TextField("Gib den JoinCode ein");
        EmailField email = new EmailField("Gib deine Mail-Adresse ein");
        TextField username = new TextField("Username");
        Button login = new Button("Login");

        //Add Functions
        login.addClickListener(e -> login.getUI().ifPresent(ui -> ui.navigate("Bewerter_Kriterien_Vergleich")));

        //Create Layouts

        add(joinCode,email,username,login);
    }
}

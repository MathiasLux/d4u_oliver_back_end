package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.Unit;
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
        H2 header = new H2("DECISION4YOU");
        add(text,header);

        //Create Components
        VerticalLayout v1 = new VerticalLayout();
        v1.setAlignItems(Alignment.CENTER);
        VerticalLayout v2 = new VerticalLayout();
        v2.setAlignItems(Alignment.CENTER);
        VerticalLayout v3 = new VerticalLayout();
        v3.setAlignItems(Alignment.CENTER);

        H2 joinCodeT = new H2("JOIN-CODE");
        TextField joinCode = new TextField("","Gib den JoinCode ein");

        H2 mail = new H2("E-MAIL");
        EmailField email = new EmailField("","Gib deine Mail-Adresse ein");

        H2 name = new H2("USERNAME");
        TextField username = new TextField("","Username");

        Button login = new Button("Login");
        login.setWidth(10, Unit.CM);

        //Component Apperance
            //Height
//        joinCodeT.setHeight(2,Unit.CM);
//        joinCode.setHeight(2,Unit.CM);
//        mail.setHeight(2,Unit.CM);
//        email.setHeight(2,Unit.CM);
//        name.setHeight(2,Unit.CM);
//        username.setHeight(2,Unit.CM);
            //Width
        joinCode.setWidth(10,Unit.CM);
        email.setWidth(10,Unit.CM);
        username.setWidth(10,Unit.CM);

        //Add Functions
        login.addClickListener(e -> login.getUI().ifPresent(ui -> ui.navigate("Bewerter_Kriterien_Vergleich")));

        //Add Components to Layout
        v1.add(joinCodeT,joinCode);
        v2.add(mail,email);
        v3.add(name,username);

        add(v1,v2,v3,login);
    }
}

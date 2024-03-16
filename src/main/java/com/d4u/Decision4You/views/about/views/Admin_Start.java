/*
package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("AdminStart")
@Route("Admin_Start")
public class Admin_Start extends VerticalLayout
{
    public Admin_Start()
    {
        H2 ueberschrift = new H2("DECISION4YOU");
        HorizontalLayout h1 = new HorizontalLayout(ueberschrift);
        Button neu = new Button("Neu Erstellen");
        Button projekte = new Button("Meine Projekte");
        HorizontalLayout h2 = new HorizontalLayout(neu,projekte);
        Button profil = new Button("Profil");
        HorizontalLayout h3 = new HorizontalLayout(profil);

        add(h1,h2,h3);

        //Add Funcions
        neu.addClickListener(e->neu.getUI().ifPresent(ui -> ui.navigate("Admin_Neu")));
        projekte.addClickListener(e->projekte.getUI().ifPresent(ui -> ui.navigate("Admin_Aendern")));
        profil.addClickListener(e->profil.getUI().ifPresent(ui -> ui.navigate("Profil_Einstellungen")));
    }
}
*/

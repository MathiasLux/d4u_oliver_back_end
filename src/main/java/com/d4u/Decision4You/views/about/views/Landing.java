package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;


@PageTitle("Landing")
@Route("Landing")
public class Landing extends VerticalLayout
{
    public Landing()
    {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        //Create Components
        H2 header = new H2("DECISION4YOU");
        Button login = new Button("Login");
        Button join = new Button("Join Vote");
        Button about = new Button("About");

        //Set Button Destination
        login.addClickListener(e -> login.getUI().ifPresent(ui -> ui.navigate("LoginSeite")));
        join.addClickListener(e -> join.getUI().ifPresent(ui -> ui.navigate("JoinSeite")));
        about.addClickListener(e -> about.getUI().ifPresent(ui -> ui.navigate("About")));

        //Create Layouts
        HorizontalLayout h1 = new HorizontalLayout();
        HorizontalLayout h2 = new HorizontalLayout();
        HorizontalLayout h3 = new HorizontalLayout();
        VerticalLayout v1 = new VerticalLayout();
        VerticalLayout v2 = new VerticalLayout();
        VerticalLayout v3 = new VerticalLayout();

        //Add Components to Layout
        v1.add(LineAwesomeIcon.USER_ALT_SOLID.create(),login);
        v2.add(LineAwesomeIcon.BOX_OPEN_SOLID.create(),join);
        v3.add(LineAwesomeIcon.QUESTION_CIRCLE.create(),about);
        h1.add(header);
        h2.add(v1,v2);
        h3.add(v3);

        //Set Vertical Alignments
        v1.setAlignItems(Alignment.CENTER);
        v1.setWidth("1000");
        v1.setMargin(true);

        v2.setAlignItems(Alignment.CENTER);
        v2.setWidth("1000");
        v2.setMargin(true);

        v3.setAlignItems(Alignment.CENTER);

        //Set Horizontal Alignments
        //TODO
        h1.setHeight("1000");
        h1.setMargin(true);
        h1.setPadding(true);

        h2.setHeight("1000");
        h2.setMargin(true);
        h2.setPadding(true);

        h3.setHeight("1000");
        h3.setMargin(true);
        h3.setPadding(true);

        //Add to Master Layout
        add(h1,h2,h3);
    }
}

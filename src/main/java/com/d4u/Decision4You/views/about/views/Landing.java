package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;

import javax.sound.sampled.Line;


@PageTitle("Landing")
@Route("Landing")
public class Landing extends VerticalLayout
{
    public Landing()
    {

        VerticalLayout v1 = new VerticalLayout();
        v1.setAlignItems(Alignment.CENTER);
        VerticalLayout v2 = new VerticalLayout();
        v2.setAlignItems(Alignment.CENTER);
        HorizontalLayout h1 = new HorizontalLayout();
        h1.setAlignItems(Alignment.STRETCH);
        h1.setSizeFull();
        setHorizontalComponentAlignment(Alignment.CENTER);

        Button login = new Button("Login");
        login.addClickListener(e ->
                login.getUI().ifPresent(ui -> ui.navigate("LoginSeite")));
        Button join = new Button("Join Vote");
        join.addClickListener(e ->
                join.getUI().ifPresent(ui -> ui.navigate("JoinSeite")));

        v1.add(LineAwesomeIcon.USER_ALT_SOLID.create(),login);
        v2.add(LineAwesomeIcon.SIGN_IN_ALT_SOLID.create(),join);

        v1.setSizeFull();
        v2.setSizeFull();
        h1.add(v1,v2);

        add(h1);
    }
}

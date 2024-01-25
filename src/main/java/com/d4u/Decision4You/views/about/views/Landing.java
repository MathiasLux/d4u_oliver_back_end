package com.d4u.Decision4You.views.about.views;

import com.d4u.Decision4You.views.about.AboutView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.RunAs;


@PageTitle("Landing")
@Route("Landing")
public class Landing extends VerticalLayout
{
    public Landing()
    {
        Button button = new Button("Hallo");
        add(button);
    }
}

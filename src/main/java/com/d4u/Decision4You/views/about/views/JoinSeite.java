package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("JoinSeite")
@Route("JoinSeite")
public class JoinSeite extends VerticalLayout
{
    public JoinSeite()
    {
        H2 text = new H2("JoinSeite");
        add(text);
    }
}

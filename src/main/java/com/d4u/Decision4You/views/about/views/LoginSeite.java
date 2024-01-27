package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("LoginSeite")
@Route("LoginSeite")
public class LoginSeite extends VerticalLayout
{
    public LoginSeite()
    {
        H2 text = new H2("LoginSeite");
        add(text);
    }

}

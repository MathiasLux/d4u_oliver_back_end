package com.d4u.Decision4You.views.about.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("LoginSeite")
@Route("LoginSeite")
public class LoginSeite extends VerticalLayout
{
    public LoginSeite()
    {
        setAlignItems(Alignment.CENTER);

        //Create Components
        H2 header = new H2("DECISION4YOU");
        LoginForm login = new LoginForm();

        //Add Uses
        login.setError(true);
        login.addLoginListener(e-> login.getUI().ifPresent(ui -> ui.navigate("Admin_Start")));

        //Personalise Login
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setAdditionalInformation("Du hast noch keinen Account? Melde dich an mail@mail.com um einen Login zu bekommen.");

        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setI18n(i18n);

        //Add Components

        add(header,login);
    }

}

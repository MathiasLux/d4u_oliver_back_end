package com.d4u.Decision4You.views.about;

import com.d4u.Decision4You.views.about.views.Landing;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("About")
@Route(value = "")
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(false);

        Image img = new Image("images/spg-logo.png", "SPG-Enterprises");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("Spennger Enterprises");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);

        add(new Paragraph("Spezialisten für eh alles. Wir werden Ihnen schon noch helfen!"));

        Button button = new Button("Goto Landing");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui -> ui.navigate("Admin_Aendern")));
        add(button);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}

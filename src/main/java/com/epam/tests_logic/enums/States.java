package com.epam.tests_logic.enums;

import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.uitests.core.preconditions.IPreconditions;
import com.google.common.base.Supplier;

import static com.epam.tests_logic.ui.TestSite.contactFormPage;
import static com.epam.tests_logic.ui.TestSite.homePage;


public enum States implements IPreconditions {
    LOGGED_IN(() -> homePage.isLoggedIn() && 2*2 == 4,
            () -> {homePage.logIn();
                System.out.println("Hello");}),
    LOGGED_OUT(() -> !homePage.isLoggedIn(),
            () -> homePage.logOut()),
    LOG_IN_OUT_IS_OPENED(() -> homePage.loginFormIsVisible(),
            () -> homePage.openLoginForm()),
    CONTACT_PAGE(() -> contactFormPage.isOpen(),
            () -> homePage.openContactPage());

    public Supplier<Boolean> checkAction;
    public JAction moveToAction;

    States(Supplier<Boolean> checkAction, JAction moveToAction) {
        this.checkAction = checkAction;
        this.moveToAction = moveToAction;
       // alwaysMoveToCondition = true;
    }

    public Boolean checkAction() { return checkAction.get();}
    public void moveToAction() { moveToAction.invoke(); }
}

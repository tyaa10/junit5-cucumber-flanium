package org.tyaa.demo.test.desktop.java.facades;

import org.tyaa.demo.test.desktop.java.screens.MainScreen;

public class SmokeTestFacade extends AbstractFacade {

    public SmokeTestFacade switchToViewTab() throws InterruptedException {
        new MainScreen(webDriverSingletone.getDriver()).clickViewTabItem();
        return this;
    }
}

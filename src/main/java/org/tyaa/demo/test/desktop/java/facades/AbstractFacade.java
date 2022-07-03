package org.tyaa.demo.test.desktop.java.facades;

import org.tyaa.demo.test.desktop.java.utils.WinDriverSingletone;

public abstract class AbstractFacade {
    protected final WinDriverSingletone webDriverSingletone;

    public AbstractFacade() {
        webDriverSingletone = WinDriverSingletone.getInstance();
    }

    public void open(String appPathString) {
        webDriverSingletone.getDriver().get(appPathString);
    }

    public void close() {
        webDriverSingletone.closeDriver();
    }
}

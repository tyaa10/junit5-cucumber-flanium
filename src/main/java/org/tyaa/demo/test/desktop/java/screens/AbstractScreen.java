package org.tyaa.demo.test.desktop.java.screens;

import FlaNium.WinAPI.elements.Window;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractScreen {

    protected FlaNiumDriver driver;
    protected Window window;
    protected Long waitTimeSeconds = 5L;

    public AbstractScreen(FlaNiumDriver driver) throws InterruptedException {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
        wait.wait();
        window = new Window(driver.getActiveWindow());
        PageFactory.initElements(driver, this);
    }

    public void setWaitTimeSeconds(Long waitTimeSeconds) {
        this.waitTimeSeconds = waitTimeSeconds;
    }
}

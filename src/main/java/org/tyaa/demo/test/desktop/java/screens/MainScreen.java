package org.tyaa.demo.test.desktop.java.screens;

import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.elements.Window;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainScreen extends AbstractScreen {

    @FindBy(xpath = "//*[(@ControlType = 'TabItem') and (@Name = 'Вид')]")
    private TabItem viewTabItem;

    public MainScreen(FlaNiumDriver driver) throws InterruptedException {
        super(driver);
    }

    public MainScreen clickViewTabItem() {
        TabItem viewTabItem = new TabItem(driver.findElement(By.xpath("//*[(@ControlType = 'TabItem') and (@Name = 'Вид')]")));
        viewTabItem.click();
        return this;
    }
}

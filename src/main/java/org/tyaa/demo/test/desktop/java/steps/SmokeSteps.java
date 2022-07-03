package org.tyaa.demo.test.desktop.java.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tyaa.demo.test.desktop.java.facades.SmokeTestFacade;

public class SmokeSteps {

    private SmokeTestFacade facade;

    @Before
    public void setupScenario () {
        facade = new SmokeTestFacade();
    }

    @Given("Пользователь запускает приложение, расположенное по пути {string}")
    public void openApp(final String path) {
        facade.open(path);
    }

    @When("Пользователь кликает по пункту \"Вид\" главного меню")
    public void switchToViewTab() throws InterruptedException {
        facade.switchToViewTab();
    }

    @Then("Пользователь попадает на вкладку \"Вид\"")
    public void checkViewTabContent() throws InterruptedException {
        System.out.println("TODO: проверить содержимое вкладки \"Вид\"");
    }

    @After
    public void tearDownScenario() {
        facade.close();
    }
}

package org.tyaa.demo.test.desktop.java.utils;

import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class WinDriverSingletone {

    private static WinDriverSingletone instance;
    private static FlaNiumDriver driver;
    private static FlaNiumDriverService service;

    private final ThreadLocal<FlaNiumDriver> winDriverThreadLocal = new ThreadLocal<>();

    private WinDriverSingletone() {}

    public static WinDriverSingletone getInstance() {
        if (instance == null) {
            instance = new WinDriverSingletone();
        }
        return instance;
    }

    public FlaNiumDriver getDriver() {
        if (winDriverThreadLocal.get() != null) {
            return winDriverThreadLocal.get();
        }
        Integer driverPort = new PropertiesReader().getDriverPort();
        String driverLocation = new PropertiesReader().getDriverLocation();
        // String appPath = new PropertiesReader().getAppPath();
        // Инициализация драйвера:
        service = new FlaNiumDriverService.Builder()
                // Указание пути до драйвера
                .usingDriverExecutable(new File(driverLocation).getAbsoluteFile())
                // Установка порта (по умолчанию 9999)
                .usingPort(driverPort)
                // Включение режима отладки (вывод логов в консоль)
                .withVerbose(true)
                // Отключение логирования
                .withSilent(false)
                .buildDesktopService();
        // Инициализация приложения:
        DesktopOptions options = new DesktopOptions();
        // Указание пути до тестируемого приложения
        // options.setApplicationPath(appPath);
        // Задержка после запуска приложения (сек)
        options.setLaunchDelay(5);
        // Подключение к ранее запущенному экземпляру приложения
        options.setDebugConnectToRunningApp(false);
        driver = new FlaNiumDriver(service, options);
        winDriverThreadLocal.set(driver);
        return winDriverThreadLocal.get();
    }

    public void closeDriver() {
        try {
            // winDriverThreadLocal.get().quit();
            if (driver != null) {
                driver.close();
            }
            if (service != null && service.isRunning()) {
                service.stop();
            }
        }
        catch (Exception e) {
            System.err.println("Ошибка: невозможно закрыть Webdriver.");
        } finally {
            winDriverThreadLocal.remove();
        }
    }
}
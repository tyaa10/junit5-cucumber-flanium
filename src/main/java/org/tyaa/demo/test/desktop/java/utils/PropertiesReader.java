package org.tyaa.demo.test.desktop.java.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(PropertiesReader.class));
    private final static String PATH_TO_CONFIG_PROPS = "src/main/resources/config.properties";
    private Properties property = new Properties();

    public PropertiesReader() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(PATH_TO_CONFIG_PROPS);
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, String.format("Ошибка: Файл свойств %s не найдел", PATH_TO_CONFIG_PROPS));
        }
    }

    public Integer getDriverPort() {
        return Integer.parseInt(property.getProperty("WIN_DRIVER_PORT"));
    }

    public String getDriverLocation() {
        return property.getProperty("WIN_DRIVER_LOCATION");
    }

    public String getAppPath() {
        return property.getProperty("APP_PATH");
    }
}
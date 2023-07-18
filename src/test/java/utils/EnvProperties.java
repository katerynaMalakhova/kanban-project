package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

public class EnvProperties {
    private static final String PATH_TO_RESOURCE = "src/test/java/resources/";
    private static final String PROPERTIES_FILE_NAME = "env.properties";
    public static final String BROWSER = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "browser");
    public static final String HEADLESS = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "headless");
    public static final String API_URL = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "apiUrl");
    public static final String BASE_URL = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "baseUrl");
    public static final String API_USERNAME = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "username");
    public static final String API_TOKEN = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "token");
    public static final String ADMIN_USERNAME = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "adminUserName");
    public static final String ADMIN_PASSWORD = propertyValue(PATH_TO_RESOURCE, PROPERTIES_FILE_NAME, "adminPassword");


    public static String propertyValue(String pathToFile, String propertyFileName, String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        return !isNull(systemProperty) ? systemProperty : getPropertyValue(pathToFile, propertyFileName, propertyName);
    }

    private static String getPropertyValue(String pathToFile, String fileName, String propertyName) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(pathToFile + fileName)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }
}
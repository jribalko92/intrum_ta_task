package config.properties;

import constants.ConfigConstants;
import exceptions.NotValidFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigService {
    public static ConfigService instance;
    public static Properties accessProperties;
    public static Properties appProperties;
    public static Properties urlProperties;

    public static ConfigService getInstance() {
        if (instance == null) {
            instance = new ConfigService();
            setProperties();
        }

        return instance;
    }

    public static void setProperties() {
        accessProperties = getProperties("properties/access.properties");
        appProperties = getProperties("properties/app.properties");
        urlProperties = getProperties("properties/url.properties");

        manageAppProperties();
    }

    private static Properties getProperties(String file) {
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream(file);
            prop.load(input);
            input.close();
            return prop;
        } catch (IOException ex) {
            throw new NotValidFileException("Config file cannot be properly read");
        }
    }

    private static void manageAppProperties() {
        if(System.getProperty("remote") == null || System.getProperty("remote").equals("")) {
            System.setProperty("remote", appProperties.getProperty(ConfigConstants.REMOTE));
        }
        if(System.getProperty("os") == null || System.getProperty("os").equals("")) {
            System.setProperty("os", appProperties.getProperty(ConfigConstants.OS));
        }
        if(System.getProperty("browser") == null || System.getProperty("browser").equals("")) {
            System.setProperty("browser", appProperties.getProperty(ConfigConstants.BROWSER));
        }
        if(System.getProperty("defaultTimeout") == null || System.getProperty("defaultTimeout").equals("")) {
            System.setProperty("defaultTimeout", appProperties.getProperty(ConfigConstants.DEFAULT_TIMEOUT));
        }
    }
}

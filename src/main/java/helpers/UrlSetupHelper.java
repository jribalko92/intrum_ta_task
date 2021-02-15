package helpers;

import config.properties.ConfigService;
import constants.ConfigConstants;
import exceptions.NotExistingPageException;

import java.lang.reflect.Field;
import java.util.Arrays;

public class UrlSetupHelper {

    public static String getPageUrl(String page) throws IllegalAccessException {

        Field pageF = Arrays.stream(ConfigConstants.class.getFields())
                .filter(t -> t.getName().contains(page.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new NotExistingPageException(page));

        return ConfigService.urlProperties.getProperty(ConfigConstants.WEBAPP_URL) +
                ConfigService.urlProperties.getProperty(pageF.get(pageF.getType()).toString());
    }
}

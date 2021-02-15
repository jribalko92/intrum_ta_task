package config.driver;

import config.properties.ConfigService;
import enums.Browser;
import exceptions.NotValidBrowserException;
import exceptions.NotValidExecutionOptionException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

@Slf4j
public class WebDriverFactory {
    public static WebDriverFactory instance;
    public static WebDriver driver;

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
            ConfigService.getInstance();
            setDriver();
        }

        return instance;
    }

    public static void setDriver() {
        Browser browser = getBrowser(System.getProperty("browser").toUpperCase());
        //operating system support can b also added if we need to execute on different operating systems
        //os property is already added to the properties file

        switch (System.getProperty("remote")) {
            case "true": {
                driver = getRemoteWebDriver(browser);
                break;
            }
            case "false": {
                driver = getLocalWebDriver(browser);
                break;
            }
            default:
                throw new NotValidExecutionOptionException(System.getProperty("remote"));
        }
    }

    private static WebDriver getRemoteWebDriver(Browser browser) {
        switch (browser) {
            case CHROME: {
                return RemoteDriverConfig.getInstance().getRemoteChromeDriver();
            }
            case FIREFOX: {
                return RemoteDriverConfig.getInstance().getRemoteFirefoxDriver();
            }
            default:
                log.error("{} it not valid browser", browser);
                throw new NotValidBrowserException();
        }
    }

    private static WebDriver getLocalWebDriver(Browser browser) {

        switch (browser) {
            case CHROME: {
                return LocalDriverConfig.getInstance().getChromeDriver();
            }
            case FIREFOX: {
                return LocalDriverConfig.getInstance().getFirefoxDriver();
            }
            default:
                log.error("{} it not valid browser", browser);
                throw new NotValidBrowserException();
        }
    }

    private static Browser getBrowser(String expectedBrowser) {
        return Arrays.stream(Browser.values())
                .filter(t -> t.name().equals(expectedBrowser))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}

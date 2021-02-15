package config.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class RemoteDriverConfig {

    //add config to remote service

    private static final String user = "";
    private static final String accessKey = "";
    private static final String baseurl = "";

    private static RemoteDriverConfig instance;

    public static RemoteDriverConfig getInstance() {
        if (instance == null) {
            instance = new RemoteDriverConfig();
        }

        return instance;
    }

    public WebDriver getRemoteChromeDriver() {
        DesiredCapabilities chromeCaps = setChromeCapabilities();
        log.info("Chrome driver capabilities: {}", chromeCaps);

        try {
            return new RemoteWebDriver(new URL(getRemoteUrl()), chromeCaps);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Cannot connect to remote server", e);
        }
    }

    public WebDriver getRemoteFirefoxDriver() {
        DesiredCapabilities firefoxCaps = setChromeCapabilities();
        log.info("FIrefox driver capabilities: {}", firefoxCaps);

        try {
            return new RemoteWebDriver(new URL(getRemoteUrl()), firefoxCaps);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Cannot connect to remote server", e);
        }
    }

    public DesiredCapabilities setChromeCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //configure chrome capabilities based on remote service syntax

        return capabilities;
    }

    public DesiredCapabilities setFirefoxCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //configure firefox capabilities based on remote service syntax

        return capabilities;
    }

    public String getRemoteUrl() {
        //configure correct url, e.g.:
        return user + accessKey + baseurl;
    }
}

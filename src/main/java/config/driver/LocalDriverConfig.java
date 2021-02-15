package config.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Slf4j
public class LocalDriverConfig {

    private static LocalDriverConfig instance;

    public static LocalDriverConfig getInstance() {
        if (instance == null) {
            instance = new LocalDriverConfig();
        }
        return instance;
    }

    public WebDriver getChromeDriver() {
        log.info("ChromeDriver setup");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = setChromeOptions();
        log.info("Chrome options: {}", chromeOptions);
        return new ChromeDriver(chromeOptions);
    }

    public WebDriver getFirefoxDriver() {
        log.info("FirefoxDriver setup");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = setFirefoxOptions();
        log.info("Firefox options: {}", firefoxOptions);
        return new FirefoxDriver(firefoxOptions);
    }

    public ChromeOptions setChromeOptions() {
        return new ChromeOptions().addArguments(
                "--no-sandbox",
                "--disable-cache"
        );
    }

    public FirefoxOptions setFirefoxOptions() {
        return new FirefoxOptions();
    }
}

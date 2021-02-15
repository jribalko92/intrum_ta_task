package helpers;

import config.driver.WebDriverFactory;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScenarioHelper {

    public static void attachScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("Scenario failed so capturing a screenshot");
            TakesScreenshot screenshot = (TakesScreenshot) WebDriverFactory.driver;
            scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
        }
    }

    public static void endSession(){
        WebDriverFactory.driver.manage().deleteAllCookies();
        WebDriverFactory.driver.quit();
        WebDriverFactory.instance = null;
    }
}

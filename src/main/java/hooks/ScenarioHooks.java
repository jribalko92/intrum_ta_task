package hooks;

import config.driver.WebDriverFactory;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScenarioHooks implements En {

    public ScenarioHooks() {
        Before((Scenario scenario) -> {
            WebDriverFactory.getInstance();
        });
        AfterStep((Scenario scenario) -> {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) WebDriverFactory.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "name");
            }
        });
        After((Scenario scenario) -> {
            WebDriverFactory.driver.manage().deleteAllCookies();
            WebDriverFactory.driver.quit();
            WebDriverFactory.instance = null;
        });
    }
}

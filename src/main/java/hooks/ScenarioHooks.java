package hooks;

import config.driver.WebDriverFactory;
import helpers.ScenarioHelper;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

public class ScenarioHooks implements En {

    public ScenarioHooks() {
        Before((Scenario scenario) -> {
            WebDriverFactory.getInstance();
        });
        After((Scenario scenario) -> {
            ScenarioHelper.attachScreenshot(scenario);
            WebDriverFactory.driver.manage().deleteAllCookies();
            WebDriverFactory.driver.quit();
            WebDriverFactory.instance = null;
        });

    }
}

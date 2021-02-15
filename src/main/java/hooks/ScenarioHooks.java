package hooks;

import config.driver.WebDriverFactory;
import helpers.ScenarioHelper;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

public class ScenarioHooks implements En {

    public ScenarioHooks() {
        Before((Scenario scenario) -> {
            WebDriverFactory.getInstance();

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    ScenarioHelper.endSession();
                }
            });
        });
        After((Scenario scenario) -> {
            ScenarioHelper.attachScreenshot(scenario);
            ScenarioHelper.endSession();
        });
    }
}

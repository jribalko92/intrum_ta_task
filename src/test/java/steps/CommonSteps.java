package steps;

import com.google.inject.Inject;
import config.driver.WebDriverFactory;
import helpers.UrlSetupHelper;
import io.cucumber.java8.En;
import pageObjects.CommonPageObject;

public class CommonSteps implements En {

    @Inject
    CommonPageObject commonPageObject;

    public CommonSteps() {
        Given("^I am on \"([^\"]*)\" page$", (String page) -> {
            WebDriverFactory.driver.get(UrlSetupHelper.getPageUrl(page));
        });
        And("^I accept all cookies$", () -> {
            commonPageObject.clickAcceptAllCookiesButton();
        });
    }
}

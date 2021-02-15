package steps;

import com.google.inject.Inject;
import io.cucumber.java8.En;
import pageObjects.ContactPageObject;

public class ContactPageSteps implements En {

    @Inject
    ContactPageObject contactPageObject;

    public ContactPageSteps() {
        When("^I click \"([^\"]*)\" button$", (String button) -> {
            contactPageObject.clickOpenContactFormButton();
        });
    }
}

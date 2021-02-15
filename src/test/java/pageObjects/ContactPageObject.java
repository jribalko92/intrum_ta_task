package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.webpages.Awaits;
import utils.webpages.PageGenerator;

public class ContactPageObject extends PageGenerator {

    @FindBy(xpath = "//a[contains(., 'Forma')]")
    public WebElement openContactFormButton;

    public ContactPageObject() {
        super(ContactPageObject.class);
    }

    public void clickOpenContactFormButton() {
        Awaits.waitForConditionFulfilled(() -> openContactFormButton.isDisplayed() && openContactFormButton.isEnabled());
        openContactFormButton.click();
    }
}

package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.webpages.Awaits;
import utils.webpages.PageGenerator;

public class CommonPageObject extends PageGenerator {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptAllCookiesButton;

    public CommonPageObject() {
        super(CommonPageObject.class);
    }

    public void clickAcceptAllCookiesButton() {
        Awaits.waitForConditionFulfilled(() -> acceptAllCookiesButton.isDisplayed()
                && acceptAllCookiesButton.isEnabled());

        acceptAllCookiesButton.click();
    }

    public void fillInData(WebElement element, String data) {
        Awaits.waitForConditionFulfilled(() -> element.isDisplayed());
        element.sendKeys(data);
    }
}

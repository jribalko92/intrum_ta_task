package pageObjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.dictionaries.LVDictionary;
import utils.webpages.Awaits;
import utils.webpages.PageGenerator;

public class ContactPageObject extends PageGenerator {

    String formButton = "//a[contains(., '" + LVDictionary.getDictionaryValue("form_button") + "')]";

    @FindBy(xpath = "//a[contains(., 'Forma')]")
    public WebElement openContactFormButton;

    public ContactPageObject() {
        super(ContactPageObject.class);
    }

    public void clickOpenContactFormButton() {
        Awaits.waitForButtonToBeClicked(() -> openContactFormButton.click());
    }
}

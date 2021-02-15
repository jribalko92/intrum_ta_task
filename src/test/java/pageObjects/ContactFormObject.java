package pageObjects;

import com.google.inject.Inject;
import dataObjects.ContactForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.webpages.Awaits;
import utils.webpages.PageGenerator;

public class ContactFormObject extends PageGenerator {

    @Inject
    CommonPageObject commonPageObject;

    @FindBy(id = "slide")
    public WebElement contactForm;

    @FindBy(xpath = "//div[@id = 'slide']//h1")
    public WebElement title;

    @FindBy(xpath = "//div[@id = 'slide']//div[h1]//p")
    public WebElement headingCommentInfoBlock;

    @FindBy(xpath = "//div[contains(@class, 'vārdsuzvārds')]//input")
    public WebElement nameSurnameInputField;

    @FindBy(xpath = "//div[contains(@class, 'vārdsuzvārds')]//span[contains(@class,'field-validation-error')]")
    public WebElement nameSurnameError;

    @FindBy(xpath = "//div[contains(@class, 'personaskods')]//input")
    public WebElement ssnInputField;

    @FindBy(xpath = "//div[contains(@class, 'personaskods')]//span[contains(@class,'field-validation-error')]")
    public WebElement ssnError;

    @FindBy(xpath = "//div[contains(@class, 'lietasnumursnavobligāts')]//input")
    public WebElement caseNumInputField;

    @FindBy(xpath = "//div[contains(@class, 'lietasnumursnavobligāts')]//span[contains(@class,'field-validation-error')]")
    public WebElement caseNumError;

    @FindBy(xpath = "//div[contains(@class, 'kontakttālrunis')]//input")
    public WebElement phoneInputField;

    @FindBy(xpath = "//div[contains(@class, 'kontakttālrunis')]//span[contains(@class,'field-validation-error')]")
    public WebElement phoneError;

    @FindBy(xpath = "//div[contains(@class, 'epastaadrese')]//input")
    public WebElement emailInputField;

    @FindBy(xpath = "//div[contains(@class, 'epastaadrese')]//span[contains(@class,'field-validation-error')]")
    public WebElement emailError;

    @FindBy(xpath = "//div[contains(@class, 'adrese')][label[contains(., 'Adrese')]]//input")
    public WebElement addressInputField;

    @FindBy(xpath = "//div[contains(@class, 'adrese')][label[contains(., 'Adrese')]]//span[contains(@class,'field-validation-error')]")
    public WebElement addressError;

    @FindBy(xpath = "//div[contains(@class, 'komentāraiebildumubūtība')]//textarea")
    public WebElement commentInputField;

    @FindBy(xpath = "//div[contains(@class, 'komentāraiebildumubūtība')]//span[contains(@class,'field-validation-error')]")
    public WebElement commentError;

    @FindBy(xpath = "//div[contains(@class, 'kāvēlossaņemtatbildi')]//select")
    public WebElement replyDropDown;

    @FindBy(xpath = "//div[contains(@class, 'kāvēlossaņemtatbildi')]//span[contains(@class,'field-validation-error')]")
    public WebElement replyError;

    @FindBy(xpath = "//input[@value = 'Iesniegt']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[div[contains(@class, 'umbraco-forms-form')]]//p[contains(., '30')]")
    public WebElement fieldsCommentsInfoBlock;

    @FindBy(xpath = "//div[div[contains(@class, 'umbraco-forms-form')]]//p[contains(., 'Intrum')]")
    public WebElement anonymousCommentsInfoBlock;

    @FindBy(xpath = "//div[div[contains(@class, 'umbraco-forms-form')]]//p[contains(., 'LV')]")
    public WebElement personDataPolicyInfoBlock;

    public ContactFormObject() {
        super(ContactFormObject.class);
    }

    public boolean isTitleDisplayed() {
        Awaits.waitForElementToBeDisplayed(() -> title.isDisplayed());
        return title.isDisplayed();
    }

    public void fillInContactFormFields(ContactForm formData) {
        if (!formData.getName().isEmpty() || !formData.getSurname().isEmpty())
            commonPageObject.fillInData(nameSurnameInputField, formData.getName() + " " + formData.getSurname());

        commonPageObject.fillInData(ssnInputField, formData.getSsn());
        commonPageObject.fillInData(caseNumInputField, formData.getCaseNumber());
        commonPageObject.fillInData(phoneInputField, formData.getPhone());
        commonPageObject.fillInData(emailInputField, formData.getEmail());
        commonPageObject.fillInData(addressInputField, formData.getAddress());
        commonPageObject.fillInData(commentInputField, formData.getComment());

        selectReplyOption(formData.getReply());
    }

    public void selectReplyOption(String option) {
        Select replyOption = new Select(replyDropDown);
        replyOption.selectByValue(option);
    }

    public boolean isNameSurnameErrorDisplayed() {
        Awaits.waitForElementToBeDisplayed(() -> nameSurnameError.isDisplayed());
        return nameSurnameError.isDisplayed();
    }

    public void clickSubmitButton() {
        Awaits.waitForButtonToBeEnabled(() -> submitButton.isEnabled());
        submitButton.click();
    }
}

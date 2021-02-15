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

    @FindBy(id = "71a2bb97-3a3f-434b-e36d-344d0907e7b9")
    public WebElement nameSurnameInputField;

    @FindBy(xpath = "//input[@id = '71a2bb97-3a3f-434b-e36d-344d0907e7b9']/following-sibling::span[@class='field-validation-error']")
    public WebElement nameSurnameError;

    @FindBy(id = "0348625f-721d-430f-f61b-3ea1a44df7b6")
    public WebElement ssnInputField;

    @FindBy(xpath = "//input[@id = '0348625f-721d-430f-f61b-3ea1a44df7b6']/following-sibling::span[@class='field-validation-error']")
    public WebElement ssnError;

    @FindBy(id = "a6c1035f-7675-445b-ab1f-186d4481692f")
    public WebElement caseNumInputField;

    @FindBy(xpath = "//input[@id = 'a6c1035f-7675-445b-ab1f-186d4481692f']/following-sibling::span[@class='field-validation-error']")
    public WebElement caseNumError;

    @FindBy(id = "ffc40b29-dfa8-42d8-d33a-1602ef5a4622")
    public WebElement phoneInputField;

    @FindBy(xpath = "//input[@id = 'ffc40b29-dfa8-42d8-d33a-1602ef5a4622']/following-sibling::span[@class='field-validation-error']")
    public WebElement phoneError;

    @FindBy(id = "c9247843-f302-4fa6-a1b4-2a75b06a95ee")
    public WebElement emailInputField;

    @FindBy(xpath = "//input[@id = 'c9247843-f302-4fa6-a1b4-2a75b06a95ee']/following-sibling::span[@class='field-validation-error']")
    public WebElement emailError;

    @FindBy(id = "6bbc463e-6ce2-4f52-de13-4777aef7dce7")
    public WebElement addressInputField;

    @FindBy(xpath = "//input[@id = '6bbc463e-6ce2-4f52-de13-4777aef7dce7']/following-sibling::span[@class='field-validation-error']")
    public WebElement addressError;

    @FindBy(id = "bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a")
    public WebElement commentInputField;

    @FindBy(xpath = "//textarea[@id = 'bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a']/following-sibling::span[@class='field-validation-error']")
    public WebElement commentError;

    @FindBy(id = "e9a9505d-196d-4bac-8d8f-f8a3f406934d")
    public WebElement replyDropDown;

    @FindBy(xpath = "//select[@id = 'e9a9505d-196d-4bac-8d8f-f8a3f406934d']/following-sibling::span[@class='field-validation-error']")
    public WebElement replyError;

    @FindBy(xpath = "//input[@value = 'Iesniegt']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id = 'umbraco_form_ac853551216f485dbc0fd40626414f2b']/following-sibling::p[1]")
    public WebElement fieldsCommentsInfoBlock;

    @FindBy(xpath = "//*[@id = 'umbraco_form_ac853551216f485dbc0fd40626414f2b']/following-sibling::p[2]")
    public WebElement anonymousCommentsInfoBlock;

    @FindBy(xpath = "//*[@id = 'umbraco_form_ac853551216f485dbc0fd40626414f2b']/following-sibling::p[3]")
    public WebElement personDataPolicyInfoBlock;

    public ContactFormObject() {
        super(ContactFormObject.class);
    }

    public boolean isTitleDisplayed() {
        Awaits.waitForConditionFulfilled(() -> title.isDisplayed());
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
        Awaits.waitForConditionFulfilled(() -> nameSurnameError.isDisplayed());
        return nameSurnameError.isDisplayed();
    }

    public void clickSubmitButton() {
        Awaits.waitForConditionFulfilled(() -> submitButton.isEnabled() && submitButton.isDisplayed());
        submitButton.click();
    }
}

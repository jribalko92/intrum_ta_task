package steps;

import com.google.inject.Inject;
import dataObjects.ContactFormErrors;
import dataObjects.ContactFormList;
import helpers.CsvHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import pageObjects.ContactFormObject;
import utils.dictionaries.LVDictionary;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactFormSteps implements En {

    @Inject
    ContactFormObject contactFormObject;
    @Inject
    LVDictionary dictionary;
    @Inject
    ContactFormList contactFormList;

    public ContactFormSteps() {
        Then("^I can see Contact Form$", () -> {
            assertTrue(contactFormObject.contactForm.isDisplayed());
        });
        And("^I can see title in Contact Form$", () -> {
            assertTrue(contactFormObject.isTitleDisplayed());
        });
        And("^I can see these input fields in Contact Form$", (DataTable dt) -> {
            List<String> options = dt.asList(String.class);

            for (String option : options) {
                switch (option) {
                    case "nameSurname": {
                        assertTrue(contactFormObject.nameSurnameInputField.isDisplayed());
                        break;
                    }
                    case "ssn": {
                        assertTrue(contactFormObject.ssnInputField.isDisplayed());
                        break;
                    }
                    case "caseNumber": {
                        assertTrue(contactFormObject.caseNumInputField.isDisplayed());
                        break;
                    }
                    case "phone": {
                        assertTrue(contactFormObject.phoneInputField.isDisplayed());
                        break;
                    }
                    case "email": {
                        assertTrue(contactFormObject.emailInputField.isDisplayed());
                        break;
                    }
                    case "address": {
                        assertTrue(contactFormObject.addressInputField.isDisplayed());
                        break;
                    }
                    case "comment": {
                        assertTrue(contactFormObject.commentInputField.isDisplayed());
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("ERROR! OPTION WITH TITLE DOES NOT EXIST: " + option);
                }
            }
        });
        And("^I can see \"([^\"]*)\" dropdown in Contact Form$", (String dropdown) -> {
            switch (dropdown) {
                case "reply": {
                    assertTrue(contactFormObject.replyDropDown.isDisplayed());
                    break;
                }
                default:
                    throw new IllegalArgumentException("ERROR! DROPDOWN WITH TITLE DOES NOT EXIST: " + dropdown);
            }
        });
        And("^I can see \"([^\"]*)\" button in Contact Form$", (String button) -> {
            switch (button) {
                case "submit": {
                    assertTrue(contactFormObject.submitButton.isDisplayed());
                    break;
                }
                default:
                    throw new IllegalArgumentException("ERROR! BUTTON WITH TITLE DOES NOT EXIST: " + button);
            }
        });
        And("^I can see info blocks in Contact Form$", (DataTable dt) -> {
            List<String> options = dt.asList(String.class);

            for (String option : options) {
                switch (option) {
                    case "heading comment": {
                        assertTrue(contactFormObject.headingCommentInfoBlock.isDisplayed());
                        assertEquals(contactFormObject.headingCommentInfoBlock.getText(), dictionary.getDictionaryValue(option));
                        break;
                    }
                    case "fields comments": {
                        assertTrue(contactFormObject.fieldsCommentsInfoBlock.isDisplayed());
                        assertEquals(contactFormObject.fieldsCommentsInfoBlock.getText(), dictionary.getDictionaryValue(option));
                        break;
                    }
                    case "anonymous comment": {
                        assertTrue(contactFormObject.anonymousCommentsInfoBlock.isDisplayed());
                        assertEquals(contactFormObject.anonymousCommentsInfoBlock.getText(), dictionary.getDictionaryValue(option));
                        break;
                    }
                    case "person data policy": {
                        assertTrue(contactFormObject.personDataPolicyInfoBlock.isDisplayed());
                        assertEquals(contactFormObject.personDataPolicyInfoBlock.getText(), dictionary.getDictionaryValue(option));
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("ERROR! OPTION WITH TITLE DOES NOT EXIST: " + option);
                }
            }
        });
        When("^I parse data from \"([^\"]*)\" csv file$", (String fileName) -> {
            contactFormList.setContactFormList(CsvHelper.getContactFormDataFormFromCsv(fileName));
        });
        And("^I insert data from (\\d+) row into fields in Contract Form$", (Integer row) -> {
            contactFormObject.fillInContactFormFields(contactFormList.getContactFormList().get(row - 1));
        });
        And("^I submit data in Contract Form$", () -> {
            contactFormObject.clickSubmitButton();
        });

        DataTableType("[blank]", (Map<String, String> entry) -> new ContactFormErrors(
                entry.get("nameSurname"),
                entry.get("ssn"),
                entry.get("caseNumber"),
                entry.get("phone"),
                entry.get("email"),
                entry.get("address"),
                entry.get("comment"),
                entry.get("reply")
        ));

        Then("^I can see error messages for fields$", (DataTable errorsData) -> {
            List<ContactFormErrors> errors = errorsData.asList(ContactFormErrors.class);

            for (ContactFormErrors error : errors) {
                if (!error.getNameSurname().isEmpty()) {
                    assertTrue(contactFormObject.isNameSurnameErrorDisplayed());
                    assertEquals(contactFormObject.nameSurnameError.getText(), dictionary.getDictionaryValue(error.getNameSurname()));
                }

                if (!error.getSsn().isEmpty()) {
                    assertTrue(contactFormObject.ssnError.isDisplayed());
                    assertEquals(contactFormObject.ssnError.getText(), dictionary.getDictionaryValue(error.getSsn()));
                }

                if (!error.getCaseNumber().isEmpty()) {
                    assertTrue(contactFormObject.caseNumError.isDisplayed());
                    assertEquals(contactFormObject.caseNumError.getText(), dictionary.getDictionaryValue(error.getCaseNumber()));
                }

                if (!error.getPhone().isEmpty()) {
                    assertTrue(contactFormObject.phoneError.isDisplayed());
                    assertEquals(contactFormObject.phoneError.getText(), dictionary.getDictionaryValue(error.getPhone()));
                }

                if (!error.getEmail().isEmpty()) {
                    assertTrue(contactFormObject.emailError.isDisplayed());
                    assertEquals(contactFormObject.emailError.getText(), dictionary.getDictionaryValue(error.getEmail()));
                }

                if (!error.getAddress().isEmpty()) {
                    assertTrue(contactFormObject.addressError.isDisplayed());
                    assertEquals(contactFormObject.addressError.getText(), dictionary.getDictionaryValue(error.getAddress()));
                }

                if (!error.getComment().isEmpty()) {
                    assertTrue(contactFormObject.commentError.isDisplayed());
                    assertEquals(contactFormObject.commentError.getText(), dictionary.getDictionaryValue(error.getComment()));
                }

                if (!error.getReply().isEmpty()) {
                    assertTrue(contactFormObject.replyError.isDisplayed());
                    assertEquals(contactFormObject.replyError.getText(), dictionary.getDictionaryValue(error.getReply()));
                }
            }
        });
    }
}

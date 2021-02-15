@ContactForm
Feature: ContactForm
  In order to post objections and comments
  As a new user
  I want to be able to fill in an objections and comments form

  Background: User navigates to contact form
#    Depending on functionality, we can start from homepage as first step and navigate to Contact page as second step
    Given I am on "Contact" page
    And I accept all cookies
    When I click "Form" button
    Then I can see Contact Form

  @ContactForm @smoke
  Scenario: Check contact form fields
    And I can see title in Contact Form
    And I can see these input fields in Contact Form
      | nameSurname |
      | ssn         |
      | caseNumber  |
      | phone       |
      | email       |
      | address     |
      | comment     |
    And I can see "reply" dropdown in Contact Form
    And I can see "submit" button in Contact Form
    And I can see info blocks in Contact Form
      | heading comment    |
      | fields comments    |
      | anonymous comment  |
      | person data policy |

  @ContactForm @validations
  Scenario Outline: Check Contact Form validations
    When I parse data from "validation_data.csv" csv file
    And I insert data from <row> row into fields in Contract Form
    And I submit data in Contract Form
    Then I can see error messages for fields
      | nameSurname  | ssn        | caseNumber     | phone        | email        | address        | comment        | reply        |
      | <nameSError> | <ssnError> | <caseNumError> | <phoneError> | <emailError> | <addressError> | <commentError> | <replyError> |

    Examples:
      | row | nameSError      | ssnError        | caseNumError | phoneError      | emailError      | addressError    | commentError    | replyError |
      | 1   | mandatory error | mandatory error | [blank]      | mandatory error | mandatory error | mandatory error | mandatory error | [blank]    |
      | 2   | mandatory error | mandatory error | [blank]      | [blank]         | [blank]         | [blank]         | [blank]         | [blank]    |




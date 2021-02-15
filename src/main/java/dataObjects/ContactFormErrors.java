package dataObjects;

import io.cucumber.guice.ScenarioScoped;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@ScenarioScoped
@Data
public class ContactFormErrors {

    private String nameSurname;

    private String ssn;

    private String caseNumber;

    private String phone;

    private String email;

    private String address;

    private String comment;

    private String reply;
}

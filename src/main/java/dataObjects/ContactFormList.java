package dataObjects;

import io.cucumber.guice.ScenarioScoped;
import lombok.Data;

import java.util.List;

@ScenarioScoped
@Data
public class ContactFormList {

    private List<ContactForm> contactFormList;
}

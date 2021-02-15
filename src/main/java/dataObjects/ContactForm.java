package dataObjects;

import com.opencsv.bean.CsvBindByName;
import io.cucumber.guice.ScenarioScoped;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ScenarioScoped
@Data
@Getter
@Setter
public class ContactForm {

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String surname;

    @CsvBindByName
    private String ssn;

    @CsvBindByName
    private String caseNumber;

    @CsvBindByName
    private String phone;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String address;

    @CsvBindByName
    private String comment;

    @CsvBindByName
    private String reply;
}

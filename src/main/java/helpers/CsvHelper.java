package helpers;

import com.opencsv.bean.CsvToBeanBuilder;
import dataObjects.ContactForm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvHelper {

    public static List<ContactForm> getContactFormDataFormFromCsv(String fileName) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader("src/main/resources/csv/" + fileName))
                .withType(ContactForm.class)
                .build()
                .parse();
    }
}

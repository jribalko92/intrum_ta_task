package utils.webpages;

import config.driver.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public PageGenerator(Class pageClass) {
        PageFactory.initElements(WebDriverFactory.getInstance().driver, this);
    }
}

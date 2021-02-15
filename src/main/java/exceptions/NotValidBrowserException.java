package exceptions;

import enums.Browser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotValidBrowserException extends RuntimeException{
    public NotValidBrowserException() {
        super("Chosen browser is not valid one. Please choose one of available: " + getAvailableBrowsersList());
    }

    private static List<String> getAvailableBrowsersList() {
        return Arrays.stream(Browser.values())
                .map(Browser::getBrowser)
                .collect(Collectors.toList());
    }
}

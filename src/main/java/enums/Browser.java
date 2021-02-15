package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox");

    private final String browser;
}

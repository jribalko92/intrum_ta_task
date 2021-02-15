package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox");

    private final String browser;
}

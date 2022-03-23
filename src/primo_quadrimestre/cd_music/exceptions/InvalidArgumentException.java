package primo_quadrimestre.cd_music.exceptions;

import java.text.NumberFormat;

public class InvalidArgumentException extends CdException {
    public InvalidArgumentException(String argument, String parameter) {
        super("Invalid " + parameter + ": " + argument);
    }

    public InvalidArgumentException(double argument) {
        super("Invalid price: " + NumberFormat.getCurrencyInstance().format(argument));
    }
}

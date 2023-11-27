package util;

/**
 * Jedynym przeznaczeniem tej klasy jest funkcja log
 *
 * @author Bartosz W
 */
public class Console {

    /**
     * Dzięki tej funkcji nie musisz już pisać System.out.println(str)
     *
     * @param message wiadomość do konsoli
     * @author Bartosz W
     */
    public static void log(String message) {
        System.out.println(message);
    }
}

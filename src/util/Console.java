package util;

/**
 * Jedynym przeznaczeniem tej klasy jest funkcja log
 *
 * @author Bartosz Węgrzyn
 */
public class Console {

    /**
     * Dzięki tej funkcji nie musisz już pisać System.out.println(str)
     *
     * @param message wiadomość do konsoli
     * @author Bartosz Węgrzyn
     */
    public static void log(Object message) {
        System.out.println(message);
    }
}

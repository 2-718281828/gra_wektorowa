package engine;

/**
 * Interfejs zajmujący się logiką;
 */
public interface Logic {
    /**
     * Ta funckja jest wywoływana 60 razy na sekundę i jest odpowiedzialna za logikę. Nie ma potrzeby
     * mnożenia przez delta time.
     * @author Bartosz Węgrzyn
     */
    public abstract void update();
}

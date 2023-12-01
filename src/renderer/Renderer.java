package renderer;

import main.Main;
import maths.Vector2;
import maths.Vector3;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Klasa zajmująca się renderowaniem
 * @author Bartosz Węgrzyn
 */
public abstract class Renderer extends Canvas {

    public Vector2 dimensions;

    public Renderer(Vector2 dimensions) {
        this.dimensions = new Vector2(dimensions);
    }

    /**
     * Funkcja wywoływana każdą klatkę zajmująca się renderowaniem do okna
     * @author Bartosz Węgrzyn
     */
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bs.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, (int) (dimensions.x + 100), (int) (dimensions.y + 100));

        render((Graphics2D) graphics);

        graphics.dispose();
        bs.show();
    }

    /**
     * Renderowanie
     * @param graphics obiekt Graphics2D
     * @author Bartosz Węgrzyn
     */
    public abstract void render(Graphics2D graphics);
}

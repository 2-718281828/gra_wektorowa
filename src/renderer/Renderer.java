package renderer;

import main.Main;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Klasa zajmująca się renderowaniem
 * @author Bartosz Węgrzyn
 */
public class Renderer extends Canvas {

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

        // rysowanie
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        graphics.dispose();
        bs.show();
    }
}

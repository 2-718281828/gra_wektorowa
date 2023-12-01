package renderer;

import maths.Vector2;

import javax.swing.*;
import java.awt.*;

/**
 * Ta klasa tworzy nowe okno
 *
 * @author Bartosz Węgrzyn
 */
public class Window {

    /**
     * Konstruktor, tworzy nowe okno
     *
     * @param dimensions wymiary okna
     * @param title      tytuł okna
     * @param canvas     obiekt Canvas na którym wszystko jest renderowane
     * @author Bartosz Węgrzyn
     */
    public Window(Vector2 dimensions, String title, Canvas canvas) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension((int) dimensions.x + 10, (int) dimensions.y + 35));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(canvas);
    }
}

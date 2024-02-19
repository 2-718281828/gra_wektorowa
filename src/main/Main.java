package main;

import engine.*;
import maths.*;
import renderer.*;

/**
 * W tej klasie są inicjalizowane najważniesze procesy
 *
 * @author Bartosz Węgrzyn
 */
public class Main {

    public static final int WIDTH = 1280, HEIGHT = 720;
    public static final String TITLE = "Gra wektorowa";

    public static void main(String[] args) {
        Camera camera = new Camera();
        RendererTest renderer = new RendererTest(new Vector2(WIDTH, HEIGHT), camera);
        Window window = new Window(new Vector2(WIDTH, HEIGHT), TITLE, renderer);
        renderer.addKeyListener(camera);
        renderer.addMouseMotionListener(camera);
        renderer.requestFocus();
        LogicTest lt = new LogicTest(renderer, camera);
        Engine engine = new Engine(renderer, lt);
        engine.start();
    }
}

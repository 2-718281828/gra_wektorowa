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
        Renderer renderer = new Renderer();
        Window window = new Window(new Vector2(WIDTH, HEIGHT), TITLE, renderer);
        LogicTest lt = new LogicTest();
        Engine engine = new Engine(renderer, lt);
        engine.start();
    }
}

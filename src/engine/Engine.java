package engine;

import renderer.Renderer;
import util.Console;

/**
 * Ta klasa zawiera pętlę programu
 * @author Bartosz Węgrzyn
 */
public class Engine implements Runnable {

    private Renderer renderer;
    private Logic logic;
    private Thread thread;
    private boolean running = false;

    /**
     * Konstruktor
     * @param renderer obiekt Renderer
     * @param logic obiekt Logic
     * @author Bartosz Węgrzyn
     */
    public Engine(Renderer renderer, Logic logic) {
        this.renderer = renderer;
        this.logic = logic;
    }

    /**
     * Rozpoczyna działanie programu
     * @author Bartosz Węgrzyn
     */
    public void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double fixedDeltaTime = 1.0f / 60.0f;
        double accumulatedTime = 0.0f;
        long timer = System.currentTimeMillis();
        int FPS = 0;

        while (running) {
            long now = System.nanoTime();
            double deltaTime = (now - lastTime) / 1.0e9;
            lastTime = now;

            accumulatedTime += deltaTime;

            while (accumulatedTime >= fixedDeltaTime) {
                logic.update();
                accumulatedTime -= fixedDeltaTime;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                Console.log("FPS: " + FPS);
                FPS = 0;
                timer = System.currentTimeMillis();
            }

            renderer.render();
            FPS++;
        }
    }

    /**
     * Zakańcza działanie programu
     * @author Bartosz Węgrzyn
     */
    public void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
    }
}

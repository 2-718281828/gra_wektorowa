package main;

import engine.Logic;

/**
 * Tymczasowa klasa do testowania logiki
 * @author Bartosz Węgrzyn
 */
public class LogicTest implements Logic {

    RendererTest renderer;

    public LogicTest(RendererTest renderer) {
        this.renderer = renderer;
    }

    public void update() {
        renderer.triangle.rotateRoll(0.01f);
        renderer.triangle.rotatePitch(0.03f);
        renderer.triangle.rotateYaw(0.008f);
    }
}

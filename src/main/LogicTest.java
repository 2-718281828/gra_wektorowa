package main;

import engine.Logic;
import maths.Vector3;
import renderer.Camera;

/**
 * Tymczasowa klasa do testowania logiki
 * @author Bartosz Węgrzyn
 */
public class LogicTest implements Logic {

    RendererTest renderer;
    Camera camera;

    public LogicTest(RendererTest renderer, Camera camera) {
        this.renderer = renderer;
        this.camera = camera;
    }

    public void update() {
        camera.update();
//        renderer.triangle1.translate(new Vector3(0f, 0f, 0.005f));
//        renderer.triangle1.rotatePitch(0.01f);
//        renderer.triangle2.translate(new Vector3(0f, 0f, 0.02f));
//        renderer.triangle2.rotateRoll(0.01f);
    }
}

package renderer;

import maths.Matrix3x3;
import maths.Vector3;
import util.Console;

import java.awt.*;

/**
 * Ta klasa implementuje najbardziej podstawowy kształt w grafice 3D - trójkąt.
 *
 * @author Bartosz Węgrzyn
 */
public class Triangle {
    public final int nVerticies = 3;
    /**
     * Wartości wprowadzane do składowych wektora powinny wynosić od -1.0 do 1.0. <br>
     * (0, 0) - środek ekranu <br>
     * (-1, -1) - lewy dolny róg <br>
     * (1, 1) - prawy górny róg <br>
     * (-1, 1) - lewy górny róg <br>
     * (1, -1) - prawy dolny róg <br>
     *
     * @author Bartosz Węgrzyn
     */
    public Vector3[] verticies = new Vector3[nVerticies];
    Renderer renderer;
    Camera camera;
    int[] xVerticies = new int[nVerticies];
    int[] yVerticies = new int[nVerticies];
    /**
     * Kolor jest domyślnie biały
     *
     * @author Bartosz Węgrzyn
     */
    public Color color = Color.WHITE;
    float avgDistance = 0;

    /**
     * Konstruktor
     *
     * @param verticies wierzchołki trójkąta
     * @param renderer  obiekt Renderer
     * @param camera    obiekt Camera
     * @author Bartosz Węgrzyn
     */
    public Triangle(Vector3[] verticies, Renderer renderer, Camera camera) {
        for (int i = 0; i < nVerticies; i++) {
            this.verticies[i] = new Vector3(verticies[i]);
        }
        this.renderer = renderer;
        this.camera = camera;
        updateVerticies();
    }

    /**
     * Tę funkcję należy wywołać za każdym razem, gdy zmieniamy wartości wektorów wierzchołków,
     * np. podczas transformacji. Jest ona wywoływana również za każdym razem, kiedy zostaje
     * wywołana funkcja render.
     *
     * @author Bartosz Węgrzyn
     */
    public void updateVerticies() {
        avgDistance = 0;
        if (renderer.perspective) {
            camera.position.multiply(-1f);
            translate(camera.position);
            camera.position.multiply(-1f);
            rotateYaw(camera.rotation.x, true, null);
            rotatePitch(camera.rotation.y, true, null);
        }
        for (int i = 0; i < nVerticies; i++) {
            avgDistance += verticies[i].z;
            float scalingFactor = (float) 1 / verticies[i].z;
            if (!renderer.perspective)
                scalingFactor = 1;
            xVerticies[i] = (int) (renderer.dimensions.x / 2 + (verticies[i].x * scalingFactor * renderer.dimensions.x) / 2);
            yVerticies[i] = (int) (renderer.dimensions.y / 2 + (verticies[i].y * scalingFactor * renderer.dimensions.y) / 2);
        }
        if (renderer.perspective) {
            rotatePitch(-camera.rotation.y, true, null);
            rotateYaw(-camera.rotation.x, true, null);
            translate(camera.position);
        }
        avgDistance /= nVerticies;
    }

    /**
     * Renderuje ten trójkąt
     *
     * @param graphics obiekt Graphics2D
     * @author Bartosz Węgrzyn
     */
    public void render(Graphics2D graphics) {
        updateVerticies();
        if (renderer.perspective) {
            if (avgDistance > camera.near &&
                    avgDistance < camera.far) {
                graphics.setColor(color);
                graphics.drawPolygon(xVerticies, yVerticies, nVerticies);
            }
        } else {
            graphics.setColor(color);
            graphics.drawPolygon(xVerticies, yVerticies, nVerticies);
        }
    }

    /**
     * Przesuwa każdy wierzchołek tego trójkąta o podany wektor
     *
     * @param translationVector wektor przesunięcia
     * @author Bartosz Węgrzyn
     */
    public void translate(Vector3 translationVector) {
        for (int i = 0; i < nVerticies; i++) {
            verticies[i].add(translationVector);
        }
    }

    /**
     * Obraca trójkąt wokół osi x
     *
     * @param pitchAngle   kąt obrotu
     * @param axis         wokół własnej osi x - false
     * @param rotationAxis axis = true, to można wstawić tu null
     * @author Bartosz Węgrzyn
     */
    public void rotatePitch(float pitchAngle, boolean axis, Vector3 rotationAxis) {
        Vector3 translationVector = rotationAxis;
        if (!axis) {
            translationVector.multiply(-1);
            translate(translationVector);
        }
        float[][] pitchRotation = new float[][]{
                {1, 0, 0},
                {0, (float) Math.cos(pitchAngle), (float) -Math.sin(pitchAngle)},
                {0, (float) Math.sin(pitchAngle), (float) Math.cos(pitchAngle)}
        };
        Matrix3x3 pitchRotationMatrix = new Matrix3x3(pitchRotation);
        for (int i = 0; i < nVerticies; i++) {
            verticies[i] = verticies[i].multiply(pitchRotationMatrix);
        }
        if (!axis) {
            translationVector.multiply(-1);
            translate(translationVector); // ale ja jestem mądry
        }
    }

    /**
     * Obraca trójkąt wokół osi y
     *
     * @param yawAngle     kąt obrotu
     * @param axis         wokół własnej osi y - false
     * @param rotationAxis axis = true, to można wstawić tu null
     * @author Bartosz Węgrzyn
     */
    public void rotateYaw(float yawAngle, boolean axis, Vector3 rotationAxis) {
        Vector3 translationVector = rotationAxis;
        if (!axis) {
            translationVector.multiply(-1);
            translate(translationVector);
        }
        float[][] yawRotation = new float[][]{
                {(float) Math.cos(yawAngle), 0, (float) Math.sin(yawAngle)},
                {0, 1, 0},
                {(float) -Math.sin(yawAngle), 0, (float) Math.cos(yawAngle)}
        };
        Matrix3x3 yawRotationMatrix = new Matrix3x3(yawRotation);
        for (int i = 0; i < nVerticies; i++) {
            verticies[i] = verticies[i].multiply(yawRotationMatrix);
        }
        if (!axis) {
            translationVector.multiply(-1);
            translate(translationVector);
        }
    }

    /**
     * Obraca trójkąt wokół osi z
     *
     * @param rollAngle    kąt obrotu
     * @param axis         wokół własnej osi z - false
     * @param rotationAxis axis = true, to można wstawić tu null
     * @author Bartosz Węgrzyn
     */
    public void rotateRoll(float rollAngle, boolean axis, Vector3 rotationAxis) {
        Vector3 translationVector = rotationAxis;
        if (!axis) {
            translationVector.multiply(-1);
            translate(translationVector);
        }
        float[][] rollRotation = new float[][]{
                {(float) Math.cos(rollAngle), (float) -Math.sin(rollAngle), 0},
                {(float) Math.sin(rollAngle), (float) Math.cos(rollAngle), 0},
                {0, 0, 1}
        };
        Matrix3x3 rollRotationMatrix = new Matrix3x3(rollRotation);
        for (int i = 0; i < nVerticies; i++) {
            verticies[i] = verticies[i].multiply(rollRotationMatrix);
        }
        if (!axis) {
            translationVector.multiply(-1);
            translate(translationVector);
        }
    }
}

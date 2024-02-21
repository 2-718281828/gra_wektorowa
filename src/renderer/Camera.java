package renderer;

import maths.Matrix3x3;
import maths.Vector2;
import maths.Vector3;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Klasa obsługująca kamerę.<br>
 * Poruszanie się: W, A, S, D, Spacja - góra, Ctrl - dół <br>
 * Obracanie: myszką
 * 
 * @author Bartosz Węgrzyn
 */
public class Camera implements KeyListener, MouseMotionListener {
  public Vector3 position, velocity;
  /**
   * Oba kąty rotacji są w radianach, pierwszy to rotacja X, drugi - Y
   *
   * @author Bartosz Węgrzyn
   */
  public Vector2 rotation;
  private Robot robot;
  private boolean[] keysPressed = new boolean[6];
  /**
   * Domyślnie 0.1
   *
   * @author Bartosz Węgrzyn
   */
  public double speed = 0.1f;
  /**
   * Ustala, jak blisko, lub daleko może być trójkąt, aby został wyrenderowany
   * <br>
   * Domyślnie 1 i 100
   *
   * @author Bartosz Węgrzyn
   */
  public double near = 1f, far = 100f;
  private Dimension screenSize;
  private Matrix3x3 rotationMatrix;
  public Renderer renderer;
  /**
   * enableRotationPitch - domyślnie true
   * enableRotationYaw - domyślnie true
   * enableMovement - domyślnie true
   * enableUpDown - domyslnie true
   * 
   * @author Bartosz Węgrzyn
   */
  public boolean enableRotationPitch = true, enableRotationYaw = true, enableMovement = true, enableUpDown = true;

  public Camera() {
    position = new Vector3(0, 0, 0);
    rotation = new Vector2(0, 0);
    velocity = new Vector3(0, 0, 0);
    rotationMatrix = new Matrix3x3(new double[3][3]);
    try {
      robot = new Robot();
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }
    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  }

  /**
   * Aktualizuje położenie kamery.
   * Funkcja nie jest uruchamiana jeżeli perspective w rendererze jest ustawione
   * na false.
   *
   * @author Bartosz Węgrzyn
   */
  public void update() {
    if (!renderer.perspective)
      return;
    robot.mouseMove(screenSize.width / 2, screenSize.height / 2);
    if (rotation.y >= Math.PI / 2) {
      rotation.y = (double) (Math.PI / 2);
    }
    if (rotation.y <= -Math.PI / 2) {
      rotation.y = (double) -(Math.PI / 2);
    }
    if (keysPressed[0]) {
      velocity.z = speed;
    } else if (keysPressed[1]) {
      velocity.z = -speed;
    } else
      velocity.z = 0;
    if (keysPressed[2]) {
      velocity.x = -speed;
    } else if (keysPressed[3]) {
      velocity.x = speed;
    } else
      velocity.x = 0;
    if (enableUpDown) {
    if (keysPressed[4]) {
      velocity.y = -speed;
    } else if (keysPressed[5]) {
      velocity.y = speed;
    } else
      velocity.y = 0;
    } else 
	    velocity.y = 0;
    rotationMatrix.data = new double[][] {
        { (double) Math.cos(-rotation.x), 0, (float) Math.sin(-rotation.x) },
        { 0, 1, 0 },
        { (double) -Math.sin(-rotation.x), 0, (float) Math.cos(-rotation.x) }
    };
    if (enableMovement)
      position.add(velocity.multiply(rotationMatrix));
  }

  public void keyTyped(KeyEvent e) {

  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) {
      keysPressed[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
      keysPressed[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_A) {
      keysPressed[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
      keysPressed[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      keysPressed[5] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
      keysPressed[4] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }
  }

  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) {
      keysPressed[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
      keysPressed[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_A) {
      keysPressed[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
      keysPressed[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      keysPressed[5] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
      keysPressed[4] = false;
    }
  }

  public void mouseDragged(MouseEvent e) {

  }

  public void mouseMoved(MouseEvent e) {
    if (!renderer.perspective)
      return;
    if (enableRotationYaw)
      rotation.x -= (double) (e.getXOnScreen() - screenSize.width / 2) / 1250;
    if (enableRotationPitch)
      rotation.y -= (double) (e.getYOnScreen() - screenSize.height / 2) / 1250;
  }
}

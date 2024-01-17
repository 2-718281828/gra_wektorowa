package renderer;

import maths.Vector3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import util.Console;

/**
 * Ładuje model 3D z plików .model
 * @author Bartosz Węgrzyn
 */
public class LoadModel {
    /**
     * Ta funkcja ładuje model z pliku .model do obiektu Model
     * @param file plik .model
     * @return Model
     * @author Bartosz Węgrzyn
     */
    public static Model loadModel(File file, Color color, Renderer renderer, Camera camera){
        ArrayList<Triangle> triangles = new ArrayList<>();
        ArrayList<Vector3> verticies = new ArrayList<>();
        try {
            Scanner lineCounter = new Scanner(file);
            int nlines = 0;
            while (lineCounter.hasNextLine()) {
                nlines++;
                lineCounter.nextLine();
            }
            lineCounter.close();
            Scanner fetchData = new Scanner(file);
            String[] data = new String[nlines];
            for (int i = 0; i < nlines; i++) {
                data[i] = fetchData.nextLine();
            }
            fetchData.close();

            for (int j = 0; j < nlines; j++) {
                    Scanner fetchVertexData = new Scanner(data[j]);
                    if (fetchVertexData.next().equals("v")) {
                        float x = fetchVertexData.nextFloat();
                        float y = fetchVertexData.nextFloat();
                        float z = fetchVertexData.nextFloat();
                        verticies.add(new Vector3(x, y, z));
                    } else continue;
                    fetchVertexData.close();

            }
            for (int j = 0; j < nlines; j++) {
                    Scanner fetchTriangleData = new Scanner(data[j]);
                    if (fetchTriangleData.next().equals("t")) {
                        int a = fetchTriangleData.nextInt();
                        int b = fetchTriangleData.nextInt();
                        int c = fetchTriangleData.nextInt();
                        Vector3[] vx = new Vector3[3];
                        Console.log(c);
                        Console.log(b);
                        vx[0] = new Vector3(verticies.get(a));
                        vx[1] = new Vector3(verticies.get(b));
                        vx[2] = new Vector3(verticies.get(c));
                        triangles.add(new Triangle(vx, renderer, camera));
                    } else continue;
                    fetchTriangleData.close();
            }
            return new Model(triangles, color);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

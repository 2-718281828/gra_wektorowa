package entity;

import java.util.ArrayList;

public class EntityHandler {

  public ArrayList<Entity> entities = new ArrayList<>();

  public void logic() {
    for (int i = 0; i < entities.size(); i++) {
      entities.get(i).logic();
    }
  }

}

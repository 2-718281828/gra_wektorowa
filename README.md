Silnik do gier wektorowych na MSC
----------------------------------
Wymagania
----------------------
- Java 20

Jak zainstalować?
---------------------
Pobieramy plik .jar i dodajemy go do bilbiotek projektu (to będziemy robić) https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
LUB
Pobieramy całe repo i programujemy w nim (możliwość edycji kodu)

Jak używać?
----------------
**1) Wyświetlanie okna**

**Uwaga: zawsze sprawdźcie czy zaimportowaliście dobre klasy (np util.Console, a nie java.io.Console)**

Tworzymy 3 pliki (klasy): Main.java MainRenderer.java MainLogic.java

Klasa MainRenderer ma rozszerzać (extends) klasę renderer.Renderer. Tworzymy konstruktor.

Klasa MainLogic ma implementować (implements) interfejs engine.Logic. Tworzymy konstruktor i funkcję public void update();

Teraz w klasie Main tworzmy fukcję public static void main(String[] args)
```java
public class Main {
   public static void main(String[] args) {
   
   }
}
```
Stwórzmy zmienne z wymiarami i tytułem okna:
```java
public static int WIDTH = 1280, HEIGHT = 720;
public static String TITLE = "Gra wektorowa";
```
Inicjalizujemy teraz klasy Camera i Renderer (UWAGA! Klasa Renderer jest abstrakcyjna (abstract) i nie można jej normalnie zinicjalizować! Musimy zinicjalizować ją jako MainRenderer)
```java
public static void main(String[] args) {
   Camera camera = new Camera();
   Renderer renderer = new MainRenderer(new Vector2(WIDTH, HEIGHT), camera);
}
```
Inicjalizujemy teraz klasę Window, która wyświetli nasze okno.
```java
public static void main(String[] args) {
   Locale.setDefault(new Locale("en", "US")); // ustawiamy lokalizację na US, żeby si się floaty ładowały
   Camera camera = new Camera();
   Renderer renderer = new MainRenderer(new Vector2(WIDTH, HEIGHT), camera);
   Window window = new Window(new Vector2(WIDTH, HEIGHT), TITLE, renderer);
}
```
Dodajemy linijki (ważne):
```java
renderer.addKeyListener(camera); // poruszanie się klawiaturą
renderer.addMouseMotionListener(camera); // obracanie się myszką
renderer.requestFocus(); // okno jest przenoszone w systemie na pierwsze tło (ważne)
```
Jeśli nie chcemy poruszania się kamerą:
```java
camera.enableRotationPitch = false; // obracanie się wokół osi x (góra - dół)
camera.enableRotationYaw = false; // obracanie się wokół osi y (prawo - lewo)
camera.enableMovement = false; // poruszanie się kamerą
```
Te wszystkie zmienne są domyślie ustawione jako true.

Następnie inicjalizujemy naszą klasę MainLogic oraz Engine:
```java
MainLogic mainLogic = new MainLogic(); // tutaj 60 razy na sekundę jest wykonywana logika
Engine engine = new Engine(renderer, mainLogic); // tutaj jest pętla gry
engine.start(); // uruchamiamy silnik
```
**2) Klasa MainRenderer**

W pierwszej kolejności tworzymy obiekt Triangles, który będzie obsługiwał renderowanie wszystkich trójkątów:
```java
public class MainRenderer extends Renderer {

   public Triangles triangles;

   public MainRenderer(Vector2 dimensions, Camera camera) {
      super(dimensions, camera);
      triangles = new Triangles(); // inicjalizujemy obiekt Triangles
   }
   
   public void render(Graphics2D graphics) {
      triangles.render(graphics); // renderowanie trójkątów
   }
}
```

Dodajmy teraz model. Niech plik .model znajduje się w tym samym folderze co plik .java. Wtedy jego lokalizaja to `getClass().getResource("").getPath() + "/model.model"`.
Weźmy model torusa torus.model:

```java
public class MainRenderer extends Renderer {

   public Triangles triangles;
   public Model torus;
   String classPath = getClass().getResource("").getPath(); // żebyśmy nie musieli tego pisać za każdym razem

   public MainRenderer(Vector2 dimensions, Camera camera) {
      super(dimensions, camera);
      triangles = new Triangles();
      torus = LoadModel.loadModel(new File(classPath + "/torus.model"), Color.green, camera.renderer, camera); // ładujemy model z pliku
      torus.init(); // inicjalizujemy model (wymagane)
   }
   
   public void render(Graphics2D graphics) {
      triangles.render(graphics); 
   }
}
```

**3) Klasa MainLogic**

   W klasie MainLogic musimy stworzyć konstruktor i funkcję update (dzieciczy to od interfejsu Logic). Chcemy mieć możliwość aktualizacji kamery, więc w konstruktorze jako argument dodajemy Camera:
```java
public class MainLogic implements Logic {

   public Camera camera; // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy

   public MainLogic(Camera camera) {
      this.camera = camera; // this.camera odnosi się do kamery publicznej dla całej klasy, a camera jest dostępna tylko dla tego konstruktora, dlatego chcemy "upublicznić" kamerę, żeby móc z niej korzystać w innych funkcjach
   }

   public void update() {
      camera.update(); // aktualizacja kamery
   }

}
```

Teraz w MainRenderer, do inicjalizacji MainLogic musimy jako argument dać kamerę:
```java
MainLogic mainLogic = new MainLogic(camera);
```

Ostatecznie skopiujmy plik torus.model z tego repo do folderu z plikiem MainRenderer.java.

Uruchamiając teraz program powinniśmy dostać model torusa, wokół którego możemy się poruszać.

**4) Dodawanie obiektów**

Chcąc stworzyć różne obiekty, np. przeciwników musimy stworzyć nową klasę dziedziczącą klasę Entity.
Stwórzmy obiekty Monkey i Torus.
```java
public class Monkey extends Entity {

   public Monkey(Model model, Vector3 position, EntityHandler entityHandler) {
      super(model, position, entityHandler);
   }

   public void logic() {
      // tutaj jest logika obiektu
   }
}
```
```java
public class Torus extends Entity {

   public Torus(Model model, Vector3 position, EntityHandler entityHandler) {
      super(model, position, entityHandler);
   }

   public void logic() {
      // tutaj jest logika obiektu
   }
}
```

Aby rozróżniać między obiektami stwórzmy enum o nazwie ID:
```java
public enum ID {
   Monkey, Torus
}
```

Teraz nadajmy naszym obiektom ID:
```java
public class Monkey extends Entity {

   public ID id = ID.Monkey;

   public Monkey(Model model, Vector3 position, EntityHandler entityHandler) {
      super(model, position, entityHandler);
   }

   public void logic() {
      // tutaj jest logika obiektu
   }
}
```
```java
public class Torus extends Entity {

   public ID id = ID.Torus;

   public Torus(Model model, Vector3 position, EntityHandler entityHandler) {
      super(model, position, entityHandler);
   }

   public void logic() {
      // tutaj jest logika obiektu
   }
}
```

W MainLogic stwórzmy obiekt typu EntityHandler oraz obiekty Torus i Monkey, które dodajemy do listy obiektów w entityHandler:
```java
public class MainLogic implements Logic {

   public Camera camera;
   public EntityHanlder entityHandler;
   String classPath = getClass().getResource("").getPath(); // ścieżka do modelów

   public MainLogic(Camera camera) {
      this.camera = camera;
      entityHandler = new EntityHandler(); // ten obiekt zarządza wszystkimi obiektami w grze
      entityHandler.entities.add(new Torus(LoadModel.loadModel(new File(classPath + "/torus.model"), Color.green, camera.renderer, camera), new Vector3(0, 0, 0), entityHandler);
      // pierwszy argument to nowy model, który ładujemy, drugi to położenie początkowe obiektu, a trzeci to entityHandler
      entityHandler.entities.add(new Monkey(LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.green, camera.renderer, camera), new Vector3(3, -3, 1), entityHandler);
   }

   public void update() {
      camera.update();
      entityHandler.update();
   }

}
```
Aby wyrenderować modele, zainicjalizujmy je do listy triangles z MainRenderer (to trzeba robić za każdym razem, gdy obiekt jest tworzony):
```java
public class MainLogic implements Logic {

   public Camera camera;
   public EntityHanlder entityHandler;
   String classPath = getClass().getResource("").getPath(); // ścieżka do modelów

   public MainLogic(Camera camera) {
      this.camera = camera;
      entityHandler = new EntityHandler(); // ten obiekt zarządza wszystkimi obiektami w grze
      entityHandler.entities.add(new Torus(LoadModel.loadModel(new File(classPath + "/torus.model"), Color.green, camera.renderer, camera), new Vector3(0, 0, 0), entityHandler);
      // pierwszy argument to nowy model, który ładujemy, drugi to położenie początkowe obiektu, a trzeci to entityHandler
      entityHandler.entities.add(new Monkey(LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.green, camera.renderer, camera), new Vector3(3, -3, 1), entityHandler);
      for (int i = 0; i < entityHandler.entities.size(); i++) {
         entityHandler.entities.get(i).model.init(camera.renderer.triangles); // inicjalizujemy model każdego z obiektów
      }
   }

   public void update() {
      camera.update();
      entityHandler.update();
   }

}
```
Program powinien pokazać model torusa i małpy.

**5) Kolizje**

Każdy obiekt dziedziczący Entity ma hitbox w postaci najmniejszego sześcianu opisanego na nim. Aby sprawdzić kolizje:
```java
public class Torus extends Entity {

   public ID id = ID.Torus;

   public Torus(Model model, Vector3 position, EntityHandler entityHandler) {
      super(model, position, entityHandler);
   }

   public void logic() {
      // iterujemy po wszystkich obiektach w liście entity w entityHanlderze, sprawdzamy czy nie są tym obiektem (wtedy zawsze by było true), sprawdzamy ich id
      for (int i = 0; i < entityHandler.entities.size(); i++) {
         if (entityHandler.entities.get(i) != this) {
           if (collision(entityHandler.entities.get(i).hitbox))
            if(entityHandler.entities.get(i).id==ID.Torus) {
               Console.log("Kolizja z torusem!);
            ]
            if(entityHandler.entities.get(i).id==ID.Torus) {
               Console.log("Kolizja z małpą!);
            ]
         }
       }
   }
}
```

Aby sprawdzić działanie kodu możemy utworzyć kilka obiektów i dodać poruszanie się ich (np. w kółko, tak, żeby się co pewien czas zderzały). Aby dodać poruszanie w logic należy zmienić wartość wektora velocity np.
```java
velocity.x = 5; (obiekt będzie przemieszczał się z prędkością 5 px/tick)
```
A następnie dodać go do położenia
```java
position.add(velocity);
```
Polecam pobawić się tym kodem żeby załapać jak działa.


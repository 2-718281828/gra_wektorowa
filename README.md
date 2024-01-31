Silnik do gier wektorowych na MSC
----------------------------------
Wymagania
----------------------
- Java 20

Jak zainstalować?
---------------------
Pobieramy plik .jar i dodajemy go do bilbiotek projektu (to będziemy robić)
LUB
Pobieramy całe repo i programujemy w nim (możliwość edycji kodu)

Jak używać?
----------------
1) Wyświetlanie okna

Tworzymy 3 pliki (klasy): Main.java MainRenderer.java MainLogic.java

Klasa MainRenderer ma rozszerzać (extends) klasę renderer.Renderer. Tworzymy konstruktor.

Klasa MainLogic ma implementować (implements) interfejs engine.Logic. Tworzymy konstruktor i funkcję public void update();

Teraz w klasie Main tworzmy fukcję public static void main(String[] args)
'''
public class Main {
   public static void main(String[] args) {
   
   }
}
'''

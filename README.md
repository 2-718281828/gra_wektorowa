# Gra wektorowa na MSC
----------
Gra wektorowa na Motorola Science Cup.

Programujemy w języku Java:
1. Zainstalować JDK 20
2. Zainstalować Intellij Idea Community Edition 
(no chyba że checie inne ale ja takie polecam)
3. Zalogować się w Intellij do github i się podłączyć
do repo (następny tutorial)

Github + Intellij:
1. Zainstalować na komputerze git, zrobić setup
   (https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup)
2. Zalogować się w Intellij do githuba, podczas autoryzacji
dostępu dla Intellij ZAZNACZYĆ DOSTĘP DLA NASZEJ ORGANIZACJI
3. Do jakiegoś folderu (najlepiej nazwanego gra_wektorowa)
sklonować repo: git clone https://github.com/2-718281828/gra_wektorowa
4. Wejść w Intellij i open project i ten folder
będzie się pokazywać z takim kwadracikiem to w to kliknąć
5. Gotowe. Commit robimy regularnie, jak chcemy przekazać
zmainy na serwer to wtedy push, a pull request jak chcemy nasz branch
połączyć z mainem i wtedy ktoś zaakceptuje to. Polecam ogarnąć
jakiś tutorial do gita.

Do nauki polecam Kanał o Wszystkim i RealTutsGML

Komentarze i docs po polsku (podpisujemy się w docs
@author i imię i nazwisko), 
jak będą pytania to pisać.

---------------------

PLIKI .model

Plik .model zawiera dane z modelem 3D. Ma on postać następującą (model sześcianu):
```dtd
v 1.000000 -1.000000 -1.000000
v 1.000000 -1.000000 1.000000
v -1.000000 -1.000000 1.000000
v -1.000000 -1.000000 -1.000000
v 1.000000 1.000000 -1.000000
v 1.000000 1.000000 1.000000
v -1.000000 1.000000 1.000000
v -1.000000 1.000000 -1.000000
t 0 1 2
t 0 2 3
t 4 5 6
t 4 6 7
t 0 7 4
t 1 5 6
t 1 6 2
t 0 4 5
t 0 5 1
t 3 2 6
t 3 6 7
```

Każdą linijkę rozpoczynamy literą. v oznacza punkt (vertex), t oznacza trójkąt (triangle).
Po literze mamy 3 cyfry. Dla v mamy współżędne x, y, z punktu, dla t mamy numery punktów (taka jaka jest ich kolejność w pliku), z których powstanie trójkąt (kolejność ma znaczenie).
Jakikolwiek tekst w pliku spowoduje błąd programu (nie obsłguje komentarzy). Kolor określa się w programie i modele całe mają jeden kolor.

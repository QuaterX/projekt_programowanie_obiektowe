⚔️ Turn-Based Console RPG

Interaktywna, tekstowa gra fabularna (RPG) z turowym systemem walki, napisana w czystej Javie. Projekt realizuje zaawansowane mechaniki obiektowe, takie jak dynamiczne tworzenie przedmiotów przez fabrykę statyczną, grafowe łączenie lokacji wczytywanych z plików zewnętrznych oraz polimorficzną strukturę postaci, akcji bojowych i interakcji.

Projekt powstał jako praca zaliczeniowa z przedmiotu Programowanie Obiektowe.

🎮 O Projekcie & Mechanika Rozgrywki

Gra przenosi gracza do tekstowego świata fantasy, w którym eksploruje on połączone ze sobą lokacje, rozmawia z handlarzami oraz toczy turowe pojedynki z przeciwnikami.

Główne elementy rozgrywki:

Eksploracja świata: Przemieszczanie się pomiędzy połączonymi lokacjami (np. Town, Forest, Inn), których siatka połączeń (graf) jest dynamicznie budowana na podstawie pliku konfiguracyjnego JSON.

Dynamiczne zaludnienie lokacji: Lokacje mogą opcjonalnie posiadać przypisane postacie (np. kupców lub przeciwników) wczytywane podczas inicjalizacji gry.

Turowy system walki: Rywalizacja z przeciwnikami oparta na statystykach, akcjach bojowych (CombatActions) oraz efektach czasowych (Effect).

System ekwipunku i przedmiotów: Możliwość zbierania, kupowania oraz używania broni (Weapon), pancerzy (Armor) oraz przedmiotów jednorazowych (Consumable). Wszystkie przedmioty posiadają swoją nazwę oraz wartość rynkową (cena).

Interakcje handlowe: Interakcja z postaciami niezależnymi, takimi jak kupcy (Vendor), pozwalająca na handel przedmiotami z inwentarza.

🧠 Architektura Obiektowa (OOP) w Projekcie

Projekt został zaprojektowany z rygorystycznym poszanowaniem paradygmatów programowania obiektowego oraz dobrych praktyk inżynierii oprogramowania.

1. Abstrakcja (Abstraction)

W projekcie zastosowano klasy abstrakcyjne i interfejsy do zdefiniowania ogólnych kontraktów zachowań, co izoluje logikę biznesową od szczegółów implementacyjnych:

Interactable.java: Interfejs definiujący kontrakt dla interakcji w świecie gry. Wymusza implementację metody interact(Character character), dzięki czemu pętla gry może w jednolity sposób obsługiwać interakcję z dowolnym elementem mapy (np. kupcem Vendor):

public interface Interactable {
void interact(Character character);
}


CombatActions.java: Interfejs reprezentujący zestaw podstawowych operacji dostępnych dla postaci podczas tury walki. Każda postać uczestnicząca w pojedynku musi implementować te zachowania:

public interface CombatActions {
void defend();
void attack();
void flee();
void useItem();
}


Item.java: Klasa abstrakcyjna stanowiąca fundament dla wszystkich obiektów fizycznych w grze. Definiuje wspólne pola name i cena, udostępniając metodę getName(), ale sama nie może być bezpośrednio instancjonowana.

Equipment.java: Klasa abstrakcyjna rozszerzająca Item. Reprezentuje przedmioty, które postać może założyć (np. broń lub pancerz). Wprowadza wspólne dla całego ekwipunku pole bonusStats (klasy Stats) oraz metodę dostępowa getBonusStats().

2. Hermetyzacja i Niezmienność (Encapsulation & Immutability)

Hermetyzacja w Character.java: Pola stanu postaci (np. currentHp, currentLocation) oraz wyposażenia są chronione przy użyciu modyfikatorów protected (w celu ułatwienia dziedziczenia dla klas pochodnych) oraz private. Modyfikacja punktów życia realizowana jest bezpiecznie poprzez metodę dedykowaną subtractHp(int).

Niezmienność (Value Object Pattern) w Stats.java: Klasa Stats reprezentuje niezmienne statystyki postaci. Wszystkie pola klasy (level, strength, dexterity, intelligence, vitality) zostały zadeklarowane jako private final. Klasa nie posiada setterów, co zapobiega niepożądanym efektom ubocznym w pamięci aplikacji.

Operacje matematyczne na statystykach (np. obliczanie modyfikatorów z założonego ekwipunku) realizowane są poprzez metody add(Stats other) oraz subtract(Stats other), które zwracają całkowicie nową instancję klasy Stats.

Punkty zdrowia ($HP$) postaci są wyliczane dynamicznie na podstawie poziomu oraz witalności przy użyciu wzoru:


$$HP = 20 + (level - 1) \cdot 2 + (vitality - 1) \cdot 4$$

3. Kompozycja (Composition)

Klasa Character szeroko wykorzystuje kompozycję do budowania złożonych struktur z mniejszych, niezależnych modułów:

Zawiera obiekt klasy Stats reprezentujący statystyki bazowe (baseStats).

Posiada dwa sloty typu Equipment (slot1, slot2) na założone przedmioty (np. broń i tarczę).

Agreguje dynamiczną listę przedmiotów w postaci ekwipunku (ArrayList<Item> inventory).

Przechowuje referencję do swojej bieżącej lokacji (Location currentLocation).

4. Dziedziczenie i Łańcuchowanie Konstruktorów (Inheritance)

W projekcie zastosowano dwie wyraźne i logiczne hierarchie dziedziczenia:

Hierarchia Postaci: Klasa bazowa Character definiuje wspólny szkielet dla postaci w grze. Dziedziczą po niej klasy Player, Enemy oraz Vendor.

Wszystkie podklasy wykorzystują mechanizm łańcuchowania konstruktorów (Constructor Chaining), delegując inicjalizację pól do klasy nadrzędnej przy użyciu słowa kluczowego super(...):

public class Player extends Character {
public Player(String name) {
super(name); // Wywołanie konstruktora klasy bazowej Character
}
// ...
}


Wielopoziomowa Hierarchia Przedmiotów: Cała struktura przedmiotów opiera się na czystym dziedziczeniu wielopoziomowym:

[Item] (Abstrakcyjna)
├── [Consumable] (Mikstury użytkowe - posiada pole 'Effect' oraz 'potency')
└── [Equipment] (Abstrakcyjna - posiada pole 'Stats bonusStats')
├── [Weapon] (Broń - posiada dodatkowo pole 'damageMultiplier')
└── [Armor] (Pancerz)


5. Polimorfizm i Wielokrotne Dziedziczenie Typów (Polymorphism)

Implementacja Interfejsów i Klasy Bazowej: Klasa Vendor dziedziczy stan i zachowanie po klasie Character oraz jednocześnie implementuje interfejs Interactable:

public class Vendor extends Character implements Interactable { ... }


Polimorficzne wywołanie interakcji: Metoda interact(Character character) w klasie Vendor przyjmuje jako parametr ogólny typ Character. Pozwala to kupcowi na interakcję z dowolną postacią (najczęściej z obiektem klasy Player), dając mu dynamiczny dostęp do metod sprawdzających ekwipunek (inventory) czy modyfikujących stan gracza podczas handlu.

Dynamiczne tworzenie postaci w lokacjach: Podczas parsowania pliku JSON, obiekty z listy characterList są dynamicznie mapowane na konkretne podklasy. Jeśli pole type wynosi "vendor", tworzona jest instancja klasy Vendor, a jeśli "enemy" – klasa Enemy.

6. Mechanizm Efektów Czasowych (Effect & Type)

Klasa Effect odpowiada za nakładanie czasowych modyfikatorów na postaci w grze (np. trucizny, leczenia czy wzmocnienia siły).

Wykorzystuje wewnętrzny typ wyliczeniowy Effect.Type do kategoryzacji zachowań (HEAL, STRENGTH_BUFF, DEXTERITY_BUFF, INTELLIGENCE_BUFF, POISON, REGENERATION).

Posiada pole duration (czas trwania w turach) oraz metodę tick(), która zmniejsza czas trwania efektu o $1$ z każdą kolejną turą walki:

public void tick() {
duration--;
}


7. Wzorce Projektowe (Design Patterns)

Wzorzec Fabryki Statycznej (Static Factory Pattern) – ItemFactory.java:
Klasa ta służy jako centralny punkt generowania predefiniowanych przedmiotów w grze.

Posiada prywatny konstruktor (private ItemFactory() {}), co skutecznie blokuje możliwość tworzenia obiektów tej klasy (klasa narzędziowa/wytwórcza).

Metody wytwórcze zostały w pełni dostosowane do nowej specyfikacji klasy Consumable przyjmującej pole potency (określające moc działania przedmiotu):

public class ItemFactory {
private ItemFactory() {}

    public static Weapon rustySword() {
        return new Weapon("Rusty Sword", 2, new Stats(0, 1, 0, 0, 0), 5);
    }

    public static Consumable healthPotion() {
        return new Consumable(
            "Health Potion", 
            1, // potency (moc efektu)
            3, // cena
            new Effect(Effect.Type.HEAL, 0, 50)
        );
    }

    public static Consumable strengthPotion() {
        return new Consumable(
            "Strength Potion", 
            2, // potency (moc efektu)
            5, // cena
            new Effect(Effect.Type.STRENGTH_BUFF, 3, 5)
        );
    }
}


💾 System Wczytywania Świata, Postaci i GSON

Gra wykorzystuje plik src/Locations.json do deklaratywnego definiowania struktury świata oraz jego początkowego zaludnienia. Proces ten jest realizowany w klasie Main przy użyciu biblioteki Google GSON:

Odczyt surowego JSON-a: Klasa Main pobiera strukturę z pliku i deserializuje ją do obiektów pomocniczych transferu danych (LocationData[]).

Budowanie grafu lokacji: W klasie Location zdefiniowano konstruktory ułatwiające budowanie grafów (w tym z użyciem varargs Location... poi). Pętla w klasie Main łączy lokacje referencyjnie (tworząc dwukierunkowe krawędzie grafu przejść) na podstawie listy sąsiedztwa connectedLocations.

Inicjalizacja i zaludnienie postaci:

W zależności od wartości pola "type" wczytanego z modelu LocationData, mechanizm decyduje o powołaniu do życia odpowiedniej klasy potomnej (Vendor lub Enemy) i przypisaniu jej do konkretnej lokacji przy użyciu metody changeLocation(Location).

Przykładowa struktura pliku Locations.json:

[
{
"name": "Town",
"connectedLocations": [
"Inn",
"Forest"
]
},
{
"name": "Inn",
"connectedLocations": [
"Town"
],
"characterList": [
{
"type": "vendor",
"name": "Isaac"
}
]
},
{
"name": "Forest",
"connectedLocations": [
"Town"
],
"characterList": [
{
"type": "enemy",
"name": "Goblin"
}
]
}
]


📁 Struktura Plików w Projekcie

projekt_programowanie_obiektowe/
├── lib/                      # Katalog na zewnętrzne biblioteki (np. gson-2.10.1.jar)
├── src/                      # Pliki źródłowe aplikacji
│   ├── Armor.java        # Klasa reprezentująca pancerz (dziedziczy po Equipment)
│   ├── Character.java    # Klasa bazowa dla postaci (posiada m.in. statystyki, eq, inwentarz)
│   ├── CombatActions.java# Interfejs definiujący akcje podczas walki (defend, attack, flee, useItem)
│   ├── Consumable.java   # Przedmioty użytkowe (posiada pole effect i potency)
│   ├── Effect.java       # Efekty czasowe i statusy (enum Type, tick-based duration)
│   ├── Enemy.java        # Klasa przeciwnika (dziedziczy po Character)
│   ├── Equipment.java    # Klasa abstrakcyjna dla przedmiotów zakładanych (dziedziczy po Item)
│   ├── Interactable.java # Interfejs interakcji w lokacji z metodą interact(Character)
│   ├── Item.java         # Klasa abstrakcyjna - korzeń hierarchii przedmiotów (name, cena)
│   ├── ItemFactory.java  # Fabryka statyczna generująca predefiniowane bronie, zbroje i potiony (potency)
│   ├── Location.java     # Klasa lokacji, przechowująca połączone lokacje oraz listy obecnych postaci
│   ├── LocationData.java # Model pomocniczy GSON do wczytywania struktury lokacji i postaci
│   ├── Main.java         # Główna pętla gry, deserializacja GSON i powiązanie krawędzi grafu lokacji
│   ├── Menu.java         # Obsługa menu głównego (CLI), switch-case operacji oraz Text-Art powitalny
│   ├── Player.java       # Klasa reprezentująca gracza (dziedziczy po Character)
│   ├── Stats.java        # Klasa statystyk (Immutable Value Object z polami private final)
│   ├── Vendor.java       # Klasa handlarza (implementuje Interactable / dziedziczy po Character)
│   ├── Weapon.java       # Klasa broni (dziedziczy po Equipment, posiada damageMultiplier)
│   └── Locations.json    # Plik konfiguracyjny świata gry i postaci
└── README.md                 # Ta dokumentacja


🚀 Jak Skompilować i Uruchomić Projekt Lokalnie

Projekt nie korzysta z Maven/Gradle, co oznacza, że musisz ręcznie dołączyć bibliotekę GSON podczas kompilacji i uruchamiania.

Wymagania wstępne:

Pobierz plik jar biblioteki GSON: gson-2.10.1.jar.

Umieść pobrany plik .jar w katalogu lib swojego projektu.

Instrukcja kompilacji i uruchomienia (Terminal / Konsola):

Wejdź do głównego katalogu projektu:

cd projekt_programowanie_obiektowe


Systemy Linux / macOS:

# 1. Kompilacja wszystkich plików do folderu 'bin' z linkowaniem biblioteki GSON
mkdir -p bin
javac -cp "lib/gson-2.10.1.jar" -d bin src/*.java

# 2. Uruchomienie gry (dwukropek jako separator classpath)
java -cp "bin:lib/gson-2.10.1.jar" Main


System Windows (CMD / PowerShell):

:: 1. Kompilacja plików do folderu 'bin'
if not exist bin mkdir bin
javac -cp "lib/gson-2.10.1.jar" -d bin src/*.java

:: 2. Uruchomienie gry (średnik jako separator classpath)
java -cp "bin;lib/gson-2.10.1.jar" Main


👥 Autor

QuaterX - @QuaterX
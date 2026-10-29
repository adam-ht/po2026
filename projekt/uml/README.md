# Diagramy UML projektu

Tu trafiają diagramy projektowe jako pliki PlantUML (`.puml`) — tekstowo, bez eksportowania do PNG/SVG.

Zobacz sekcję **Projekt** w głównym [README](../../README.md) repozytorium — tam jest pełny opis konwencji, narzędzi i rekomendowanej kolejności diagramów.

Przykładowe nazewnictwo:

```
01-przypadki-uzycia.puml
02-sekwencja-<nazwa-przypadku-uzycia>.puml
03-diagram-klas.puml
04-diagram-obiektow.puml   (opcjonalnie)
```

## Spis diagramów (Symulator Śluzy Wodnej)

| Plik | Co pokazuje |
|---|---|
| `01-przypadki-uzycia.puml` | aktorzy (Operator, Kapitan statku, Zegar symulacji) i przypadki użycia |
| `02-sekwencja-przybycie-statku.puml` | zgłoszenie statku do kolejki (generator lub polecenie operatora) |
| `02-sekwencja-krok-symulacji.puml` | jeden takt w wątku symulacji: bramy, faza śluzy, reguły, migawka dla widoku |
| `02-sekwencja-przeplyniecie-statku.puml` | pełny cykl śluzy dla jednego kierunku (UP) |
| `02-sekwencja-awaryjne-zatrzymanie.puml` | zatrzymanie (operator / naruszenie reguły) i wznowienie |
| `02-sekwencja-zapis-i-odczyt-stanu.puml` | zapis i odczyt stanu przez `ObjectOutputStream` |
| `03-diagram-klas.puml` | klasy modelu (`model.ship`, `model.lock`, `model.sim`) |
| `03-diagram-klas-mvc.puml` | podział na `model`, `view`, `controller`, `storage`, `app` |
| `04-diagram-obiektow.puml` | migawka obiektów w pamięci w takcie 42 |
| `05-diagram-stanow-sluzy.puml` | fazy pracy śluzy (`LockPhase`) z historią po awarii |
| `06-diagram-stanow-bramy.puml` | stany bramy i reguły bezpieczeństwa R1–R4 |

## Zgodność z zasadami projektu

| Zasada z zajęć | Jak jest spełniona |
|---|---|
| MVC, wymienialny widok | `model` nie zna `view` ani `controller`; widok dostaje niezmienną `SimulationSnapshot` oraz zdarzenia przez interfejs `LockListener` |
| private + gettery | wszystkie atrybuty `private`, dostęp przez gettery |
| klient–dostawca, Factory | `ShipFactory` (konstruktory statków pakietowe), `CommandFactory`; reguły widzą śluzę tylko przez interfejs `LockState` |
| podział na pakiety | `model.ship`, `model.lock`, `model.sim`, `view`, `controller`, `storage`, `app` |
| nazwy | klasy UpperCamelCase; pakiety, zmienne i metody małymi literami (camelCase); nazwy znaczące |
| testy JUnit | do napisania dla klas modelu: `Gate`, `Chamber`, `AbstractShip` (priorytet ze starzeniem), `ShipQueue`, `ShipFactory`, polityki kierunku, reguły `SafetyRule`, `Lock` (cykl i HALTED), `Statistics`, `ArrivalGenerator` (stałe ziarno) |
| wzorce projektowe | State (`LockPhase`), Strategy (`DirectionPolicy`), Observer (`LockListener`), Factory (`ShipFactory`, `CommandFactory`), Template Method (`AbstractShip`), Command (`Command`), MVC |
| diagram klas i obiektów, min. 4 klasy | `03-diagram-klas.puml`, `03-diagram-klas-mvc.puml`, `04-diagram-obiektow.puml` |
| więcej interfejsów | `Ship`, `LockState`, `LockListener`, `DirectionPolicy`, `SafetyRule`, `SimulationView`, `Command` (oraz `Serializable`, `Runnable`) |
| GUI nieobowiązkowe | widok konsolowy (`ConsoleView`) i polecenia z linii komend |
| I/O | `SimulationStorage`: zapis i odczyt stanu przez `ObjectOutputStream` / `ObjectInputStream` |
| wątki i synchronizacja | wątek symulacji (`SimulationRunner`) i wątek konsoli; `synchronized` w `Simulation`, `volatile` w `SimulationRunner` |
| kolekcje | `List` (kolejki, komora), `Map` (kolejki w `Lock`, statystyki), `Set` (listenery) |
| terminy | deklaracja 15.12.2026, oddanie 27.01.2027 (wg README repozytorium) |

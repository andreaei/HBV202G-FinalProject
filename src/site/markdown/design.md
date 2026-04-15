# Design Documentation

## Overview
The project follows a separation between user interface and business logic.

- `LudoController` contain the user interface.
- `Ludo`, `Leikmadur`, `Reitur`, and `Teningur` contain the game logic.

## UML Class Diagram
![UML Class Diagram](../resources/UML_class_diagram.png)

## Design Pattern
The project uses the Observer pattern in the interaction between the UI and the game model.
Observable: business logic in Ludo
Observer: LudoController
Mechanism: JavaFX property listeners and binders observe changes in game and
update the user interface as information changes

### Roles
- **Subject / Observable:** `Ludo`
- **Observer:** `LudoController`

The controller reacts to changes in the game state and updates the user interface accordingly.

## Responsibilities
- `Ludo`: manages game state and rules
- `Leikmadur`: represents a player
- `Reitur`: represents a board square
- `Teningur`: handles dice rolling
- `LudoController`: connects the UI to the game logic

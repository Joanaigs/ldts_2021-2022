# ldts-project-assignment-g0902


# We present to you our version of Pac-Man!

<img src="resources/capa.png" width="200" height="200" />

## TABLE OF CONTENTS

- [Controls](#controls)
- [Implemented Features](#implemented-features) 
    - [Menu](#menu)
    - [Pac-Man Movement](#pac-man-movement)
    - [Game mode](#game-mode)
    - [Ghosts](#ghosts)
    - [Coins](#coins)
    - [Collisions](#collisions)
    - [Score](#score)
    - [End of Game](#end-of-game)
    - [Leaderboard](#leaderboard)
- [Architectural Pattern](#architectural-pattern)
- [Design Patterns](#design-patterns)
  - [Strategy Pattern](#strategy-pattern)
  - [Observer Pattern](#observer-pattern)
  - [States Pattern](#states-pattern)
  - [Planned Features](#planned-features)
  - [Known code smells and refactoring suggestions](#known-code-smells-and-refactoring-suggestions)
- [Tests](#tests)
  - [Coverage Report](#coverage-report)
- [Self-evaluation](#self-evaluation)


## CONTROLS

`^`: Moves Pac-Man up.

`v`: Moves Pac-Man down.

`>`: Moves Pac-Man to the right.

`<`: Moves Pac-Man to the left.

## IMPLEMENTED FEATURES


### Menu

When starting the program, appears an initial menu where the user can choose to start playing, read the instructions, access the leaderboard or exit the game. When the game ends, after the leaderboard page is shown, the player returns to the initial menu.
 - Start game;
 - Instructions - Shows the basic controls and the goal of the game;
 - Leaderboard - Shows previous and recent scores;
 - Exit game;

### Pac-Man Movement

Pac-Man moves using the arrow keys. If the player wants to keep moving in the same direction he will only need to press one time the arrow key in the desired direction.

However, if Pac-Man bumps into a wall he stops and waits for the next direction. So, whenever the player wishes Pac-Man to change direction he needs to press an arrow key.

Let’s imagine a scenario: the player pressed the right arrow key and Pac-Man is now moving to the right; if the player presses the up arrow key and Pac-Man has walls in the up direction, meaning he can’t move up, the moment Pac-Man is able to move upwards he moves without needing another input from the player. The function that handles this implementation is called **pacmanMoving** and it's a method from the class [GameModel](../src/main/java/g0902/model/GameModel.java).

The class that handles the input from the user and makes [Pacman](../src/main/java/g0902/model/MapElements/Pacman.java) move is [PacmanController](../src/main/java/g0902/control/PacmanController.java).

### Game mode

There are three different game modes. In order to understand them better let’s name them: we have the “**Chase**” mode, “**Scatter**” and the “**Frightened**” mode.

The main mode is “**Chase**”. This is when the ghosts are trying to capture Pac-Man. Then, in “**Scatter**” mode, the ghosts stop chasing Pac-Man and each will move to its respective corners. This mode only lasts for a few seconds then changes back to “**Chase**”. In this two modes each ghost has its own implementation. The last game mode is “**Frightened**” and it happens when Pac-Man eats a special coin. In this mode the ghosts move randomly so they aren’t trying to catch Pac-Man. Also, in this mode they are vulnerable because Pac-Man can eat them. When a ghost is eaten it returns to its original position on either chase or scatter mode.  

Classes: [ChaseMode](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode), [ScatterMode](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ScatterMode), [FrightenedMode](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/FrightenedMode).

### Ghosts

Ghost types - There are four types of ghosts: Blinky (the red one), Pinky (the pink one), Inky (the blue one) and Clyde (the orange one).

Classes: [Blinky](../src/main/java/g0902/model/MapElements/Ghosts/Types/Red.java), [Pinky](../src/main/java/g0902/model/MapElements/Ghosts/Types/Pink.java), [Inky](../src/main/java/g0902/model/MapElements/Ghosts/Types/Cyan.java), [Clyde](../src/main/java/g0902/model/MapElements/Ghosts/Types/Orange.java)

Each ghost has a different tactic to catch Pac-Man. These are applied when the game is in “**Chase**” mode ([Game mode](#game-mode)).

- **Blinky**: follows Pac-Man once located. 
  - Implemented in these classes: [TargetChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/TargetChaseStrategy.java), [AggressiveTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/AggressiveTargetStrategy.java)

- **Pinky**: tries to ambush Pac-Man by getting in front of him.
  - Implemented in these classes: [TargetChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/TargetChaseStrategy.java), [AmbushTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/AmbushTargetStrategy.java)

- **Inky**: tries to trick Pac-Man using both Pac-Man's position and direction as well as Blinky's (the red ghost) position in his calculation.
  - Implemented in these classes: [TargetChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/TargetChaseStrategy.java), [PatrolTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/PatrolTargetStrategy.java)

- **Clyde**: moves randomly and appears to stay away from Pac-Man.
  - Implemented in these classes: [RandomChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/RandomChaseStrategy.java)

When the game is in “**Scatter**” mode ([Game mode](#game-mode)) the following tactics apply:

- **Blinky**: moves to the top right corner.

- **Pinky**: moves to the top left corner.

- **Inky**: moves to the bottom right corner.

- **Clyde**: moves to the bottom left corner.    

### Coins

Coins have two different types: [Small Coin](../src/main/java/g0902/model/MapElements/Coins/SmallCoin.java) and [Power Coin](../src/main/java/g0902/model/MapElements/Coins/PowerCoin.java).

When Pac-Man eats either a **Small Coin** or a **Power Coin** his score increases. However, if he eats a **Power Coin**  that’s when **“Frightened”** mode is activated ([Game mode](#game-mode)).

The positions of the coins are read from the map text file and during the game no more coins appear. The player wins if Pac-Man eats all the coins.

### Collisions

There are implemented many types of collisions:
- Pac-Man and the walls, which prevents Pac-Man from moving through walls. 
- Pac-Man and Small coins, which increases Pac-Man's score.
- Pac-Man and Power coins, which increases Pac-Man's score and changes the Game Mode.
- Pac-Man and Ghosts, which leads to the end of the game.
- Ghosts and the walls, which prevents the ghosts from moving through walls.

The collision methods are implemented in the class [GameModel](../src/main/java/g0902/model/GameModel.java).

### Score
Pacman can gain points to increase his score in several ways:
- By eating a **small coin**, which adds **10** points to Pac-Man's score.
- By eating a **power coin**, which adds **200** points to Pac-Man's score.
- By eating **ghosts** when the Frightened Game Mode is activated. In each activation of this mode the first ghost eaten gives **200** points, the second **400** points, the third **600** points, and the fourth **800** points.

### End of Game
When Pac-Man eats all the coins without being caught by ghosts appears a message to the player saying "You win". When the player is eaten by a ghost the final message is "Game Over". The player is proceeded to the Leaderboard.
### Leaderboard

When the game ends either the player wins or loses, he asked for his name. Both the name and his score are saved to a file with previous rankings that's updated and reordered by score. 

Class: [RankingsMenuModel](../src/main/java/g0902/model/Menu/RankingsMenuModel.java).

## ARCHITECTURAL PATTERN

**Problem in context**

Without any structural pattern the Single Principle Responsibility could be broken, so we decided to implement the MVC pattern. With it, it's possible to separate the data, interface and control of the game to have more code reusability and to make the code more organized and easy to implement.

**Pattern**

This particular pattern is useful for games and web applications because it helps separate the input logic that is converted to commands for either the Model or View (handled by the Controller); the data, game logic and rules of the game (handled by the Model) and the user interface that outputs information (handled by the View).

**Implementation**

<img src="resources/MVC.png" width="500" height="300" />

**Consequences**

This architecture enables quick changes without having to rework much code in all layers of the application and helps to test components independently.

## DESIGN PATTERNS

### Strategy Pattern

**Problem in context**

In our code, Ghost's have three types of move behaviour. Scatter, Frightened and Chase. On chase mode there are two types of chasing. One that is random (ChaseRandom), and other that tries to reach a target (ChaseTarget). Furthermore, each ghost has a different way of defining a target. And this was where our problem relied on. We needed a pattern design that could allow us to make changes to those behaviours without affecting the parts that stays the same.

**Pattern**

Implementing the Strategy pattern means taking a big class that does something in many ways and separating the different algorithms into separate classes. So in our case, 
we decided to create two interfaces: [ChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/ChaseStrategy.java) and [TargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/TargetStrategy.java). ChaseStrategy has two implementations: [RandomChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/RandomChaseStrategy.java) and [TargetChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/TargetChaseStrategy.java). 
TargetChaseStrategy has a TargetStrategy that is either an [AmbushTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/AmbushTargetStrategy.java), or an [AggressiveTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/AggressiveTargetStrategy.java) or a [PatrolTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/PatrolTargetStrategy.java).

**Implementation**

<img src="resources/strategy_pattern1.png" width="550" height="300" />
<img src="resources/strategy_pattern2.png" width="550" height="300" />

**Interfaces**: [ChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/ChaseStrategy.java), [TargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/TargetStrategy.java).

**ChaseStrategy** - **Classes implementing**
  - [RandomChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/RandomChaseStrategy.java);
  - [TargetChaseStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/ChaseStrategys/TargetChaseStrategy.java);
      
**TargetStrategy** - **Classes implementing**
  - [AggressiveTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/AggressiveTargetStrategy.java);
  - [AmbushTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/AmbushTargetStrategy.java);
  - [PatrolTargetStrategy](../src/main/java/g0902/model/MapElements/Ghosts/MoveMode/ChaseMode/TargetStrategys/PatrolTargetStrategy.java);

**Consequences**

With the implementation of this pattern, it's easier to introduce new strategies without having to change the context, and the code stays more organized.

### Observer Pattern
**Problem in context**

When there are objects that are interested in the actions of another object it's not beneficial for those objects to be constantly checking whether something happened or not. Probably most of those check-ups would be pointless. In our project the problem was that certain classes needed to be notified when there was user input.

**Pattern**

The Observer pattern is useful when there are objects waiting to be notified when an event happens to the object they are observing, because when that happens they also need to be changed.
In our project, the Observer Pattern was implemented in the MenuController class and in the PacmanController class, since they both implement the subscriber interface Observer. Both classes are waiting to be notified when there's user input. When they are notified of input they act and make the application progress.
In this case the class ReadKeys is the publisher and the classes MenuController and PacmanController are the subscribers.

**Implementation**

<img src="resources/observer_pattern.png" width="1100" height="400" />

- Observer classes: [EndScreenController](../src/main/java/g0902/control/EndScreenControler.java), [PacmanController](../src/main/java/g0902/control/PacmanController.java), [InstructionMenuController](../src/main/java/g0902/control/InstructionMenuController.java), [RankingsMenuController](../src/main/java/g0902/control/RankingsMenuControler.java), [MenuController](../src/main/java/g0902/control/MenuController.java);
- Subject class: [ReadKeys](../src/main/java/g0902/control/ReadKeys.java). 

**Consequences**

When implementing this pattern it enables objects to establish relations between them at runtime and respects the Open/Closed Principle since it's easy to introduce new subscriber classes without having to change the publisher's code (class [ReadKeys](../src/main/java/g0902/control/ReadKeys.java)).

### States Pattern

**Problem in context**

In our project there were many states possible: the one related to the game ([GameState](../src/main/java/g0902/states/GameState.java)), to the leaderboard page ([RankingsMenuState](../src/main/java/g0902/states/RankingsMenuState.java)), to the instructions page ([InstructionMenuState](src/main/java/g0902/states/InstructionMenuState.java)), to the ending game screen ([EndScreenState](src/main/java/g0902/states/EndScreenState.java)) and to the main menu ([MainMenuState](src/main/java/g0902/states/MainMenuState.java)).
Without any design pattern properly defining them, the code was messy and there were bulky state machine conditionals. Because of this, we decided to implement the State Pattern.


**Pattern**

The State pattern allows an object to alter its behavior when its internal state changes. By extracting the code related to the specific state behavior into separate classes, the object is forced to assign the work to an instance of these classes instead of acting on its own.

**Implementation**

<img src="resources/states_pattern.png" width="700" height="300" />

- Abstract class: [State](../src/main/java/g0902/states/State.java);

- Classes that extend State: [EndScreenState](../src/main/java/g0902/states/EndScreenState.java), [GameState](../src/main/java/g0902/states/GameState.java), [InstructionMenuState](../src/main/java/g0902/states/InstructionMenuState.java), [MainMenuState](../src/main/java/g0902/states/MainMenuState.java), [RankingsMenuState](../src/main/java/g0902/states/RankingsMenuState.java).

**Consequences**

By implementing the State pattern, the bulky state machine conditionals are eliminated and the code becomes more organized because the code related to different behaviors is moved into separate classes (Single Responsibility Principle) and finally, when introducing new states there's no need to change existing states (Open/Closed Principle).

## Known code smells and refactoring suggestions

### Some things we would like to change in the future

- The game mode classes that were previously explained: [ChaseMode](../src/main/java/model/Elements/Pacman.java), [ScatterMode](../src/main/java/model/Elements/Pacman.java) and [FrightenedMode](../src/main/java/model/Elements/Pacman.java) extend the abstract class [MovingBehaviour](../src/main/java/model/Elements/Pacman.java) since they all share some functions and we think there could be a cleaner way to do it.

- We want to implement the game loop design pattern. 


## Planned Features

- **Pac-Man**: Implementing lives for Pac-Man. In the beginning of the game, Pac-Man will start with 3 lives. Each time Pac-Man is eaten by a ghost he loses one life and both Pac-Man and the ghosts return to their original positions. However, the amount of coins eaten and the coins left remain the same. The game ends only when Pac-Man loses his third life or when he eats all the coins in the map.

## Tests

### Coverage Report

<img src="resources/test_coverage.png" width="750" height="300" />

## Self-evaluation

    - Inês Cardoso - 33.33%
    - Joana Santos - 33.33%
    - Mariana Carvalho - 33.33%

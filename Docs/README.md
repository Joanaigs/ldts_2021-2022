# ldts-project-assignment-g0902


# We present to you our version of Pac-Man!

![Pac-Man Image](https://sm.ign.com/ign_br/screenshot/default/artboard-29_mu8f.png)

In this version you can find Pac-Man, which is the character the player plays, coins that have different properties and ghosts that haunt Pac-Man trying to catch him!

The game goal in our version is that Pac-Man eats all the coins without being caught by the different ghosts while the difficulty, in this case the velocity of the ghosts, increases.

**Good luck trying to escape the ghosts and collecting as many coins as you can!**

This project was developed by Inês Cardoso ([up202005435@fe.up.pt](mailto:up202005435@fe.up.pt)), Joana Santos ([up202006279@fe.up.pt](mailto:up202006279@fe.up.pt)) and Mariana Carvalho ([up202007620@fe.up.pt](mailto:up202007620@fe.up.pt)) for LDTS 2021/2022.

## TABLE OF CONTENTS

- [Controls](#controls)
- [Gameplay Demo](#gameplay-demo)
- [Class Diagram UML](#class-diagram-uml)
- [Implemented Features](#implemented-features)
  - [Pac-Man](#pac-man)
  - [Game mode](#game-mode)
  - [Ghosts](#ghosts)
  - [Coins](#coins)
- [Architectural Pattern](#architectural-pattern)
- [Design Patterns](#design-patterns)
  - [Factory Method](#factory-method)
  - [Strategy Pattern](#strategy-pattern)
  - [Observer Pattern](#observer-pattern)
  - [Game Loop Pattern](#game-loop-pattern)
  - [States Pattern](#states-pattern)
- [Tests](#tests)
  - [Coverage Report](#coverage-report)

## CONTROLS

`^`: Moves Pac-Man up.

`v`: Moves Pac-Man down.

`>`: Moves Pac-Man to the right.

`<`: Moves Pac-Man to the left.

## IMPLEMENTED FEATURES

### Pac-Man

Pac-Man moves using the arrow keys. If the player wants to keep moving in the same direction he will only need to press one time the arrow key in the desired direction.

However if Pac-Man bumps into a wall he stops and waits for the next direction. So, whenever the player wishes Pac-Man to change direction he needs to press an arrow key.

Let’s imagine a scenario: the player pressed the right arrow key and Pac-Man is now moving to the right; if the player presses the up arrow key and Pac-Man has walls in the up direction, meaning he can’t move up, the moment Pac-Man is able to move upwards he moves without needing another input from the player. So thats another implementation.

We implemented collision methods in order to avoid Pac-Man moving through walls and to detect when he is either caught by a ghost or eats a coin.

### Game mode

There are three different game modes. In order to understand them better let’s name them: we have the “**Chase**” mode, “**Scatter**” and the “**Frightened**” mode.

The main mode is “**Chase**”. This is when the ghosts are trying to capture Pac-Man. Then, in “**Scatter**” mode, the ghosts stop chasing Pac-Man and each will move to its respective corners. This mode only lasts for a few seconds then changes back to “**Chase**”. In this two modes each ghost has its own implementation. The last game mode is “**Frightened**” and it happens when Pac-Man eats a special coin. In this mode the ghosts move randomly so they aren’t trying to catch Pac-Man. Also, in this mode they are vulnerable because Pac-Man can eat them. When a ghost is eaten it returns to its original position on either chase or scatter mode.  

### Ghosts

Ghost types - There are four types of ghosts: Blinky (the red one), Pinky (the pink one), Inky (the blue one) and Clyde (the orange one).

Each ghost has a different tactic to catch Pac-Man. These are applied when the game is in “**Chase**” mode ([Game mode](#game-mode)).

**Blinky**: follows Pac-Man once located.  
**Pinky**: tries to ambush Pac-Man by getting in front of him.  
**Inky**: tries to trick Pac-Man using both Pac-Man's position and direction as well as Blinky's (the red ghost) position in his calculation.  
**Clyde**: moves randomly and appears to stay away from Pac-Man.

When the game is in “**Scatter**” mode ([Game mode](#game-mode)) the following tactics apply:

**Blinky**: moves to the top right corner.  
**Pinky**: moves to the top left corner.  
**Inky**: moves to the bottom right corner.  
**Clyde**: moves to the bottom left corner.

### Coins

Coins have two different types: **Small Coin** and **Power Coin**.

By eating a **Small Coin**, 10 points are added to Pac-Man’s score. However, if Pac-Man eats a **Power Coin** then 200 points are added to his score and that’s when “**Frightened**” mode is activated ([Game mode](#game-mode)).

The positions of the coins are read from the map text file and during the game no more coins appear. The player wins if Pac-Man eats all the coins.

## ARCHITECTURE PATTERN

**Problem in context**

Without any structural pattern the Single Principle Responsibility could be broken, so we decided to implement the MVC pattern. With it, it's possible to separate the data, interface and control of the game to have more code reusability and to make the code more organized and easy to implement.

**Pattern**

This particular pattern is useful for games and web applications because it helps separate the input logic that is converted to commands for either the Model or View (handled by the Controller); the data, game logic and rules of the game (handled by the Model) and the user interface that outputs information (handled by the View).

**Implementation**

**Consequences**

This architecture enables quick changes without having to rework much code in all layers of the application and helps testing components independently.

## DESIGN PATTERNS

### Strategy Pattern

**Problem in context**

In our code, Ghost's have three types of move behaviour. Scatter, Frightened and Chase. On chase mode there are two types of chasing. One that is random (ChaseRandom), and other that tries to reach an target (ChaseTarget). Furthermore, each ghost has a different way of defining a target. And this was where our problem relied. We needed a pattern design that could allow us to make changes to those behaviours without affecting the parts that stays the same.

**Pattern**

Implementing the Strategy pattern means taking a big class that does something in many ways and separating the different algorithms into separate classes. So in our case, we decided to create two interfaces: ChaseStrategy and TargetStrategy. ChaseSatretgy has two implementations: RandomChaseStratey and TargetChaseStrategy. TargetChaseStrategy has a TargetStrategy that can be AmbushTargetStrategy, PatrolTargetStrategy or ChaseTargetStrategy.

**Implementation**

**Consequences**

With the implementation of this pattern, is easier to introduce new strategies without having to change the context, and the code stays more organized.

### Observer Pattern
**Problem in context**

When there are objects that are interested in the actions of another object it's not beneficial for those objects to be constantly checking whether something happened or not. Probably most of those check-ups would be pointless. In our project the problem was that certain classes needed to be notified when there is user input.

**Pattern**

The Observer pattern is useful when there are objects waiting to be notified when an event happens to the object they are observing, because when that happens they also need to be changed.
In our project, the Observer Pattern was implemented in the MenuController class and in the PacmanController class, since they both implement the subscriber interface Observer. Both classes are waiting to be notified when there's user input. When they are notified of input they act and make the application progress.
In this case the class ReadKeys is the publisher and the classes MenuController and PacmanController are the subscribers.

**Implementation**

**Consequences**
When implementing this pattern it enables objects to establish relations between them at runtime and respects the Open/Closed Principle since it's easy to introduce new subscriber classes without having to change the publisher's code.


### Game Loop Pattern
**Problem in context**

Occasionally, the processor may not be sufficiently fast enough to render as many frames as desired. Additionally, the game logic and physics step are most vulnerable to these hardware differences.
**Pattern**

The Game Loop pattern is essential for game programs because this pattern's goal is to ensure that game time advances in the same speed in all different hardware setups. Game Loop was implemented because it's the main process of all the game rendering threads. The participating classes are:
**Implementation**

**Consequences**

The consequence of removing the rendering part from the update loop is that it enables simulation as often as wanted and rendering when possible.

### States Pattern
**Problem in context**

When an object can be in one of many states it is usually implemented a state machine with lots of conditions that select the appropriate behavior on the current state of the object. Easily it's added more and more states and conditions that make the code hard to maintain.
**Pattern**

The State pattern allows an object to alter its behavior when its internal state changes. By extracting the code related to the specific state behavior into separate classes, the object is forced to assign the work to an instance of these classes instead of acting on its own.

**Implementation**

**Consequences**

By implementing the State pattern, the bulky state machine conditionals are eliminated and the code becomes more organized because the code related to different behaviors is moved into separate classes (Single Responsibility Principle) and finally, when introducing new states there's no need to change existing states (Open/Closed Principle).

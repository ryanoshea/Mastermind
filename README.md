**This is a Java port of the strategy game Mastermind.**

## Game Info ##

**The object of the game is to guess a number, chosen at random.**

Each guess will be compared to the target number. 

A *RED* peg means that one of the numbers in your guess exists and is in the correct place in the target number.

A *WHITE* peg means that one of the numbers in your guess exists in the target number, but not in the same location as it is in your guess.

## Running the Game ##

Run the game by double-clicking the `Mastermind.jar` Java archive in `/dist`. 

*You need to have a Java JRE installed to run this game (you probably do).*

## Interfaces ##

The game supports two modes, GUI and terminal. The latest version, however, defaults to GUI and offers no way of switching. A way to choose (probably via args) is in the works.

## Logic ##

The algorithm for determining returns was borrowed from Wolfram MathWorld, as credited in the source. (Weisstein, Eric W. "Mastermind." From MathWorld--A Wolfram Web Resource. http://mathworld.wolfram.com/Mastermind.html)
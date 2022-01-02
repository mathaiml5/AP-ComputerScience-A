# Elevens Board Game

This program implements the Elevens Board Game activities from [College Board's Elevens Activity Guide](https://secure-media.collegeboard.org/digitalServices/pdf/ap/ap-compscia-elevens-lab-student-guide.pdf)

The Elevens game is a soltaire like game where you can remove any pair of cards that have been dealt face up that sum to 11 as follows:

1. The player removes each pair of cards (A, 2, … , 10) that total 11, e.g., an 8 and a 3, or a 10 and an A. 
2. An ace is worth 1, and suits are ignored when determining cards to remove.
3. Any triplet consisting of a J, a Q, and a K is also removed by the player. Suits are also ignored when determining which cards to remove.
4. Cards are dealt from the deck if possible to replace the cards just removed

The code for uses starter activity code provided by College Board for activities and implements Card.java, Board.java, Deck.java, and uses the GUI runner code for the game.

In particular it also implements the non-GUI simulation mode to determine the probability of winning with 1 million trials. Below is the final UML class diagram for the app:
![Elevens Class Diagram](https://github.com/mathaiml5/AP-ComputerScience-A/blob/main/ElevensGame/docs/elevensgame-uml.png?raw=true)



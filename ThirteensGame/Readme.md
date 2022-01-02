# Thirteens Board Game

This program implements the Thirteens Board Game Activity 10 from [College Board's Elevens Activity Guide](https://secure-media.collegeboard.org/digitalServices/pdf/ap/ap-compscia-elevens-lab-student-guide.pdf)

The Thirteens game is a soltaire like game where you can remove any pair of cards that have been dealt face up that sum to 13 as follows:

1. The player removes each pair of cards (A, 2, … , 10) that total 13, e.g., an 9 and a 4, or a Q and an A. 
2. An ace is worth 1, and suits are ignored when determining cards to remove, 
3. J, Q, K have 11, 12, 13 points respectively and suits are also ignored when determining which cards to remove. Any K can be removed independently.
4. Cards are dealt from the deck if possible to replace the cards just removed

The code for Thirteens uses starter activity code provided by College Board for activities and implements Card.java, Board.java, Deck.java, and uses the GUI runner code for the game.



Below is a video capture of the Thirteens game being played with the implementation of the game in the src subfolders:

https://user-images.githubusercontent.com/67560802/147872668-b1532113-ce3b-4dcd-b2df-4843dce97878.mp4



The class diagram for the app is similar to the Elevens and shown side by side in the diagram below:

![Thirteens Game Class Diagram](https://user-images.githubusercontent.com/67560802/147872637-a884c407-6804-4970-8893-42cd05f0af91.png)

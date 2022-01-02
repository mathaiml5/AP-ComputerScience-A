import java.util.List;
import java.util.ArrayList;

/**
 * The ThirteensBoard class represents the board in a game of Elevens.
 */
public class ThirteensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     * (I changed the point values for Jack and Queen to 11 and 12 from 0.)
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ThirteensBoard</code> instance.
     */
    public ThirteensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Thirteens, the legal groups are (1) a pair of cards
     * whose values add to 13( not containing a king), and (2) a king.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     * (I changed the named of the methods called to those required for a thirteens board(containsPairSum13
     * and containsK methods).)
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2) {
            return containsPairSum13(selectedCards);
        } else if (selectedCards.size() == 1) {
            return containsK(selectedCards);
        } else {
            return false;
        }
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Thirteens, there is a legal play if the board contains
     * (1) a pair of cards whose values add to 13( not containing a King), or (2) a king.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     *(I changed the named of the methods called to those required for a thirteens board(containsPairSum13
     * and containsK methods).)
     */
    @Override
    public boolean anotherPlayIsPossible() {
        List<Integer> cIndexes = cardIndexes();
        return containsPairSum13(cIndexes) || containsK(cIndexes);
    }

    /**
     * Check for an 13-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 13-pair.
     * @return true if the board entries in selectedCards
     *              contain an 13-pair; false otherwise.
     * (I changed the required sum of the point values to 13.)
     */
    private boolean containsPairSum13(List<Integer> selectedCards) {
        for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
            int k1 = selectedCards.get(sk1).intValue();
            for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
                int k2 = selectedCards.get(sk2).intValue();
                if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 13) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for a King in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a King.
     * @return true if the board entries in selectedCards
     *              includes a king; false otherwise.
     * (I changed the cards required to be selected to only King and only kept the found King variable which is the
     * value the method returns.)
     */
    private boolean containsK(List<Integer> selectedCards) {
        boolean foundKing = false;
        for (Integer kObj : selectedCards) {
            int k = kObj.intValue();
            if (cardAt(k).rank().equals("king")) {
                foundKing = true;
                break;
            }
          }
        return foundKing;
    }
}


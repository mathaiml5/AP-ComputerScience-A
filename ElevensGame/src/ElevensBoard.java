import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

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
	 */
	private static final int[] POINT_VALUES =
			{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 *
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 * false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		//to check if a move is legal we check if there is a list of cards whose indexes sum to 11(findPairSum11()
		//returns a non-empty list) or if there is a Jack, Queen, and King(findJQK() returns a non-empty list)
		if (selectedCards.size() == 2) {
			return findPairSum11(selectedCards).size() > 0;
		} else if (selectedCards.size() == 3) {
			return findJQK(selectedCards).size() > 0;
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 *
	 * @return true if there is a legal play left on the board;
	 * false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		//if findPairSum11 on cIndexes(the set of cards which can be selected) or findJQK on cIndexes(the set of cards
		// which can be selected) returns a nonempty list then another move is possible
		List<Integer> cIndexes = cardIndexes();
		return findPairSum11(cIndexes).size() > 0 || findJQK(cIndexes).size() > 0;
	}

	/**
	 * Look for an 11-pair in the selected cards.
	 *
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return a list of the indexes of an 11-pair, if an 11-pair was found;
	 * an empty list, if an 11-pair was not found.
	 */
	private List<Integer> findPairSum11(List<Integer> selectedCards) {
		//create an array list called indices which will  contain the first set indices of the cards whose point sum to
		//11 if any such pair of cards exist
		List<Integer> indices = new ArrayList<Integer>();
		outer:
		//loop through the cards in the selected cards list and look to find cards whose point sum to 11 if any such
		//pair of cards exist
		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11) {
					//add the indices of the cards whose point values sum to 11 to the indices array to be outputed
					indices.add(k1);
					indices.add(k2);
					break outer;
				}
			}
		}
		return indices;
	}

	/**
	 * Look for a JQK in the selected cards.
	 *
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return a list of the indexes of a JQK, if a JQK was found;
	 * an empty list, if a JQK was not found.
	 */
	private List<Integer> findJQK(List<Integer> selectedCards) {
		//look through the list of selected cards if we find a jack, queen, and king output their index
		boolean foundJack = false;
		int indexJack = 0;
		boolean foundQueen = false;
		int indexQueen = 0;
		boolean foundKing = false;
		int indexKing = 0;
		for (int k = 0; k < selectedCards.size(); k++) {
			if (cardAt(selectedCards.get(k)).rank().equals("jack") && foundJack != true) {
				foundJack = true;
				indexJack = selectedCards.get(k);
			} else if (cardAt(selectedCards.get(k)).rank().equals("queen") && foundQueen != true) {
				foundQueen = true;
				indexQueen = selectedCards.get(k);
			} else if (cardAt(selectedCards.get(k)).rank().equals("king") && foundKing != true) {
				foundKing = true;
				indexKing = selectedCards.get(k);
			}
		}
		List<Integer> indices = new ArrayList<Integer>();
		//only if we find a jack, a queen, and a king do we create a list containing the index of the jack, queen, and
		//king and return this list
		//otherwise, we return an empty list
		if ((foundJack == true && foundQueen == true) && foundKing == true) {
			indices.add(indexJack);
			indices.add(indexQueen);
			indices.add(indexKing);
			return indices;
		} else {
			return new ArrayList<>();
		}
	 }



	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 * @return true if a legal play was found (and made); false otherwise.
	 */
	public boolean playIfPossible() {
		//another play is possible if both playPairSum11IfPossible() and playJQKIfPossible() are not false, i.e.
		// EITHER there are cards whose point values sum to 11
		// OR there is a jack, a queen, and a king combination
		// Using lazy evaluation
		return (playPairSum11IfPossible() || playJQKIfPossible());
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11.
	 * If found, replace them with the next two cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if an 11-pair play was found (and made); false otherwise.
	 */
	private boolean playPairSum11IfPossible() {
		//if a non empty list is returned from findPairSum11() on cardIndexes(a list of the indexes of cards that can be
		// selected) then there are cards which sum to 11 and can be removed, so we remove those cards and return true
		//for this method
		// if an empty list of cards is obtained from the findPairSum11() on cardIndexes then we cannot remove anything
		// and return false for this method
		if (findPairSum11(cardIndexes()).size() == 0) {
			return false;
		}
		else{
			List<Integer> indices_to_remove = new ArrayList<Integer>();
			indices_to_remove = findPairSum11(cardIndexes());
			replaceSelectedCards(indices_to_remove);
			return true;
		}
	}

	/**
	 * Looks for a group of three face cards JQK.
	 * If found, replace them with the next three cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if a JQK play was found (and made); false otherwise.
	 */
	private boolean playJQKIfPossible() {
		//if a non empty list is returned from findJQK() on cardIndexes(a list of the indexes of cards that can be
		// selected) then there is a Jack, Queen, and King, so we remove those cards and return true
		//for this method
		// if an empty list of cards is obtained from the findJQK() on cardIndexes then we cannot remove anything
		// and return false for this method
		if (findJQK(cardIndexes()).size() == 0) {
			return false;
		}
		else{
			List<Integer> indices_to_remove = new ArrayList<Integer>();
			indices_to_remove = findJQK(cardIndexes());
			replaceSelectedCards(indices_to_remove);
			return true;
		}
	}
}

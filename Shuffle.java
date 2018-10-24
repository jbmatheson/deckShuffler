import java.util.HashSet;
import java.util.Set;

public class Shuffle {
	private static final String[] CARDS = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; // # of cards
	private static final String[] SUITS = new String[] {"\u2660","\u2663","\u2665","\u2666"}; // Suits
	private static final int STD_DECK_SIZE = 52;
	
	private static String[] deck = new String[STD_DECK_SIZE];

    /**
     * Creates an array of 52 strings representing cards in the order A,2,3..J,Q,K for each
     * suit in order of spades, clubs, hearts, diamonds.
     */
	public static void initDeck(){
		int nCards = 0;
		int nSuits = 0;
		int lCards = CARDS.length - 1;
		int lDeck = STD_DECK_SIZE;
		
		System.out.println("--------============== Original Deck Order - Unshuffled ==============--------");
		for(int i = 0; i < lDeck; i++){
			deck[i] = CARDS[nCards] + " " + SUITS[nSuits];
			
			System.out.print(deck[i] + " | ");
			
			if(nCards == lCards){
				System.out.println();
				nCards = 0;
				nSuits++;
			}else {
				nCards++;
			}
		}
	}

    /**
     * Write your shuffle code here. Do not use Collections.shuffle()!
     * @param shuffleCount Number of times to run execute your shuffle logic. This is for you to implement.
     */
	private static void shuffleDeck(int shuffleCount) {
		String[] newDeck = new String[STD_DECK_SIZE];
		long startTime = System.nanoTime();
		
		/* Your Code */

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = (double)elapsedTime / 1000000000.0;
		
		System.out.println("\n--------============== New Deck Order after " + shuffleCount + " shuffles ===============--------");

		printDeck();
		System.out.println("\nThis Shuffling Algorithm took: "+ seconds + " seconds");
		checkDeck();
		checkShuffle(newDeck);
	}

    /**
     * Prints the formatted deck to console
     */
	public static void printDeck() {
		int lDeck = deck.length;
		int lCards = CARDS.length - 1;
		int colIndex = 0;
		
		for (int i = 0; i < lDeck; i++) {
			System.out.print(deck[i] + " | ");
			if(colIndex == lCards) {
				colIndex = 0;
				System.out.println();
				continue;
			}
			colIndex++;
		}
	}

    /**
     * Checks deck for STD_DECK_SIZE number of unique items.
     * Does not check for expected strings.
     */
	public static void checkDeck() {
	    Set<String> cardInventory = new HashSet<>();
	    for (String card : deck) {
	        cardInventory.add(card);
        }
        int totalCards = cardInventory.size();
        System.out.println("\n-----------============== Number of unique cards: " + totalCards + " ==============-----------");
        if (totalCards != STD_DECK_SIZE) {
	        System.out.println("Your deck does not have the correct number of cards!");
        }
    }

    /**
     * Checks passed in nDeck against deck for percentage of cards not in the original positions
     * @param nDeck new deck to check against original deck
     */
	private static void checkShuffle(String[] nDeck) {
		int count = 0;
		for (int i = 0; i < nDeck.length; i++) {
			if(nDeck[i] != deck[i]) {
				count++;
			}
		}
		int percentChange = (count / STD_DECK_SIZE) * 100;
		System.out.println("\n-----===== % cards from original deck not in the starting positon: " + percentChange + " =====---");
	}

	public static void main(String[] args) {
		// shuffle 1,100,5000,20000,500000, and 1,000,000
		initDeck();
		shuffleDeck(1);
	}
}

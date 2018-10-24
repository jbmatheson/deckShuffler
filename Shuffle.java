import java.util.Random;

public class Shuffle {
	private static final String[] CARDS = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; // # of cards
	private static final String[] SUITS = new String[] {"\u2660","\u2663","\u2665","\u2666"}; // Suits
	private static final int STD_DECK_SIZE = 52;
	
	private static String[] deck = new String[STD_DECK_SIZE];

	public static String[] initDeck(String[] CARDS,String[] SUITS){
		int nCards = 0;
		int nSuits = 0;
		int lCards = CARDS.length - 1;
		int lDeck = deck.length;
		
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
		return deck;
	}
	
	private static void shuffleDeck(String[] newDeck, int shuffleCount) {
		long startTime = System.nanoTime();
		/* Your Code */
		
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = (double)elapsedTime / 1000000000.0;
		
		System.out.println("\n--------============== New Deck Order after " + shuffleCount + " shuffles ==============--------");

		printDeck();
		System.out.println("\nThis Shuffling Algorithm took: "+ seconds + " seconds"); 
	}
	
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
	
	public static void main(String[] args) {
		// shuffle 1,100,5000,20000,500000, and 1,000,000
		String[] newDeck = initDeck(CARDS, SUITS);
		shuffleDeck(newDeck, 500);					
	}
}

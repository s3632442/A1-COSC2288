package model.card;

public class DeckImpl implements Deck {
	
	private DeckImpl(Suit suit, Rank rank) {

	}

	@Override
	public Card removeNextCard() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cardsInDeck() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void shuffleDeck() {
		// TODO Auto-generated method stub
		
	}
	
	//ATTN may not be fully implemented
	public static Deck createShuffledDeck() {
		return null;
		
	}
	//ATTN may not be fully implemented
	public static Deck createSortedDeck() {
		return null;
	}

}

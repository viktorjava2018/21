package blackjack2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	Random randomGenerator = new Random();

	public Deck() {
		cards = new ArrayList<Card>();
	}
	public  void reNewDeck() {
		cards.clear();
		initCard();
	}
	
	private void initCard() {
		for (int i = 0; i < 4; i++) {
			cards.add(new Card("KETT�", 2));
			cards.add(new Card("H�ROM", 3));
			cards.add(new Card("N�GY", 4));
			cards.add(new Card("�T", 5));
			cards.add(new Card("HAT", 6));
			cards.add(new Card("H�T", 7));
			cards.add(new Card("NYOLC", 8));
			cards.add(new Card("KILENC", 9));
			cards.add(new Card("T�Z", 10));
			cards.add(new Card("BUBI", 10));
			cards.add(new Card("D�MA", 10));
			cards.add(new Card("KIR�LY", 10));
			cards.add(new Card("�SZ", 10));
		}}

		
	public Card draw() {
		
		int randInt = new Random().nextInt(cards.size());
		randInt = Math.abs(randInt);
			Card card = cards.get(randInt);
			cards.remove(randInt);
			return card;
	}	{	

	}}
// }
// public Card draw() {
// Card card = cards.get(0);
// cards.remove(0);
// return card;
//

// }
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
			cards.add(new Card("KETTÕ", 2));
			cards.add(new Card("HÁROM", 3));
			cards.add(new Card("NÉGY", 4));
			cards.add(new Card("ÖT", 5));
			cards.add(new Card("HAT", 6));
			cards.add(new Card("HÉT", 7));
			cards.add(new Card("NYOLC", 8));
			cards.add(new Card("KILENC", 9));
			cards.add(new Card("TÍZ", 10));
			cards.add(new Card("BUBI", 10));
			cards.add(new Card("DÁMA", 10));
			cards.add(new Card("KIRÁLY", 10));
			cards.add(new Card("ÁSZ", 10));
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
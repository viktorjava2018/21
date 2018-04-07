package blackjack2;

public class Card {
	private String suit;
	private int value;

	public Card(String suit, int value) {
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return suit;
	}
}
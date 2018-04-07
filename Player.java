package blackjack2;

import java.util.ArrayList;

public class Player {

	ArrayList<Card> cards;
	private double money;

	public Player(double money) {
		this.money = money;
		this.cards = new ArrayList<Card>();
	}

	public void clearCards() {
		cards.clear();
	}

	public double getMoney() {
		return money;
	}

	public void add(Card card) {
		cards.add(card);
	}

	public void showCard() {
		System.out.println(cards);
	}

	public int cardsValue() {
		int cardValues = 0;
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			cardValues += card.getValue();
		}
		return cardValues;
	}

	public String firstCard() {
		if (!cards.isEmpty()) {
			return cards.get(0).toString();
		}
		return "Nincs kártya a pakliban!";
	}

	public String lastCard() {
		if (!cards.isEmpty()) {
			return cards.get(cards.size() - 1).toString();
		}
		return "Nincs kártya a pakliban!";
	}

	public void decreaseMoney(double playerBet) {
		money = money - playerBet;

	}

	public void increaseMoney(double playerBet) {
		money = money + playerBet;

	}

}

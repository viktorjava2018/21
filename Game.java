package blackjack2;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		game.start();

	}

	private void start() {
		System.out.println(" �dv a BlackJackben!");
		Player player = new Player(1000d);
		Player delaer = new Player(Double.MAX_VALUE);

		doStart(player, delaer);

	}

	private void doStart(Player player, Player delaer) {
		Deck playingDeck = new Deck();
		while (player.getMoney() > 0) {

			playingDeck.reNewDeck();
			startGame(playingDeck, player, delaer);
		}
		System.out.println("Elfogyott a p�nzed, a j�t�knak v�ge!");
	}

	private void startGame(Deck playingDeck, Player player, Player delaer) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Jelenleg ennyi p�nzed van: " + player.getMoney() + "  Mennyi p�nzt raksz fel?");
		double playerBet = userInput.nextDouble();
		if (playerBet > player.getMoney()) {
			System.out.println("Nincs ennyi p�nzed!");
			userInput.close();
			return;
		}
		drawStartingCards(playingDeck, player, delaer);
		playerRound(playingDeck, userInput, playerBet, player, delaer);

		evaluation(playingDeck, playerBet, delaer, player);
		clearCards(delaer, player);
	}

	private void clearCards(Player delaer, Player player) {
		player.clearCards();
		delaer.clearCards();

	}

	private void evaluation(Deck playingDeck, double playerBet, Player delaer, Player player) {
		System.out.println(" Az oszt� lapjai: ");
		delaer.showCard();
		if (player.cardsValue() == delaer.cardsValue()) {
			System.out.println("Az eredm�ny d�ntetlen!");
			return;
		}

		if (player.cardsValue() > 21) {
			System.out.println("A bank gy�z�tt!");
			player.decreaseMoney(playerBet);
			return;
		}

		if (delaer.cardsValue() > player.cardsValue()) {
			System.out.println("A bank gy�z�tt!");
			player.decreaseMoney(playerBet);
			return;
		}
		while (delaer.cardsValue() < 17) {
			addCard(playingDeck, delaer);
			System.out.println("Az oszt� h�z lapot: " + delaer.lastCard());

		}
		if (player.cardsValue() == delaer.cardsValue()) {
			System.out.println("Az eredm�ny d�ntetlen!");
			return;
		}

		if (player.cardsValue() > 21) {
			System.out.println("A bank gy�z�tt!");
			player.decreaseMoney(playerBet);
			return;
		}

		if (delaer.cardsValue() > player.cardsValue()) {
			System.out.println("A bank gy�z�tt!");
			player.decreaseMoney(playerBet);
			return;
		}
		System.out.println("Az oszt� lapjainak �rt�ke: " + delaer.cardsValue());
		System.out.println("NYERT�L!");
		player.increaseMoney(playerBet);
	}

	private void playerRound(Deck playingDeck, Scanner userInput, double playerBet, Player player, Player delaer) {
		while (true) {
			System.out.println("A kezedben ezek vannak:");
			player.showCard();
			System.out.println("A lapjaid �rt�ke:" + player.cardsValue());
			System.out.println("Az oszt� egyik lapja: " + delaer.firstCard() + " ,a m�sikat nem l�thatod!");

			System.out.println("Lapot k�rsz? (1) vagy meg�llsz (2) ? ");
			int response = userInput.nextInt();
			if (response == 1) {
				addCard(playingDeck, player);
				System.out.println("A lap amit kapt�l:" + player.lastCard());
				if (player.cardsValue() > 21) {
					return;
				}
			} else if (response == 2) {
				return;
			} else {
				System.out.println("Egyest, vagy kettest v�laszolj!");
			}
		}
	}

	private void drawStartingCards(Deck playingDeck, Player player, Player delaer) {
		addCard(playingDeck, player);
		addCard(playingDeck, player);
		addCard(playingDeck, delaer);
		addCard(playingDeck, delaer);
	}

	private void addCard(Deck playingDeck, Player player) {

		Card card = playingDeck.draw();
		player.add(card);
	}
}

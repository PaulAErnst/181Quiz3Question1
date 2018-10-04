package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();
	
	public static void main(String[] args) {
		Deck newDeck = new Deck();
		try {
			newDeck.Draw();
		} catch (DeckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(newDeck.getRemaining(eRank.ACE));
	}

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	
	public int getRemaining(Object eNum) {
		int getCount = 0;
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eNum || c.geteRank() == eNum) {
				getCount++;
			}
		}
		return getCount;
	}
}
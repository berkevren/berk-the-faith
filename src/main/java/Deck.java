import java.util.ArrayList;
import java.util.Collections;

import card.*;

public class Deck {

    private ArrayList<Card> deck;
    private DeckFileReader deckFileReader;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public Deck(String deckTextFileAddress) {

        deckFileReader = new DeckFileReader(deckTextFileAddress);
        deck = deckFileReader.readCardsFromTextFile();

    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card getTopCardAndRemoveFromDeck() {
        int firstCard = 0;
        return this.deck.remove(firstCard);
    }

    public void addCardToBottomOfDeck(Card cardToAdd) {
        int bottomCard = this.deck.size();
        this.deck.add(bottomCard, cardToAdd);
    }

    public Card revealTopCard() {
        int firstCard = 0;
        return this.deck.get(firstCard);
    }
}

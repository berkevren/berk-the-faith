package berkTheFaith.duel;

import java.util.ArrayList;
import java.util.Collections;

import berkTheFaith.card.*;
import berkTheFaith.cardCreation.DeckFileReader;

public class Deck {

    private ArrayList<Card> deck;
    private DeckFileReader deckFileReader;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public Deck(String deckName) {

        deckFileReader = new DeckFileReader(deckName);
        deck = deckFileReader.readDeckFromTextFile();

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

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public DeckFileReader getDeckFileReader() {
        return deckFileReader;
    }
}

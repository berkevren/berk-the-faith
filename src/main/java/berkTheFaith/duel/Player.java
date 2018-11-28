package berkTheFaith.duel;

import berkTheFaith.card.*;

public class Player {

    private String playerName;
    private Deck playerDeck;
    private Deck playerHand;
    private int lifePoint;

    public Player(String playerName, String deckTextFileAddress) {

        this.playerName = playerName;
        this.playerDeck = new Deck(deckTextFileAddress);
        this.playerHand = new Deck();
        this.lifePoint = 8000;

    }

    public void drawStartingHand() {
        for (int i = 0; i < 5; i++) {
            drawCardFromDeck();
        }
    }

    public void drawCardFromDeck() {
        Card topCardOfDeck = this.playerDeck.getTopCardAndRemoveFromDeck();
        this.playerHand.addCardToBottomOfDeck(topCardOfDeck);
    }

    public Deck getPlayerHand() {
        return playerHand;
    }

}

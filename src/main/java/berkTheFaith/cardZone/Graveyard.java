package berkTheFaith.cardZone;

import berkTheFaith.duel.Deck;

public class Graveyard {

    private Deck graveyardPile;

    public Graveyard() {
        graveyardPile = new Deck();
    }

    public Deck getGraveyardPile() {
        return graveyardPile;
    }

    public void setGraveyardPile(Deck graveyardPile) {
        this.graveyardPile = graveyardPile;
    }
}

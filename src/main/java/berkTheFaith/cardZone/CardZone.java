package berkTheFaith.cardZone;

import berkTheFaith.card.*;

public class CardZone {

    protected int zoneNumber;
    protected boolean occupied;
    protected Card cardOnTheZone;

    public CardZone() {}

    public CardZone(int zoneNumber) {
        this.zoneNumber = zoneNumber;
        this.occupied = false;
        this.cardOnTheZone = null;
    }

    public void putCardOnCardZone(Card card) {
        this.occupied = true;
        this.cardOnTheZone = card;
    }

    public Card getCardOnTheZone() {
        return cardOnTheZone;
    }

    public void sendCardFromZoneToGraveyard() {
        this.occupied = false;
        cardOnTheZone = null;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String toString() {
        if (isOccupied())
            return cardOnTheZone.toString().substring(6, 10);
        return "_____";
    }
}

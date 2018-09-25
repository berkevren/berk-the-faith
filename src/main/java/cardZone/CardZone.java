package cardZone;

import card.*;

public class CardZone {

    protected int zoneNumber;
    protected boolean occupied;
    protected Card cardInTheZone;

    public CardZone(int zoneNumber) {
        this.zoneNumber = zoneNumber;
        this.occupied = false;
    }

    public void putCardOnCardZone(Card cardInTheZone) {
        this.occupied = true;
        this.cardInTheZone = cardInTheZone;
    }


    public void sendCardFromZoneToGraveyard() {
        this.occupied = false;
        cardInTheZone = null;
    }

    public boolean isOccupied() {
        return occupied;
    }

}

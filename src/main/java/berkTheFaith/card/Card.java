package berkTheFaith.card;

public abstract class Card {

    protected String cardName, cardText;
    protected CardTypes cardType;

    public Card(String cardName, String cardText, CardTypes cardType) {
        this.cardName = cardName;
        this.cardText = cardText;
        this.cardType = cardType;
    }

    public boolean equals(Card card) {
        if (this.cardName.equals(card.cardName))
            return true;
        return false;
    }

    public void setCardType(CardTypes cardType) {
        this.cardType = cardType;
    }

    public String toString() {

        String result = "Name: " + cardName + "\nCard Type: " + cardType + "\nText: " + cardText;
        return result;
    }
}

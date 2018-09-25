public abstract class Card {

    protected String cardName, cardText;
    protected CardTypes cardType;

    public boolean equals(Card card) {
        if (this.cardName.equals(card.cardName))
            return true;
        return false;
    }
}

package berkTheFaith.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Card {

    protected String cardName, cardText;
    protected CardTypes cardType;

    public Card(){

    }

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

    public String toString() {

        String result = "Name: " + cardName + "\nCard Type: " + cardType + "\nText: " + cardText;
        return result;
    }

    public String toReadableByDeckFileReaderForm() {
        String readableByDeckFileReaderForm = "\n" + cardType.toString(cardType) + "\n" + cardName + "\n" + cardText;
        return readableByDeckFileReaderForm;
    }

    public void setCardType(CardTypes cardType) {
        this.cardType = cardType;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }
}

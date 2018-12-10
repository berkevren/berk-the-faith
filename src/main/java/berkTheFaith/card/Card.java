package berkTheFaith.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Card {

    protected int id;
    protected String cardName, cardText;
    protected CardTypes cardType;

    public Card(){

    }

    public Card(int id, String cardName, String cardText, CardTypes cardType) {
        this.id = id;
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

        String result = "Id: " + id + "\nName: " + cardName + "\nCard Type: " + cardType + "\nText: " + cardText;
        return result;
    }

    public String toReadableByDeckFileReaderForm() {
        String readableByDeckFileReaderForm = "\n" + id + "\n" + cardType.toString(cardType) + "\n" + cardName +
                "\n" + cardText;
        return readableByDeckFileReaderForm;
    }

    public int getId() {
        return id;
    }

    public String getCardName() {
        return cardName;
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

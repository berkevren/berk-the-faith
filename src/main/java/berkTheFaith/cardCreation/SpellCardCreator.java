package berkTheFaith.cardCreation;

import berkTheFaith.card.Card;
import berkTheFaith.card.CardTypes;
import berkTheFaith.card.NormalMonsterCard;
import berkTheFaith.card.NormalSpellCard;

import java.io.BufferedReader;
import java.io.IOException;

public class SpellCardCreator extends CardCreator {

    private String cardType;
    private String cardName, cardText;
    private CardTypes spellType;

    public SpellCardCreator(BufferedReader bufferedReader) {
        super(bufferedReader);
    }

    public Card createSpellCard() throws IOException {

        cardType = bufferedReader.readLine();

        if (cardType.equals("Normal")) {
            return createNormalSpellCard();
        }
        return null;

    }

    private Card createNormalSpellCard() throws IOException {

        cardName = bufferedReader.readLine();
        cardText = bufferedReader.readLine();
        spellType = CardTypes.NORMALSPELL;

        NormalSpellCard normalSpellCard = new NormalSpellCard(cardName, cardText, spellType);

        return normalSpellCard;
    }
}

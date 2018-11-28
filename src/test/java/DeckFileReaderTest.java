import berkTheFaith.duel.Deck;
import berkTheFaith.cardCreation.DeckFileReader;
import berkTheFaith.card.Card;
import berkTheFaith.card.CardTypes;
import berkTheFaith.card.NormalMonsterCard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DeckFileReaderTest {

    private Card vorseRaider, blueEyesWhiteDragon, darkMagician;

    @Before
    public void initCards() {

        vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "DARK", "Beast-Warrior", 1900, 1200, 4);

        blueEyesWhiteDragon = new NormalMonsterCard("Blue-Eyes White Dragon", "This legendary dragon " +
                "is a powerful engine of destruction. Virtually invincible, very few have faced this awesome creature " +
                "and lived to tell the tale.", CardTypes.NORMALMONSTER,
                "LIGHT", "Dragon", 3000, 2500, 8);

        darkMagician = new NormalMonsterCard("Dark Magician", "The ultimate wizard in terms of " +
                "attack and defense.", CardTypes.NORMALMONSTER, "DARK", "Spellcaster",
                2500, 2100, 7);
    }

    @Test
    public void readNamesOfCardsOfDeckFromTxtFileTest() {
        ArrayList<String> namesOfAllCards = new ArrayList<String>();
        namesOfAllCards.add("Vorse Raider");
        namesOfAllCards.add("Vorse Raider");
        namesOfAllCards.add("Vorse Raider");
        namesOfAllCards.add("Blue-Eyes White Dragon");
        namesOfAllCards.add("Blue-Eyes White Dragon");
        namesOfAllCards.add("Blue-Eyes White Dragon");

        DeckFileReader deckFileReader = new DeckFileReader("3VorseRaider3BlueEyesDeck");
        int i = 0;

        for (String cardName : namesOfAllCards) {
            assert (cardName.equals(deckFileReader.getNamesOfCardsInDeck().get(i)));
            i++;
        }
    }

    @Test
    public void readDeckFromTextFileTest() {
        Deck expectedDeck = new Deck();
        Deck actualDeck = new Deck("3VorseRaider3BlueEyesDeck");

        expectedDeck.addCardToBottomOfDeck(vorseRaider);
        expectedDeck.addCardToBottomOfDeck(vorseRaider);
        expectedDeck.addCardToBottomOfDeck(vorseRaider);
        expectedDeck.addCardToBottomOfDeck(blueEyesWhiteDragon);
        expectedDeck.addCardToBottomOfDeck(blueEyesWhiteDragon);
        expectedDeck.addCardToBottomOfDeck(blueEyesWhiteDragon);

        for (int i = 0; i < 5; i++) {
            assert (expectedDeck.getTopCardAndRemoveFromDeck().toString().equals(
                    actualDeck.getTopCardAndRemoveFromDeck().toString()));
        }
    }

    @Test
    public void readCardsWhenFromAPIIFNotPresentAsTextFileTest() {

        Deck actualDeck = new Deck("DarkMagician");
        Card actualCard = actualDeck.getTopCardAndRemoveFromDeck();

        assert(darkMagician.toString().equals(actualCard.toString()));
    }

}

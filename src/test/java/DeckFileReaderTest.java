import berkTheFaith.Deck;
import berkTheFaith.DeckFileReader;
import berkTheFaith.card.Card;
import berkTheFaith.card.CardTypes;
import berkTheFaith.card.NormalMonsterCard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DeckFileReaderTest {

    private Card vorseRaider, blueEyesWhiteDragon;

    @Before
    public void initCards() {

        vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "Dark", "Beast-Warrior", 1900,1200, 4);

        blueEyesWhiteDragon = new NormalMonsterCard("Blue-Eyes White Dragon", "This legendary dragon " +
                "is a powerful engine of destruction. Virtually invincible, very few have faced this awesome creature " +
                "and lived to tell the tale.", CardTypes.NORMALMONSTER,
                "Light", "Dragon", 3000,2500, 8);
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
            assert(cardName.equals(deckFileReader.getNamesOfCardsInDeck().get(i)));
            i++;
        }
    }

    @Test
    public void readDeckFromTextFileTest() {
        Deck testDeck = new Deck();
        Card expectedCard, actualCard;

        testDeck.addCardToBottomOfDeck(vorseRaider);
        testDeck.addCardToBottomOfDeck(vorseRaider);
        testDeck.addCardToBottomOfDeck(vorseRaider);
        testDeck.addCardToBottomOfDeck(blueEyesWhiteDragon);
        testDeck.addCardToBottomOfDeck(blueEyesWhiteDragon);
        testDeck.addCardToBottomOfDeck(blueEyesWhiteDragon);

        DeckFileReader deckFileReader = new DeckFileReader()
        Deck actualDeck =

        for (int i = 0; i < 5; i++) {

            expectedCard = playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck();
            actualCard = testHand.getTopCardAndRemoveFromDeck();
            assert(expectedCard.equals(actualCard));
        }
    }
}

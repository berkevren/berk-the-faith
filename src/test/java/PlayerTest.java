import berkTheFaith.Deck;
import berkTheFaith.Player;
import berkTheFaith.card.NormalMonsterCard;
import org.junit.Before;
import org.junit.Test;

import berkTheFaith.card.*;

public class PlayerTest {

    private String deckTextFileAddress;
    private Player playerBerk, playerRival;
    private Card vorseRaider, blueEyesWhiteDragon;

    @Before
    public void init() {
        initCards();
        initDeckAddress();
        initPlayers();
    }


    public void initCards() {

        vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "Dark", "Beast-Warrior", 1900,1200, 4);

        blueEyesWhiteDragon = new NormalMonsterCard("Blue-Eyes White Dragon", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "Light", "Dragon", 3000,2500, 8);
    }

    public void initDeckAddress() {
        deckTextFileAddress = "/testDecks/deck3VorseRaider3BlueEyes.txt";
    }

    public void initPlayers() {
        String playerName = "Berk";
        playerBerk = new Player(playerName, deckTextFileAddress);
    }

    @Test
    public void drawSingleCardFromDeck() {
        playerBerk.drawCardFromDeck();

        assert(playerBerk.getPlayerHand().revealTopCard().equals(vorseRaider));
        assert(playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck().equals(vorseRaider));
    }

    @Test
    public void drawStartingHand() {

        Deck testHand = new Deck();
        Card expectedCard, actualCard;

        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(blueEyesWhiteDragon);
        testHand.addCardToBottomOfDeck(blueEyesWhiteDragon);

        playerBerk.drawStartingHand();

        for (int i = 0; i < 5; i++) {

            expectedCard = playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck();
            actualCard = testHand.getTopCardAndRemoveFromDeck();
            System.out.println("Expected card: " + expectedCard.toString());
            System.out.println("Actual card: " + actualCard.toString());
            assert(expectedCard.equals(actualCard));
        }
    }
}
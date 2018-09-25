import card.NormalMonsterCard;
import org.junit.Test;

import card.*;

public class PlayerTest {

    private String deckTextFileAddress;
    private Player playerBerk, playerRival;
    private Card vorseRaider, blueEyesWhiteDragon;
    private Deck testHand;

    public void init() {
        initCards();
        initDeckAddress();
        initPlayers();
    }


    public void initCards() {

        vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", "Dark",
                "Beast-Warrior", 1900,1200, 4);
        vorseRaider.setCardType(CardTypes.NORMALMONSTER);

        blueEyesWhiteDragon = new NormalMonsterCard("Blue-Eyes White Dragon", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", "Dark",
                "Beast-Warrior", 3000,2500, 8);
        blueEyesWhiteDragon.setCardType(CardTypes.NORMALMONSTER);

    }

    public void initDeckAddress() {
        deckTextFileAddress = "cards/deck3VorseRaider3BlueEyes.txt";
    }

    public void initPlayers() {
        String playerName = "Berk";
        playerBerk = new Player(playerName, deckTextFileAddress);
    }

    @Test
    public void drawSingleCardFromDeck() {

        init();

        playerBerk.drawCardFromDeck();

        assert(playerBerk.getPlayerHand().revealTopCard().equals(vorseRaider));
        assert(playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck().equals(vorseRaider));
    }

    @Test
    public void drawStartingHand() {

        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(blueEyesWhiteDragon);
        testHand.addCardToBottomOfDeck(blueEyesWhiteDragon);

        Card expectedCard, actualCard;

        for (int i = 0; i < 5; i++) {

            expectedCard = playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck();
            actualCard = testHand.getTopCardAndRemoveFromDeck();
            assert(expectedCard.equals(actualCard));
        }
    }
}
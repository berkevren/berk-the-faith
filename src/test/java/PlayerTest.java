import org.junit.Test;

public class PlayerTest {

    @Test
    public void drawSingleCardFromDeck() {
        String deckTextFileAddress = "cards/deck3VorseRaider3BlueEyes.txt";
        Player playerBerk = new Player("Berk", deckTextFileAddress);
        playerBerk.drawCardFromDeck();

        Card vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", "Dark",
                "Beast-Warrior", 1900,1200, 4);
        vorseRaider.cardType = CardTypes.NORMALMONSTER;

        assert(playerBerk.getPlayerHand().revealTopCard().equals(vorseRaider));
        assert(playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck().equals(vorseRaider));
    }
}
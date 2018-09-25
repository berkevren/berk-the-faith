import org.junit.Test;

public class DeckFileReaderTest {

    @Test
    public void deckFromVorseRaiderOnlyTest() {
        Card vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", "Dark",
                "Beast-Warrior", 1900,1200, 4);
        vorseRaider.cardType = CardTypes.NORMALMONSTER;

        DeckFileReader deckFileReader = new DeckFileReader("cards/deckOnlyVorseRaider.txt");
        assert(vorseRaider.toString().equals(deckFileReader.readCardsFromTextFile().get(0).toString()));
    }

}

import berkTheFaith.DeckFileReader;
import org.junit.Test;
import berkTheFaith.card.*;

public class DeckFileReaderTest {

    @Test
    public void deckFromVorseRaiderOnlyTest() {
        Card vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "Dark", "Beast-Warrior", 1900,1200, 4);

        System.out.println(System.getProperty("user.dir"));
        DeckFileReader deckFileReader = new DeckFileReader("/testDecks/deckOnlyVorseRaider.txt");
        assert(vorseRaider.toString().equals(deckFileReader.readCardsFromTextFile().get(0).toString()));
    }

}

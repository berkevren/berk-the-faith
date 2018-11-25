import berkTheFaith.DeckFileReader;
import org.junit.Before;
import org.junit.Test;
import berkTheFaith.card.*;

import java.io.IOException;

public class DeckFileReaderTest {

    Card vorseRaider;
    @Before
    public void init() {
        vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "DARK", "Beast-Warrior", 1900,1200, 4);
    }

    @Test
    public void deckFromVorseRaiderOnlyTest() {
        DeckFileReader deckFileReader = new DeckFileReader("/testDecks/deckOnlyVorseRaider.txt");
        assert(vorseRaider.toString().equals(deckFileReader.readCardsFromTextFile().get(0).toString()));
    }

    @Test
    public void getVorseRaiderCardFromAPI() throws IOException {
        DeckFileReader deckFileReader = new DeckFileReader("/testDecks/deckOnlyVorseRaider.txt");
        assert(vorseRaider.toString().equals(deckFileReader.createCardFromAPI("Vorse Raider").toString()));
    }

}

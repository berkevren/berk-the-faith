import berkTheFaith.CardFileReader;
import org.junit.Before;
import org.junit.Test;
import berkTheFaith.card.*;

import java.io.IOException;

public class CardFileReaderTest {

    Card vorseRaider;
    @Before
    public void init() {
        vorseRaider = new NormalMonsterCard("Vorse Raider", "This wicked Beast-Warrior does every horrid " +
                "thing imaginable, and loves it! His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "DARK", "Beast-Warrior", 1900,1200, 4);
    }

    @Test
    public void deckFromVorseRaiderOnlyTest() {
        CardFileReader cardFileReader = new CardFileReader("Vorse Raider");
        assert(vorseRaider.toString().equals(cardFileReader.readSingleCardFromTextFile().toString()));
    }

    @Test
    public void getVorseRaiderCardFromAPI() throws IOException {
        CardFileReader cardFileReader = new CardFileReader();
        assert(vorseRaider.toString().equals(cardFileReader.createCardFromAPI("Vorse Raider").toString()));
    }

    @Test
    public void writeVorseRaiderToTxtFile() throws IOException {
        CardFileReader cardFileReader = new CardFileReader();
        cardFileReader.createCardFromAPI("Vorse Raider");
        CardFileReader cardFileReaderToReadFromAPITextFile = new CardFileReader("Vorse Raider");
        assert(vorseRaider.toString().equals(cardFileReaderToReadFromAPITextFile.readSingleCardFromTextFile().toString()));
    }

}

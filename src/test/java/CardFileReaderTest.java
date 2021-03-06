import berkTheFaith.cardCreation.CardFileReader;
import org.junit.Before;
import org.junit.Test;
import berkTheFaith.card.*;

import java.io.File;
import java.io.IOException;

public class CardFileReaderTest {

    Card vorseRaider;
    @Before
    public void init() {
        vorseRaider = new NormalMonsterCard(14898066, "Vorse Raider",
                "This wicked Beast-Warrior does every horrid thing imaginable, and loves it! " +
                        "His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "DARK", "Beast-Warrior", 1900, 1200, 4);
    }

    @Test
    public void deckFromVorseRaiderOnlyTest() {
        CardFileReader cardFileReader = new CardFileReader("Vorse Raider");
        assert(vorseRaider.toString().equals(cardFileReader.readSingleCard().toString()));
    }

    @Test
    public void writeVorseRaiderToTxtFile() {
        CardFileReader cardFileReader = new CardFileReader("Vorse Raider");
        assert(vorseRaider.toString().equals(cardFileReader.readSingleCard().toString()));
    }

    @Test
    public void writeCardPictureFromAPItoImageFile() throws IOException {
        CardFileReader cardFileReader = new CardFileReader("Vorse Raider");
        cardFileReader.writeCardPictureFromAPItoImageFile(14898066);
        File file = new File("cardPictures/Vorse Raider.jpg");
        assert(file.isFile());
    }

}

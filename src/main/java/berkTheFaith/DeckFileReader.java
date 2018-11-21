package berkTheFaith;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import berkTheFaith.card.*;
import berkTheFaith.cardCreation.CardCreator;

public class DeckFileReader {

    private String deckTextFileAddress, nextLine;
    private ArrayList<Card> allCardsInFile = new ArrayList<Card>();
    private CardCreator cardCreator;

    public DeckFileReader(String deckTextFileAddress) {
        this.deckTextFileAddress = System.getProperty("user.dir") + deckTextFileAddress;
    }

    public ArrayList<Card> readCardsFromTextFile() {

        if (!(this.containsAtLeastOneLine()))
            return new ArrayList<Card>();

        try (BufferedReader br = new BufferedReader(new FileReader(deckTextFileAddress))) {
            while (br.readLine() != null)
                allCardsInFile.add(createCard(br));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allCardsInFile;
    }

    public boolean containsAtLeastOneLine() {

        try (BufferedReader br = new BufferedReader(new FileReader(deckTextFileAddress))) {
            nextLine = br.readLine();

            if (nextLine == null) {
                return false;
            }
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Card createCard(BufferedReader br) {

        cardCreator = new CardCreator(br);

        try { return cardCreator.createCard(); }
        catch (IOException e) { e.printStackTrace(); }
        return null;
    }
}

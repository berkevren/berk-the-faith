package berkTheFaith.cardCreation;

import berkTheFaith.card.Card;

import java.io.*;
import java.util.ArrayList;

public class DeckFileReader {

    private String deckTextFileAddress;
    private ArrayList<String> namesOfCardsInDeck;
    private ArrayList<Card> deck;
    CardFileReader cardFileReader;

    public DeckFileReader(String deckName) {
        this.deck = new ArrayList<Card>();
        this.deckTextFileAddress = System.getProperty("user.dir") + "/decks/" + deckName + ".txt";
        this.cardFileReader = new CardFileReader();
        readNamesOfCardsOfDeckFromTxtFile();
    }

    public void readNamesOfCardsOfDeckFromTxtFile() {
        namesOfCardsInDeck = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(deckTextFileAddress))) {
            while (br.readLine() != null)
                namesOfCardsInDeck.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Card> readDeckFromTextFile() {

        for (String cardName: namesOfCardsInDeck) {
            cardFileReader.setCardNameAndTextFileAddress(cardName);
            deck.add(cardFileReader.readSingleCard());
        }

        return deck;
    }

    public ArrayList<String> getNamesOfCardsInDeck() {
        return namesOfCardsInDeck;
    }

    public void writeCardToDeckFile(String cardName) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(deckTextFileAddress, true))) {
            bufferedWriter.write("\n\n");
            bufferedWriter.write(cardName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

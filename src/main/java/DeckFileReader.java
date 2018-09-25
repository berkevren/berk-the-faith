import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DeckFileReader {

    private String deckTextFileAddress, nextLine, cardName, cardText;
    private ArrayList<Card> allCardsInFile = new ArrayList<Card>();

    public DeckFileReader(String deckTextFileAddress) {
        this.deckTextFileAddress = deckTextFileAddress;
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

    public Card createCard(BufferedReader br) throws IOException {

        if (br.readLine().equals("Monster")) {
            return createMonsterCard(br);
        }
        return null;
    }

    public Card createMonsterCard(BufferedReader br) throws IOException {

        if (br.readLine().equals("Normal")) {
            return createNormalMonsterCard(br);
        }
        return null;
    }

    public Card createNormalMonsterCard(BufferedReader br) throws IOException {

        cardName = br.readLine();
        String cardAttribute = br.readLine();
        String cardMonsterType = br.readLine();
        cardText = br.readLine();
        int attackPoints = Integer.parseInt(br.readLine());
        int defencePoints = Integer.parseInt(br.readLine());
        int level = Integer.parseInt(br.readLine());

        Card normalMonsterCard = new NormalMonsterCard(cardName, cardText, cardAttribute,
                cardMonsterType, attackPoints, defencePoints, level);

        return normalMonsterCard;

    }

}

package berkTheFaith;

import berkTheFaith.card.Card;
import berkTheFaith.cardCreation.CardCreator;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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
                allCardsInFile.add(createCardFromTextFile(br));
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

    public Card createCardFromTextFile(BufferedReader br) {

        cardCreator = new CardCreator(br);
        return cardCreator.createCardFromBufferedReader();
    }

    public Card createCardFromAPI(String cardName) throws IOException {

        cardName = cardName.replaceAll(" ", "%20"); // fix space character
        URL url = new URL("https://db.ygoprodeck.com/api/cardinfo.php?name=".concat(cardName));
        String returnString = getCardStringFromURL(url);

        JSONObject jsonObject = new JSONObject(returnString);
        CardCreator cardCreator = new CardCreator(jsonObject);

        return cardCreator.createCardFromJSON();

    }

    public String getCardStringFromURL(URL url) {

        String response = "";

        try {

            HttpURLConnection connection = ((HttpURLConnection)url.openConnection());
            connection.addRequestProperty("User-Agent", "Mozilla/4.0");
            InputStream input = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String theEntireMessage;

            while ((theEntireMessage =reader.readLine()) != null)
                response = theEntireMessage.concat(theEntireMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // delete [ at the start and ] at the end
        return response.substring(1, response.length()-1);
    }

}

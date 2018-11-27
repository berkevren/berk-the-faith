package berkTheFaith.cardCreation;

import berkTheFaith.card.Card;
import berkTheFaith.card.MonsterCard;
import berkTheFaith.cardCreation.CardCreator;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CardFileReader {

    private String cardTextFileAddress, nextLine;
    private CardCreator cardCreator;

    public CardFileReader(String cardName) {
        this.cardTextFileAddress = System.getProperty("user.dir") + "/cards/" + cardName + ".txt";
    }

    public CardFileReader() { }

    public Card readSingleCardFromTextFile() {

        if (!(this.containsAtLeastOneLine()))
            return new MonsterCard();

        try (BufferedReader br = new BufferedReader(new FileReader(cardTextFileAddress))) {
            while (br.readLine() != null)
                return createCardFromTextFile(br);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new MonsterCard();
    }

    public boolean containsAtLeastOneLine() {

        try (BufferedReader br = new BufferedReader(new FileReader(cardTextFileAddress))) {
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

        writeCardFromAPIToTextFile(cardCreator.createCardFromJSON(), cardName);

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

    public boolean writeCardFromAPIToTextFile(Card card, String cardName) {

        cardName = cardName.replaceAll("%20", " "); // fix space character

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                    System.getProperty("user.dir") + "/cards/" + cardName + ".txt"));
            bufferedWriter.append(card.toReadableByDeckFileReaderForm());
            bufferedWriter.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void setCardTextFileAddress(String cardName) {
        this.cardTextFileAddress = System.getProperty("user.dir") + "/cards/" + cardName + ".txt";
    }
}

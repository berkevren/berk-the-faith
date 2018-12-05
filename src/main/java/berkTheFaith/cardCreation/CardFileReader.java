package berkTheFaith.cardCreation;

import berkTheFaith.card.Card;
import berkTheFaith.card.MonsterCard;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CardFileReader {

    private String cardName, cardTextFileAddress;
    private CardCreator cardCreator;

    public CardFileReader(String cardName) {
        this.cardName = cardName;
        this.cardTextFileAddress = System.getProperty("user.dir") + "/cards/" + cardName + ".txt";
    }

    public CardFileReader() { }

    public Card readSingleCardFromTextFile() {

        try (BufferedReader br = new BufferedReader(new FileReader(cardTextFileAddress))) {
            if (br.readLine() != null)
                return createCardFromTextFile(br);
        } catch (IOException e) {
            return createCardFromAPI();
        }

        return new MonsterCard();
    }

    public Card createCardFromTextFile(BufferedReader br) {

        cardCreator = new CardCreator(br);
        return cardCreator.createCardFromBufferedReader();
    }

    public Card createCardFromAPI() {

        cardName = cardName.replaceAll(" ", "%20"); // fix space character

        try {
            URL url = new URL("https://db.ygoprodeck.com/api/cardinfo.php?name=".concat(cardName));
            String returnString = getCardStringFromURL(url);

            JSONObject jsonObject = new JSONObject(returnString);
            cardCreator = new CardCreator(jsonObject);

            writeCardFromAPIToTextFile(cardCreator.createCardFromJSON());

            return cardCreator.createCardFromJSON();
        }
        catch (IOException e) { e.printStackTrace(); }

        return new MonsterCard();

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

    public void writeCardFromAPIToTextFile(Card card) throws IOException {

        cardName = cardName.replaceAll("%20", " "); // fix space character

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                System.getProperty("user.dir") + "/cards/" + cardName + ".txt"));
        bufferedWriter.append(card.toReadableByDeckFileReaderForm());
        bufferedWriter.close();
    }

    public void setCardNameAndTextFileAddress(String cardName) {
        this.cardName = cardName;
        this.cardTextFileAddress = System.getProperty("user.dir") + "/cards/" + cardName + ".txt";
    }
}

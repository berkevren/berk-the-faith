package berkTheFaith.cardCreation;

import berkTheFaith.card.Card;
import berkTheFaith.card.CardTypes;
import berkTheFaith.card.MonsterCard;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

public class CardCreator {

    private JSONObject jsonObjectWithCardInfo;
    private BufferedReader br;

    public CardCreator(JSONObject jsonObjectWithCardInfo) {
        this.jsonObjectWithCardInfo = jsonObjectWithCardInfo;
    }

    public CardCreator(BufferedReader br) {
        this.br = br;
    }

    public Card createCardFromJSON() {

        if (jsonObjectWithCardInfo.getString("type").equals("Normal Monster")) {
            return createNormalMonsterCardFromJSON();
        }


        return null;
    }

    public Card createNormalMonsterCardFromJSON() {

        String cardName = jsonObjectWithCardInfo.getString("name");
        String cardText = jsonObjectWithCardInfo.getString("desc");
        CardTypes cardType = CardTypes.NORMALMONSTER;
        String attribute = jsonObjectWithCardInfo.getString("attribute");
        String monsterType = jsonObjectWithCardInfo.getString("race");
        int attackPoints = Integer.valueOf(jsonObjectWithCardInfo.getString("atk"));
        int defencePoints = Integer.valueOf(jsonObjectWithCardInfo.getString("def"));
        int level = Integer.valueOf(jsonObjectWithCardInfo.getString("level"));

        MonsterCard card = new MonsterCard(cardName, cardText, cardType, attribute,
                monsterType, attackPoints, defencePoints, level);

        return card;
    }

    public Card createCardFromBufferedReader() {

        try {
            if (br.readLine().equals("Normal Monster")) {
                return createNormalMonsterCardFromBufferedReader();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Card createNormalMonsterCardFromBufferedReader() throws IOException{

        String cardName = br.readLine();
        String cardText = br.readLine();
        CardTypes cardType = CardTypes.NORMALMONSTER;
        String attribute = br.readLine();
        String monsterType = br.readLine();
        int attackPoints = Integer.valueOf(br.readLine());
        int defencePoints = Integer.valueOf(br.readLine());
        int level = Integer.valueOf(br.readLine());

        MonsterCard card = new MonsterCard(cardName, cardText, cardType, attribute,
                monsterType, attackPoints, defencePoints, level);

        return card;
    }
}

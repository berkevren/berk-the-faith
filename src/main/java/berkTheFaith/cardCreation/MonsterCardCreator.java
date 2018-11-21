package berkTheFaith.cardCreation;

import berkTheFaith.card.*;

import java.io.BufferedReader;
import java.io.IOException;

public class MonsterCardCreator extends CardCreator {

    private String cardType;
    private String cardName, cardText, cardAttribute, cardMonsterType;
    private CardTypes monsterType;

    public MonsterCardCreator(BufferedReader bufferedReader){
        super(bufferedReader);
    };

    public Card createMonsterCard() throws IOException {

        cardType = bufferedReader.readLine();

        if (cardType.equals("Normal"))
            return createNormalMonsterCard();

        return null;

    }

    public Card createNormalMonsterCard() throws IOException {

        cardName = bufferedReader.readLine();
        cardAttribute = bufferedReader.readLine();
        cardMonsterType = bufferedReader.readLine();
        cardText = bufferedReader.readLine();
        int attackPoints = Integer.parseInt(bufferedReader.readLine());
        int defencePoints = Integer.parseInt(bufferedReader.readLine());
        int level = Integer.parseInt(bufferedReader.readLine());
        monsterType = CardTypes.NORMALMONSTER;

        NormalMonsterCard normalMonsterCard = new NormalMonsterCard(cardName, cardText, monsterType,
                cardAttribute, cardMonsterType, attackPoints, defencePoints, level);

        return normalMonsterCard;

    }
}

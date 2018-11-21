package berkTheFaith.cardCreation;

import berkTheFaith.card.Card;

import java.io.BufferedReader;
import java.io.IOException;

public class CardCreator {

    protected BufferedReader bufferedReader;

    public CardCreator(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public Card createCard() throws IOException {
        String cardType = bufferedReader.readLine();
        if (cardType.equals("Monster")) {
            MonsterCardCreator monsterCardCreator = new MonsterCardCreator(bufferedReader);
            return monsterCardCreator.createMonsterCard();
        }
        if (cardType.equals("Spell")){
            SpellCardCreator spellCardCreator = new SpellCardCreator(bufferedReader);
            return spellCardCreator.createSpellCard();
        }
        return null;
    }

}

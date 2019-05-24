package berkTheFaith.card;

import berkTheFaith.duel.Player;

import java.util.ArrayList;

public class CardEffect {

    public boolean effectCondition;


    public CardEffect() {
        effectCondition = false;
    }

    public MonsterCard targetMonster(ArrayList<MonsterCard> cards) {
        System.out.println("Enter the index of the card you wish to target.");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i).cardName);
        }

        int target = 0;
        return cards.get(target);
    }

    public boolean effectConditionMet() {
        return effectCondition;
    }

    public void activateMonsterReborn(Player player, Player opponent) {
        assert(player.canSpecialSummonMonsterFromEitherGraveyard(opponent));
        ArrayList<MonsterCard> cards = player.getMonstersInPlayerGraveyard();
        cards.addAll(opponent.getMonstersInPlayerGraveyard());

        MonsterCard monsterToSpecialSummon = targetMonster(cards);
        player.specialSummonMonsterToField(monsterToSpecialSummon);
    }
}

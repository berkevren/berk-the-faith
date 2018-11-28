package berkTheFaith.cardZone;

public class MonsterCardZone extends CardZone {

    private CardPosition cardPosition;

    public MonsterCardZone(int zoneNumber) {
        super(zoneNumber);
    }

    public void summonMonsterInAttackPosition() {
        super.putCardOnCardZone(cardOnTheZone);
        cardPosition = CardPosition.FACE_UP_ATTACK;
    }

    public void setMonsterInDefensePosition() {
        super.putCardOnCardZone(cardOnTheZone);
        cardPosition = CardPosition.FACE_DOWN_DEFENCE;
    }

    public void switchMonsterPosition() {
        if (cardPosition == CardPosition.FACE_UP_ATTACK)
            cardPosition = CardPosition.FACE_UP_DEFENCE;
        else
            cardPosition = CardPosition.FACE_UP_ATTACK;
    }

    public CardPosition getCardPosition() {
        return cardPosition;
    }
}

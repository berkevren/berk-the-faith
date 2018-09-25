public class NormalMonsterCard extends MonsterCard {

    public NormalMonsterCard(String cardName, String cardText, String attribute, String monsterType,
                             int attackPoints, int defencePoints, int level) {
        this.cardName = cardName;
        this.cardText = cardText;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.level = level;
        this.attribute = attribute;
        this.monsterType = monsterType;

        this.cardType = CardTypes.NORMALMONSTER;
    }

}

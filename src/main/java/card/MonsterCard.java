package card;

public class MonsterCard extends Card {

    protected int attackPoints, defencePoints, level;
    protected String attribute, monsterType;

    public MonsterCard(String cardName, String cardText, CardTypes cardType,
                       String attribute, String monsterType, int attackPoints,
                       int defencePoints, int level) {
        super(cardName, cardText, cardType);
        this.cardName = cardName;
        this.cardText = cardText;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.level = level;
        this.attribute = attribute;
        this.monsterType = monsterType;
    }

    public int getNumberOfRequiredTributes() {
        if (level <= 4)
            return 0;
        if (level <= 6)
            return 1;
        return 2;
    }

    @Override
    public String toString() {

        String result = "Name: " + cardName + "\nCard Type: " + cardType + "\nAttribute: " + attribute +
                "\nMonster Type: " + monsterType + "\nText: " + cardText + "\nAttack Points: " + attackPoints +
                "\nDefence Points: " + defencePoints + "\nLevel: " + level;
        return result;
    }

}

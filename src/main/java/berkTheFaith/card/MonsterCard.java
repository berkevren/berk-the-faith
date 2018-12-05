package berkTheFaith.card;

public class MonsterCard extends Card {

    protected int attackPoints, defencePoints, level;
    protected String attribute, monsterType;

    protected int numberOfRequiredTributes;

    public MonsterCard() { }

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

        setNumberOfRequiredTributes();
    }

    public void setNumberOfRequiredTributes() {
        if (level <= 4)
            numberOfRequiredTributes = 0;
        if (level <= 6)
            numberOfRequiredTributes = 1;
        numberOfRequiredTributes = 2;
    }

    @Override
    public String toString() {

        String result = "Name: " + cardName + "\nCard Type: " + cardType + "\nAttribute: " + attribute +
                "\nMonster Type: " + monsterType + "\nText: " + cardText + "\nAttack Points: " + attackPoints +
                "\nDefence Points: " + defencePoints + "\nLevel: " + level;
        return result;
    }

    public String toReadableByDeckFileReaderForm() {
        String readableByDeckFileReaderForm = "\n" + attribute + "\n" + monsterType + "\n" + attackPoints +
                "\n" + defencePoints + "\n" + level;
        return super.toReadableByDeckFileReaderForm() + readableByDeckFileReaderForm;
    }

    public void changeAttackPoints(int change) {
        this.attackPoints += change;
    }

    public void changeDefencePoints(int change) {
        this.defencePoints += change;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefencePoints() {
        return defencePoints;
    }
}

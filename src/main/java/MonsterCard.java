public class MonsterCard extends Card {

    protected int attackPoints, defencePoints, level;
    protected String attribute, monsterType;


    public String toString() {

        String result = "Name: " + cardName + "\nCard Type: " + cardType + "\nAttribute: " + attribute +
                "\nMonster Type: " + monsterType + "\nText: " + cardText + "\nAttack Points: " + attackPoints +
                "\nDefence Points: " + defencePoints + "\nLevel: " + level;
        return result;
    }

}

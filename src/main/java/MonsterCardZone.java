public class MonsterCardZone extends CardZone {

    private int zoneNumber;
    private boolean occupied;
    private Card monsterCard;

    public MonsterCardZone(int zoneNumber) {
        this.zoneNumber = zoneNumber;
        this.occupied = false;
    }

    void sendCardFromZoneToGraveyard() {

    }
}

import berkTheFaith.card.MonsterCard;
import berkTheFaith.cardCreation.CardFileReader;
import berkTheFaith.cardZone.Graveyard;
import berkTheFaith.cardZone.MonsterCardZone;
import berkTheFaith.duel.MonsterBattler;
import org.junit.Before;
import org.junit.Test;

public class MonsterBattlerTest {

    CardFileReader cardFileReader;
    MonsterCard blueEyesWhiteDragon, darkMagician;
    MonsterCardZone blueEyesZone, darkMagicianZone;
    MonsterBattler monsterBattler;

    @Before
    public void init() {
        cardFileReader = new CardFileReader("Blue-Eyes White Dragon");
        blueEyesWhiteDragon = (MonsterCard)cardFileReader.readSingleCard();
        cardFileReader.setCardNameAndTextFileAddress("Dark Magician");
        darkMagician = (MonsterCard)cardFileReader.readSingleCard();

        blueEyesZone = new MonsterCardZone(1);
        blueEyesZone.summonMonsterInAttackPosition(blueEyesWhiteDragon);

        darkMagicianZone = new MonsterCardZone(1);
        darkMagicianZone.summonMonsterInAttackPosition(darkMagician);
    }

    @Test
    public void calculateLifePointDamageTest() {
        monsterBattler = new MonsterBattler(blueEyesZone, darkMagicianZone);
        assert(monsterBattler.calculateLifePointDamage() == 500);

        monsterBattler = new MonsterBattler(darkMagicianZone, blueEyesZone);
        assert(monsterBattler.calculateLifePointDamage() == -500);

        darkMagician.changeAttackPoints(500);
        assert(monsterBattler.calculateLifePointDamage() == 0);
    }

    @Test
    public void battleMonstersTest() {
        monsterBattler = new MonsterBattler(blueEyesZone, darkMagicianZone);
        monsterBattler.battleMonsters();
        assert(!monsterBattler.attackingPonsterIsDestroyed);
        assert(monsterBattler.defendingMonsterIsDestroyed);
        
        monsterBattler = new MonsterBattler(darkMagicianZone, blueEyesZone);
        monsterBattler.battleMonsters();
        assert(monsterBattler.attackingPonsterIsDestroyed);
        assert(!monsterBattler.defendingMonsterIsDestroyed);

        darkMagician.changeAttackPoints(500);
        monsterBattler = new MonsterBattler(darkMagicianZone, blueEyesZone);
        monsterBattler.battleMonsters();
        assert(monsterBattler.attackingPonsterIsDestroyed);
        assert(monsterBattler.defendingMonsterIsDestroyed);

        darkMagician.changeAttackPoints(-500);
        blueEyesZone.switchMonsterPosition();
        monsterBattler = new MonsterBattler(darkMagicianZone, blueEyesZone);
        monsterBattler.battleMonsters();
        assert(!monsterBattler.attackingPonsterIsDestroyed);
        assert(!monsterBattler.defendingMonsterIsDestroyed);
    }

    @Test
    public void sendMonstersToGraveyardTest() {
        monsterBattler = new MonsterBattler(blueEyesZone, darkMagicianZone);
        Graveyard graveyard = new Graveyard();
        monsterBattler.battleMonsters();
        monsterBattler.sendMonstersToGraveyard(graveyard);

        assert(darkMagician.toString().equals
                (graveyard.getGraveyardPile().revealTopCard().toString()));
    }
}

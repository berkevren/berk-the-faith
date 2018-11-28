package berkTheFaith.duel;

import berkTheFaith.card.MonsterCard;
import berkTheFaith.cardZone.CardPosition;
import berkTheFaith.cardZone.MonsterCardZone;

public class MonsterBattler {

    private MonsterCard attackingMonster, defendingMonster;
    private CardPosition attackingMonsterPosition, defendingMonsterPosition;
    public boolean attackingPonsterIsDestroyed, defendingMonsterIsDestroyed;

    public MonsterBattler(MonsterCardZone attackingMonsterZone, MonsterCardZone defendingMonsterZone) {
        attackingMonster = (MonsterCard)attackingMonsterZone.getCardOnTheZone();
        defendingMonster = (MonsterCard)defendingMonsterZone.getCardOnTheZone();
        attackingMonsterPosition = CardPosition.FACE_UP_ATTACK;
        defendingMonsterPosition = defendingMonsterZone.getCardPosition();
        attackingPonsterIsDestroyed = false;
        defendingMonsterIsDestroyed = false;
    }

    public int calculateLifePointDamage() {

        if (defendingMonsterPosition == CardPosition.FACE_UP_ATTACK) {
            defendingMonsterIsDestroyed = attackingMonster.getAttackPoints() >= defendingMonster.getAttackPoints();
            attackingPonsterIsDestroyed = attackingMonster.getAttackPoints() <= defendingMonster.getAttackPoints();
            return Math.abs(attackingMonster.getAttackPoints() - defendingMonster.getAttackPoints());
        }
        else {
            attackingPonsterIsDestroyed = false;
            defendingMonsterIsDestroyed = attackingMonster.getAttackPoints() > defendingMonster.getDefencePoints();
            return Math.abs(attackingMonster.getAttackPoints() - defendingMonster.getDefencePoints());
        }
    }
}

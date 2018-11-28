package berkTheFaith.duel;

import berkTheFaith.cardZone.FusionCardZone;
import berkTheFaith.cardZone.Graveyard;
import berkTheFaith.cardZone.MonsterCardZone;
import berkTheFaith.cardZone.SpellAndTrapCardZone;

public class DuelMat {

    private MonsterCardZone[] monsterCardZones;
    private SpellAndTrapCardZone[] spellAndTrapCardZones;
    private Graveyard graveyard;
    private FusionCardZone fusionCardZone;

    public DuelMat() {
        monsterCardZones = new MonsterCardZone[]{new MonsterCardZone(0), new MonsterCardZone(1),
        new MonsterCardZone(2), new MonsterCardZone(3), new MonsterCardZone(4)};
        spellAndTrapCardZones = new SpellAndTrapCardZone[]{new SpellAndTrapCardZone(0),
                new SpellAndTrapCardZone(1), new SpellAndTrapCardZone(2),
                new SpellAndTrapCardZone(3), new SpellAndTrapCardZone(4)};
        graveyard = new Graveyard();
        fusionCardZone = new FusionCardZone();
    }
}

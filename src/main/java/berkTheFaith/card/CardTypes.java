package berkTheFaith.card;

public enum CardTypes {

    NORMALMONSTER, EFFECTMONSTER, FLIPEFFECTMONSTER, FUSIONMONSTER,
    NORMALSPELL, EQUIPSPELL, CONTINUOUSSPELL, QUICKPLAYSPELL,
    NORMALTRAP;

    public String toString(CardTypes cardType) {
        switch (cardType) {
            case NORMALMONSTER: return "Normal Monster";
            case EFFECTMONSTER: return "Effect Monster";
            case FLIPEFFECTMONSTER: return "Flip Effect Monster";
            case FUSIONMONSTER: return "Fusion Monster";
            case NORMALSPELL: return "Normal Spell";
            case EQUIPSPELL: return "Equip Spell";
            case CONTINUOUSSPELL: return "Continuous Spell";
            case QUICKPLAYSPELL: return "Quickplay Spell";
            case NORMALTRAP: return "Normal Trap";
            default: return "Invalid Type";
        }
    }

}

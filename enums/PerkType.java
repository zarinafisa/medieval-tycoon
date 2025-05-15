package enums;

public enum PerkType {
    ELEGAN, CHARMING, ACTIVE;

    public String getDisplayName() {
        switch (this) {
            case ELEGAN:
                return "Elegan";
            case CHARMING:
                return "Charming";
            case ACTIVE:
                return "Active";
            default:
                return "Tidak valid";
        }
    }

    public boolean canConvertTo(PerkType target) {

        if (this == ELEGAN && target == CHARMING) {
            return true;
        } else if (this == CHARMING && target == ACTIVE) {
            return true;
        } else if (this == ACTIVE && target == ELEGAN) {
            return true;
        }

        return false;
    }
}

package enums;

public enum KendaraanLevel {
    LEVEL_1(1, KendaraanType.GEROBAK, 5, 0, 3),
    LEVEL_2(2, KendaraanType.GEROBAK, 8, 250_000, 3),
    LEVEL_3(3, KendaraanType.MOTOR, 11, 450_000, 7),
    LEVEL_4(4, KendaraanType.MOTOR, 14, 350_000, 7),
    LEVEL_5(5, KendaraanType.MOTOR, 17, 350_000, 11),
    LEVEL_6(6, KendaraanType.MOTOR, 20, 350_000, 11),
    LEVEL_7(7, KendaraanType.MOTOR, 23, 350_000, 16),
    LEVEL_8(8, KendaraanType.PICKUP, 28, 600_000, 22),
    LEVEL_9(9, KendaraanType.PICKUP, 31, 400_000, 22),
    LEVEL_10(10, KendaraanType.PICKUP, 34, 400_000, 26),
    LEVEL_11(11, KendaraanType.PICKUP, 37, 400_000, 26),
    LEVEL_12(12, KendaraanType.PICKUP, 40, 400_000, 31),
    LEVEL_13(13, KendaraanType.PICKUP, 43, 400_000, 31),
    LEVEL_14(14, KendaraanType.PICKUP, 46, 400_000, 37),
    LEVEL_15(15, KendaraanType.PICKUP, 50, 400_000, 37);

    private final int level;
    private final KendaraanType type;
    private final int kapasitas;
    private final int biayaUpgrade;
    private final int performa;

    KendaraanLevel(int level, KendaraanType type, int kapasitas, int biayaUpgrade, int performa) {
        this.level = level;
        this.type = type;
        this.kapasitas = kapasitas;
        this.biayaUpgrade = biayaUpgrade;
        this.performa = performa;
    }

    public int getLevel() {
        return level;
    }

    public KendaraanType getType() {
        return type;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getBiayaUpgrade() {
        return biayaUpgrade;
    }

    public int getPerforma() {
        return performa;
    }

    public static KendaraanLevel getByLevel(int level) {
        for (KendaraanLevel k : values()) {
            if (k.getLevel() == level) {
                return k;
            }
        }
        throw new IllegalArgumentException("Level tidak ditemukan: " + level);
    }
}

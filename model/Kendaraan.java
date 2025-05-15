package model;

import interfaces.Showable;

public abstract class Kendaraan implements Showable {

    protected int kapasitas;
    protected int level;
    protected int biayaUpgrade;
    protected int performa;

    public Kendaraan(int kapasitas, int level, int biayaUpgrade, int performa) {

        this.kapasitas = kapasitas;
        this.level = level;
        this.biayaUpgrade = biayaUpgrade;
        this.performa = performa;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getLevel() {
        return level;
    }

    public int getBiayaUpgrade() {
        return biayaUpgrade;
    }

    public int getPerforma() {
        return performa;
    }

    public abstract Kendaraan upgradeLevel();

    @Override
    public abstract void tampilkanDetail();
}

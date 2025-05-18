package model;

import enums.*;
import interfaces.Showable;

public abstract class Kendaraan implements Showable {

    protected KendaraanLevel levelSekarang;

    public Kendaraan(KendaraanLevel levelAwal) {
        this.levelSekarang = levelAwal;
    }

    public int getKapasitas() {
        return levelSekarang.getKapasitas();
    }

    public int getLevel() {
        return levelSekarang.getLevel();
    }

    public int getBiayaUpgrade() {
        return levelSekarang.getBiayaUpgrade();
    }

    public int getPerforma() {
        return levelSekarang.getPerforma();
    }

    public boolean isMaxLevel() {
        return levelSekarang.getLevel() == KendaraanLevel.LEVEL_15.getLevel();
    }

   public static Kendaraan buatKendaraan(KendaraanLevel level) {
    KendaraanType type = level.getType();
    switch (type) {
        case GEROBAK:
            return new Gerobak(level);
        case MOTOR:
            return new Motor(level);
        case PICKUP:
            return new Pickup(level);
        default:
            throw new IllegalArgumentException("Tipe kendaraan tidak dikenali.");
    }
}


    public abstract Kendaraan upgradeLevel();

    @Override
    public abstract void tampilkanDetail();
} 

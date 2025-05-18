package model;

import enums.KendaraanLevel;

public class Gerobak extends Kendaraan {

    public Gerobak(KendaraanLevel levelAwal) {
        super(levelAwal);
        if (levelAwal.getType() != enums.KendaraanType.GEROBAK) {
            throw new IllegalArgumentException("Level bukan untuk Gerobak");
        }
    }

    @Override
    public Kendaraan upgradeLevel() {

        KendaraanLevel nextLevel = KendaraanLevel.getByLevel(getLevel() + 1);

        if (nextLevel.getType() != enums.KendaraanType.GEROBAK) {
            return Kendaraan.buatKendaraan(nextLevel);
        }

        return new Gerobak(nextLevel);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Jenis: Gerobak");
        System.out.println("Level: " + getLevel());
        System.out.println("Kapasitas: " + getKapasitas());
        System.out.println("Performa: " + getPerforma());
        System.out.println("Biaya Upgrade: Rp " + getBiayaUpgrade());
    }
}

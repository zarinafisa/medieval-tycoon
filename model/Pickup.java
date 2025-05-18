package model;

import enums.KendaraanLevel;

public class Pickup extends Kendaraan {

    public Pickup(KendaraanLevel levelAwal) {
        super(levelAwal);
        if (levelAwal.getType() != enums.KendaraanType.PICKUP) {
            throw new IllegalArgumentException("Level bukan untuk Motor");
        }
    }

    @Override
    public Kendaraan upgradeLevel() {

        if (isMaxLevel()) {
            throw new IllegalStateException("Kendaraan sudah pada level maksimum");
        } else {
            KendaraanLevel nextLevel = KendaraanLevel.getByLevel(getLevel() + 1);

            if (nextLevel.getType() != enums.KendaraanType.PICKUP) {
                return Kendaraan.buatKendaraan(nextLevel);
            }

            return new Pickup(nextLevel);
        }
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Jenis: Pickup");
        System.out.println("Level: " + getLevel());
        System.out.println("Kapasitas: " + getKapasitas());
        System.out.println("Performa: " + getPerforma());
        System.out.println("Biaya Upgrade: Rp " + getBiayaUpgrade());
    }
}

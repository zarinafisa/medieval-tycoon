package model;

import enums.KendaraanLevel;

public class Motor extends Kendaraan {

    public Motor(KendaraanLevel levelAwal) {
        super(levelAwal);
        if (levelAwal.getType() != enums.KendaraanType.MOTOR) {
            throw new IllegalArgumentException("Level bukan untuk Motor");
        }
    }

    @Override
    public Kendaraan upgradeLevel() {

        KendaraanLevel nextLevel = KendaraanLevel.getByLevel(getLevel()+1);

        if (nextLevel.getType() != enums.KendaraanType.MOTOR) {
            return Kendaraan.buatKendaraan(nextLevel);
        }

        return new Motor(nextLevel);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Jenis: Motor");
        System.out.println("Level: " + getLevel());
        System.out.println("Kapasitas: " + getKapasitas());
        System.out.println("Performa: " + getPerforma());
        System.out.println("Biaya Upgrade: Rp " + getBiayaUpgrade());
    }
} 

package model;

import interfaces.Upgrade;
import interfaces.Showable;
import enums.PerkType;

public abstract class Perk implements Upgrade, Showable {

    protected String nama;
    protected String deskripsi;
    protected boolean isActive;
    protected int level;
    protected double kesaktian;
    protected int biayaUpgrade;
    protected PerkType type;

    public Perk(String nama, String deskripsi, PerkType type) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.type = type;
        this.isActive = false;
        this.level = 0;
        this.kesaktian = 0;
        this.biayaUpgrade = 0;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getType() {
        return type.getDisplayName();
    }

    public abstract double getPerkEffect();

    public void activate() {
        this.isActive = true;
    }

    public void deactive() {
        this.isActive = false;
    }

    public void resetUpgrade() {
        this.level = 0;
        this.kesaktian = 0;
    }

    public boolean getActive() {
        return isActive;
    }

    public double getKesaktian() {
        return kesaktian;
    }

    @Override
    public abstract boolean upgradeLevel(int biaya);

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public abstract void tampilkanDetail();
}

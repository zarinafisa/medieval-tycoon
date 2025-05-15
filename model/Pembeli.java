package model;

import interfaces.Menawar;

public abstract class Pembeli implements Menawar {

    protected String kategori;
    protected double tawarMultiplier;
    protected double maxTawaran;

    public Pembeli(String kategori, double tawarMultiplier) {
        this.kategori = kategori;
        this.tawarMultiplier = tawarMultiplier;
        this.maxTawaran = 0;
    }

    public double getMultiplier() {
        return tawarMultiplier;
    }

    public String getKategori() {
        return kategori;
    }

    public double getMaxTawaran() {
        return maxTawaran;
    }

    public int generateOffer(int hargaJual) {
        this.maxTawaran = tawarMultiplier * hargaJual;
        return (int) maxTawaran;
    }

    @Override
    public abstract int tawarHarga(int hargaAwal);

    @Override
    public abstract boolean putuskanTransaksi(int hargaFinal);
}

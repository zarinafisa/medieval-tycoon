package model;

import interfaces.Showable;

public abstract class Item implements Showable {

    protected String nama;
    protected String deskripsi;
    protected int harga;

    public Item(String nama, String deskripsi, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public abstract void tampilkanDetail();
}

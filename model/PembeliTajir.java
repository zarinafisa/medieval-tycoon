package model;

public class PembeliTajir extends Pembeli {
    public PembeliTajir() {
        super("Tajir", 0.9); 
    }

    @Override
    public int tawarHarga(int hargaAwal) {
        if (Math.random() < 0.5) {
            return hargaAwal;
        }
        return generateOffer(hargaAwal); 
    }

    @Override
    public boolean putuskanTransaksi(int hargaFinal) {
        return true;
    }
}

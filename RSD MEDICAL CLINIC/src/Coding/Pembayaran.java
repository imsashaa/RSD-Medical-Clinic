package Coding;

public class Pembayaran {
    
    private String nama_pasien;
    private int no_pembayaran;
    private int no_rj;
    private int total_bayar;
    private int id_mitra;
    private String no_bpjs;

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }
    
    public int getId_mitra() {
        return id_mitra;
    }

    public void setId_mitra(int id_mitra) {
        this.id_mitra = id_mitra;
    }

    public String getNo_bpjs() {
        return no_bpjs;
    }

    public void setNo_bpjs(String no_bpjs) {
        this.no_bpjs = no_bpjs;
    }
    
    public int getNo_pembayaran() {
        return no_pembayaran;
    }

    public void setNo_pembayaran(int no_pembayaran) {
        this.no_pembayaran = no_pembayaran;
    }

    public int getNo_rj() {
        return no_rj;
    }

    public void setNo_rj(int no_rj) {
        this.no_rj = no_rj;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }
      
}

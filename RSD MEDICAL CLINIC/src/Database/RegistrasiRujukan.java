package Database;

import Coding.Pasien;
import java.sql.Connection;
import java.sql.SQLException;


public class RegistrasiRujukan extends DBpasien {
   
   @Override
    public void insert(Pasien pasien) throws SQLException{
       
        String sql = "INSERT INTO pasien (nik,nama,tempat_lahir,tanggal_lahir,"
                + "umur,jenis_kelamin,alamat,telepon,pekerjaan,agama,poli,no_rujukan, "
                + "asal_rujukan,diagnosa,keterangan,status_pembayaran) VALUES ('"
                    +pasien.getNik()
                    +"','"+pasien.getNama()
                    +"','"+pasien.getTempatLahir()
                    +"','"+pasien.getTgllahir()
                    +"','"+pasien.getUmur()
                    +"','"+pasien.getJenis_kelamin()
                    +"','"+pasien.getAlamat()
                    +"','"+pasien.getTelepon()
                    +"','"+pasien.getPekerjaan()
                    +"','"+pasien.getAgama()
                    +"','"+pasien.getPoli()
                    +"','"+pasien.getNoRujukan()
                    +"','"+pasien.getAsalRujukan()
                    +"','"+pasien.getDiagnosa()
                    +"','"+pasien.getKeterangan()
                    +"','Belum Bayar')";
        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
    
   @Override
    public void edit(Pasien pasien, int noRJ) throws SQLException{

        String sql ="UPDATE pasien SET nik = '"+pasien.getNik()
                    +"', nama = '"+pasien.getNama()
                    +"', tempat_lahir = '"+pasien.getTempatLahir()
                    +"', umur = '"+pasien.getUmur()
                    +"', jenis_kelamin = '"+pasien.getJenis_kelamin()
                    +"', alamat = '"+pasien.getAlamat()
                    +"', pekerjaan = '"+pasien.getPekerjaan()
                    +"', poli = '"+pasien.getPoli()
                    +"', no_rujukan = '"+pasien.getNoRujukan()
                    +"', asal_rujukan = '"+pasien.getAsalRujukan()
                    +"', diagnosa = '"+pasien.getDiagnosa()
                    +"', keterangan = '"+pasien.getKeterangan()+"'"
                    + " where no_rj = "+noRJ;

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }

  
}

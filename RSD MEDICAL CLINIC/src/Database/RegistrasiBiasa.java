/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Coding.*;
import java.sql.Connection;
import java.sql.SQLException;

public class RegistrasiBiasa extends DBpasien {

    @Override
    public void insert(Pasien pasien) throws SQLException{
        String sql = "INSERT INTO pasien (nik,nama,tempat_lahir,tanggal_lahir,umur,"
                + "jenis_kelamin,alamat,pekerjaan,agama,telepon,poli,status_pembayaran) VALUES ('"+pasien.getNik()
                    +"','"+pasien.getNama()
                    +"','"+pasien.getTempatLahir()
                    +"','"+pasien.getTgllahir()
                    +"','"+pasien.getUmur()
                    +"','"+pasien.getJenis_kelamin()
                    +"','"+pasien.getAlamat()
                    +"','"+pasien.getPekerjaan()
                    +"','"+pasien.getAgama()
                    +"','"+pasien.getTelepon()
                    +"','"+pasien.getPoli()
                    +"','Belum Bayar"+"')";
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
                    +"', poli = '"+pasien.getPoli()+"'"
                    + " where no_rj = "+noRJ;

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }


}

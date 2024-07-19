package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Coding.Pasien;

public abstract class DBpasien {
    
    public ArrayList<Pasien> getAllData() throws SQLException{
        
        ArrayList<Pasien> data = new ArrayList<>();
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT * FROM pasien ORDER BY id ASC;");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            Pasien pasien = new Pasien();
            pasien.setNoRJ(rs.getInt("no_rj"));
            pasien.setNik(rs.getString("nik"));
            pasien.setNama(rs.getString("nama"));
            pasien.setUmur(rs.getInt("umur"));
                            
            data.add(pasien);
        }
        MySql.configDB().close();
        
        return data;
    }
    
    public Pasien getData(int noRJ) throws SQLException{
        
        Pasien pasien = new Pasien();
        
        Statement st = MySql.configDB().createStatement();
        String sql = "SELECT * FROM pasien where no_rj = "+noRJ+" and status_pembayaran = 'Belum Bayar'";
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        pasien.setNoRJ(rs.getInt("no_rj"));
        pasien.setNik(rs.getString("nik"));
        pasien.setNama(rs.getString("nama"));
        pasien.setUmur(rs.getInt("umur"));
        pasien.setAgama(rs.getString("agama"));
        pasien.setAlamat(rs.getString("alamat"));
        pasien.setAsalRujukan(rs.getString("asal_rujukan"));
        pasien.setDiagnosa(rs.getString("diagnosa"));
        pasien.setKeterangan(rs.getString("keterangan"));
        pasien.setPekerjaan(rs.getString("pekerjaan"));
        pasien.setPoli(rs.getString("poli"));
        pasien.setNoRujukan(rs.getInt("no_rujukan"));
        pasien.setTelepon(rs.getString("telepon"));
        pasien.setTempatLahir(rs.getString("tempat_lahir"));
        pasien.setTgllahir(rs.getString("tanggal_lahir"));
        pasien.setJenis_kelamin(rs.getString("jenis_kelamin"));
        
        MySql.configDB().close();
        
        return pasien;
    }
    
    public abstract void insert(Pasien pasien) throws SQLException;
 
    public abstract void edit(Pasien pasien, int noRJ) throws SQLException;
    
    public void editResep(Pasien pasien) throws SQLException{
        
        String sql ="UPDATE pasien SET diagnosa = '"+pasien.getDiagnosa()
                    +"', keterangan = '"+pasien.getKeterangan()+"'"
                    + " where no_rj = "+pasien.getNoRJ();

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
    
    public void hapus(int noRJ) throws SQLException{
        
        String sql ="delete from pasien where no_rj="+noRJ;

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
        
    }

    public Pasien search(int No_RJ) throws SQLException{
        
        Pasien pasien = new Pasien();
        
        Statement st = MySql.configDB().createStatement();
        String sql = "SELECT * FROM pasien where no_rj = '"+No_RJ+"'";
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        pasien.setNoRJ(rs.getInt("no_rj"));
        pasien.setNik(rs.getString("nik"));
        pasien.setNama(rs.getString("nama"));
        pasien.setUmur(rs.getInt("umur"));
        pasien.setAgama(rs.getString("agama"));
        pasien.setAlamat(rs.getString("alamat"));
        pasien.setAsalRujukan(rs.getString("asal_rujukan"));
        pasien.setDiagnosa(rs.getString("diagnosa"));
        pasien.setKeterangan(rs.getString("keterangan"));
        pasien.setPekerjaan(rs.getString("pekerjaan"));
        pasien.setPoli(rs.getString("poli"));
        pasien.setNoRujukan(rs.getInt("no_rujukan"));
        pasien.setTelepon(rs.getString("telepon"));
        pasien.setTempatLahir(rs.getString("tempat_lahir"));
        pasien.setTgllahir(rs.getString("tanggal_lahir"));
        pasien.setJenis_kelamin(rs.getString("jenis_kelamin"));
        pasien.setStatus_pembayaran(rs.getString("status_pembayaran"));
        
        MySql.configDB().close();
        
        return pasien;
    }
}

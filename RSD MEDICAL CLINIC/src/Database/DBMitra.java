package Database;

import Coding.Mitra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMitra {
    public ArrayList<Mitra> getDataPerusahaan() throws SQLException{
        
        ArrayList<Mitra> data = new ArrayList<>();
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT DISTINCT mitra.nama_perusahaan FROM mitra");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            Mitra mitra = new Mitra();
            mitra.setNama_perusahaan(rs.getString("nama_perusahaan"));
               
            data.add(mitra);
        }
        MySql.configDB().close();
        
        return data;
    }

    public Mitra getDataKaryawan(String id_pegawai) throws SQLException{
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT mitra.id_pegawai,mitra.id_mitra,mitra.nama_perusahaan FROM mitra where id_pegawai = '"+id_pegawai+"'");
        ResultSet rs = st.executeQuery(sql);
        rs.next(); 
            Mitra mitra = new Mitra();
            mitra.setId_pegawai(rs.getString("id_pegawai"));
            mitra.setId_mitra(rs.getInt("id_mitra"));
            mitra.setNama_perusahaan(rs.getString("nama_perusahaan"));
        
        MySql.configDB().close();
        
        return mitra;
    }
    
    public ArrayList<Mitra> getAllDataKaryawan(String nama_perusahaan) throws SQLException{
        
        ArrayList<Mitra> data = new ArrayList<>();
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT mitra.id_pegawai,mitra.id_mitra,mitra.nama_perusahaan FROM mitra where nama_perusahaan = '"+nama_perusahaan+"'");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            Mitra mitra = new Mitra();
            mitra.setId_pegawai(rs.getString("id_pegawai"));
            mitra.setId_mitra(rs.getInt("id_mitra"));
            mitra.setNama_perusahaan(rs.getString("nama_perusahaan"));
            data.add(mitra);
        }
        MySql.configDB().close();
        
        return data;
    }
    
    public Mitra getDataKaryawan(int id_mitra) throws SQLException{
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT mitra.id_pegawai,mitra.id_mitra,mitra.nama_perusahaan FROM mitra where id_mitra = '"+id_mitra+"'");
        ResultSet rs = st.executeQuery(sql);
        rs.next(); 
            Mitra mitra = new Mitra();
            mitra.setId_pegawai(rs.getString("id_pegawai"));
            mitra.setId_mitra(rs.getInt("id_mitra"));
            mitra.setNama_perusahaan(rs.getString("nama_perusahaan"));
        
        MySql.configDB().close();
        
        return mitra;
    }
}

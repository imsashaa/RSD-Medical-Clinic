package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Coding.Pembayaran;

public abstract class DBpembayaran {
    
    public ArrayList<Pembayaran> getAllData() throws SQLException{
        
        ArrayList<Pembayaran> data = new ArrayList<>();
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT * FROM pembayaran ORDER BY id ASC;");
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            Pembayaran pembayaran = new Pembayaran();
            pembayaran.setNo_pembayaran(rs.getInt("no_pembayaran"));
            pembayaran.setNo_rj(rs.getInt("no_rj"));
            pembayaran.setId_mitra(rs.getInt("id_mitra"));
            pembayaran.setNo_bpjs(rs.getString("no_bpjs"));
            pembayaran.setTotal_bayar(rs.getInt("total_bayar"));
                            
            data.add(pembayaran);
        }
        MySql.configDB().close();
        
        return data;
    }
    
    public Pembayaran getData(int no_pembayaran) throws SQLException{
        
        Pembayaran pembayaran = new Pembayaran();
        
        Statement st = MySql.configDB().createStatement();
        String sql = "SELECT * FROM `pembayaran` where no_pembayaran = "+no_pembayaran;
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        pembayaran.setNo_pembayaran(rs.getInt("no_pembayaran"));
        pembayaran.setNo_rj(rs.getInt("no_rj"));
        pembayaran.setTotal_bayar(rs.getInt("total_bayar"));
        pembayaran.setId_mitra(rs.getInt("id_mitra"));
        pembayaran.setNo_bpjs(rs.getString("no_bpjs"));
        
        MySql.configDB().close();
        
        return pembayaran;
    }
    
    public abstract void insert(Pembayaran pembayaran) throws SQLException;
    
    public void edit(Pembayaran pembayaran, int no_pembayaran) throws SQLException{

        String sql ="UPDATE pembayaran SET no_rj = '"+pembayaran.getNo_rj()
                    +"', total_bayar = '"+pembayaran.getTotal_bayar()+"'"
                    + " where no_pembayaran = "+no_pembayaran;

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();

    }
    
    public void hapus(int no_pembayaran) throws SQLException{
        
        String sql ="delete from pembayaran where no_pembayaran="+no_pembayaran;

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
        
    }
    
     public Pembayaran join(Pembayaran pembayaran) throws SQLException{
        Statement st = MySql.configDB().createStatement();
        String sql = "SELECT pasien.nama,pembayaran.* FROM pasien LEFT JOIN pembayaran "
                + "ON pasien.no_rj = pembayaran.no_rj where pasien.no_rj = "+pembayaran.getNo_rj();

        ResultSet rs = st.executeQuery(sql);
        rs.next();
        pembayaran.setNo_pembayaran(rs.getInt("no_pembayaran"));
        pembayaran.setNo_rj(rs.getInt("no_rj"));
        pembayaran.setTotal_bayar(rs.getInt("total_bayar"));
        pembayaran.setNama_pasien(rs.getString("nama"));
        
        MySql.configDB().close();
        
        return pembayaran;
    }
     
    public Pembayaran getDataBayar(int noRJ) throws SQLException{
        
        Pembayaran pembayaran = new Pembayaran();
        
        Statement st = MySql.configDB().createStatement();
        String sql = "SELECT * FROM `pembayaran` where no_rj = "+noRJ;
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        pembayaran.setNo_pembayaran(rs.getInt("no_pembayaran"));
        pembayaran.setNo_rj(rs.getInt("no_rj"));
        pembayaran.setTotal_bayar(rs.getInt("total_bayar"));
        pembayaran.setId_mitra(rs.getInt("id_mitra"));
        pembayaran.setNo_bpjs(rs.getString("no_bpjs"));
        
        MySql.configDB().close();
        
        return pembayaran;
    }
}

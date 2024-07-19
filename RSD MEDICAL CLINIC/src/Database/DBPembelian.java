package Database;

import Coding.Pembelian;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBPembelian {
     public ArrayList<Pembelian> getAllData(int NoRJ) throws SQLException{
        
        ArrayList<Pembelian> data = new ArrayList<>();
        
        Statement st = MySql.configDB().createStatement();
        String sql = ("SELECT * FROM pembelian where no_rj = "+NoRJ);
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
            Pembelian obat = new Pembelian();
            obat.setNoRJ(rs.getInt("no_rj"));
            obat.setItem(rs.getString("item"));
            obat.setHarga(rs.getInt("harga"));
               
            data.add(obat);
        }
        MySql.configDB().close();
        
        return data;
    }
    public Pembelian getData(int noRJ) throws SQLException{
        
        Pembelian data = new Pembelian();
        
        Statement st = MySql.configDB().createStatement();
        String sql = "SELECT * FROM pembelian where no_rj = "+noRJ;
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        data.setNoRJ(rs.getInt("no_rj"));
        data.setNo_pembelian(rs.getInt("no_pembelian"));
        data.setItem(rs.getString("item"));
        data.setHarga(rs.getInt("harga"));

        
        MySql.configDB().close();
        
        return data;
    }
    
    public void insertObat(Pembelian obat, int NoRJ) throws SQLException{
        String sql = "INSERT INTO pembelian (no_rj,item,harga) VALUES ('"
                    +NoRJ
                    +"','"+obat.getItem()
                    +"','"+obat.getHarga()+"')";
        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
   
    public void edit(Pembelian obat) throws SQLException{

        String sql ="UPDATE pembelian SET no_pembelian = '"
                    +"', item = '"+obat.getItem()
                    +"', harga = '"+obat.getHarga()+"'"
                    + " where no_rj = "+obat.getNoRJ();

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
    
    public void hapus(int noRJ) throws SQLException{
        
        String sql ="delete from pembelian where no_rj="+noRJ;

        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
        
    }
}

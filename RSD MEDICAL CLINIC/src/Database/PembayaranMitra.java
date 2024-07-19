
package Database;

import Coding.Pembayaran;
import java.sql.Connection;
import java.sql.SQLException;


public class PembayaranMitra extends DBpembayaran{
    @Override
    public void insert(Pembayaran pembayaran) throws SQLException{
        String sql = "INSERT INTO pembayaran (no_rj,total_bayar,id_mitra) VALUES ('"+pembayaran.getNo_rj()
                    +"','"+pembayaran.getTotal_bayar()
                    +"','"+pembayaran.getId_mitra()+"')";
        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
}

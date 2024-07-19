
package Database;

import Coding.Pembayaran;
import java.sql.Connection;
import java.sql.SQLException;

public class PembayaranMandiri extends DBpembayaran {
    
    @Override
    public void insert(Pembayaran pembayaran) throws SQLException{
        String sql = "INSERT INTO pembayaran (no_rj,total_bayar) VALUES ('"+pembayaran.getNo_rj()
                    +"','"+pembayaran.getTotal_bayar()+"')";
        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
    
    
}

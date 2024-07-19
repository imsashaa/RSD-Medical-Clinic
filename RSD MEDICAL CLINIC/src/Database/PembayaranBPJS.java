
package Database;

import Coding.Pembayaran;
import java.sql.Connection;
import java.sql.SQLException;


public class PembayaranBPJS extends DBpembayaran{
    @Override
    public void insert(Pembayaran pembayaran) throws SQLException{
        String sql = "INSERT INTO pembayaran (no_rj,no_bpjs,total_bayar) VALUES ('"+pembayaran.getNo_rj()
                    + "','"+pembayaran.getNo_bpjs()
                    + "',"+pembayaran.getTotal_bayar()+")";
        java.sql.Connection conn=(Connection)MySql.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        pst.execute();
        MySql.configDB().close();
    }
}

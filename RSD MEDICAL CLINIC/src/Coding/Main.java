package Coding;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Frame.*;
import Database.*;

public class Main{
    
    public static void CheckKoneksi() throws SQLException{
        MySql.configDB();
        MySql.configDB().close();
    }
    
    public static void main(String[] args) {
        
        try{
            CheckKoneksi();
            new LoginVisual().setVisible(true);
        }catch(SQLException e){
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Koneksi Gagal", "Database Koneksi", JOptionPane.ERROR_MESSAGE);
            jf.dispose();
        }
        
    }
}

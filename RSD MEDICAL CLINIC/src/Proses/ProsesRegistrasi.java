/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;
import Coding.Pasien;
import Database.DBpasien;
import java.sql.SQLException;

/**
 *
 * @author aqiellanyan
 */
public class ProsesRegistrasi {
    
    
    public static void tambah(DBpasien db_pasien, Pasien pasien) throws SQLException{
        db_pasien.insert(pasien);
    }
    
    
    
}

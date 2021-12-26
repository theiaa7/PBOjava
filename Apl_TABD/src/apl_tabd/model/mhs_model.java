package apl_tabd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class mhs_model extends koneksi{
    public mhs_model() throws SQLException{
        
    }
    public DefaultTableModel getALL() throws SQLException{
        Connection cn = super.GetConnection();
        Statement cmd = cn.createStatement();
        ResultSet rs = cmd.executeQuery("SELECT * FROM absensi_mhs");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("npm");
        model.addColumn("nama");
        model.addColumn("kelas");
        model.addColumn("tanggal");
        model.addColumn("jam");
        
        while (rs.next()){
        model.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
        });
    }
        return model;
    }
    
    public void Delete(String npm) throws SQLException{
        final String sql = "DELETE FROM absensi_mhs WHERE npm =?";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, npm);
        cmd.execute();
    }
    
    public void Insert(String npm, String nama, String kelas, String tanggal, String jam) throws SQLException{
        final String sql = "Insert into absensi_mhs VALUES(?, ?, ?, ?, ?)";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, npm);
        cmd.setString(2, nama);
        cmd.setString(3, kelas);
        cmd.setString(4, tanggal);
        cmd.setString(5, jam);
        
        cmd.execute();
    }
    
    public void Update(String npm, String nama, String kelas, String tanggal, String jam) throws SQLException{
        final String sql = "Update absensi_mhs SET nama=?, kelas=?, WHERE npm=?";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, npm);
        cmd.setString(2, nama);
        cmd.setString(3, kelas);
        cmd.setString(4, tanggal);
        cmd.setString(5, jam);
        
        cmd.execute();
    }
    
}

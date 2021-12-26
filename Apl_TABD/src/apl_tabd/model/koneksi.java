/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apl_tabd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bryan
 */
public class koneksi {
    public koneksi() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    }
    protected Connection GetConnection() throws SQLException{
        final String url = "jdbc:mysql//localhost:3306/crudd";
        final String user = "root";
        final String password = "";
        return DriverManager.getConnection(url,user,password);
    }
}

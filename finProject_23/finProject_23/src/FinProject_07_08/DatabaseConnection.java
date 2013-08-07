/*
 * DATE: 23/07/2013
 * version 1.0
 */

package FinProject_07_08;
/**
 *
 * @author Anastasiia
 */
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    
    private Connection con = null;
    private Statement stat = null;
    private ResultSet resSet = null;
    /*String dbName = "db1210081_historical_data";
    String userName = "1210081";
    String password = "1210081"; */
    String dbName = "historical_data";
    String userName = "root";
    String password = "";
    
    // establish the connection
    public DatabaseConnection(String dbName, String userName, String password){
        try{
            dbName = this.dbName;
            userName = this.userName;
            password = this.password;
            //con = (Connection)DriverManager.getConnection("jdbc:mysql://scomp-webdev/" + dbName, userName, password);
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
            stat = (Statement)con.createStatement();
            JOptionPane.showMessageDialog(null, "Connected to historical_data database","Successful", JOptionPane.INFORMATION_MESSAGE);
        
        } catch(SQLException | HeadlessException e){
          JOptionPane.showMessageDialog(null, "Check the connection with database","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  // Get data
  public ResultSet getData(String query) {
    try {
      resSet = stat.executeQuery(query);
    }
    catch(Exception e) {
      //JOptionPane.showMessageDialog(null, e);
    }
    return resSet;
  }   
  
      // Close connection
  public void closeConn() {
    try{
      resSet   = null;
      stat = null;
      con = null;
    }
    catch(Exception e) {
      //JOptionPane.showMessageDialog(null, e);
    }
    
    
  }
    
    
}

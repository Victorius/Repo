/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finproject_23;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anastasiia
 */
public class SqlQueryClass {
    
  private DatabaseConnection dbCon = null;
  private ResultSet rs = null;
  private Statement st = null;
  PreparedStatement preparedStatement = null;
  
  public SqlQueryClass (String dbName, String userName, String password) {
    dbCon = new DatabaseConnection(dbName, userName, password);
  }
  
  public Object getClosePriceFromDB(String query){
      return dbCon.getData(query);
  }
  
  public DatabaseConnection getDB(){
      return this.dbCon;
  }
  // 1. SELECT CLOSE PRICE PROCEDURES
  // --------------------------------------------------------
  // Select the close price - for initial price EUR/GBP
  public String getClPrice_EurGbp(String priceDate) {
    String query = "CALL getClosePr_EurGbp('" + priceDate + "');";
    String output = "";
    try {
      rs = dbCon.getData(query);
      while (rs!=null&& rs.next()) {
        output = rs.getString(1);
      }
    } catch (Exception e) {}
    return output;
  }
    // Select the close price - for initial price EUR/JPY
    public String getClPrice_EurJpy(String priceDate) {
      String query = "CALL getClosePr_EurJpy('" + priceDate + "');";
      String output = "";
    try {
      rs = dbCon.getData(query);
      while (rs.next()) {
        output = rs.getString(1);
      }
    } catch (Exception e) {}
    return output;
  }
    // Select the close price - for initial price EUR/USD
    public String getClPrice_EurUsd(String priceDate) {
      String query = "CALL getClosePr_EurUsd('" + priceDate + "');";
      String output = "";
    try {
      rs = dbCon.getData(query);
      while (rs.next()) {
        output = rs.getString(1);
      }
    } catch (Exception e) {}
    return output;
  }
   // Select the close price - for initial price GBP/JPY 
   public String getClPrice_GbpJpy(String priceDate) {
     String query = "CALL getClosePr_GbpJpy('" + priceDate + "');";
     String output = "";
    try {
      rs = dbCon.getData(query);
      while (rs.next()) {
        output = rs.getString(1);
      }
    } catch (Exception e) {}
    return output;
  }
    // Select the close price - for initial price GBP/USD
    public String getClPrice_GbpUsd(String priceDate) {
      String query = "CALL getClosePr_GbpUsd('" + priceDate + "');";
      String output = "";
    try {
      rs = dbCon.getData(query);
      while (rs.next()) {
        output = rs.getString(1);
      }
    } catch (Exception e) {}
    return output;
  }
    // Select the close price - for initial price USD/JPY
    public String getClPrice_UsdJpy(String priceDate) {
      String query = "CALL getClosePr_UsdJpy('" + priceDate + "');";
      String output = "";
    try {
      rs = dbCon.getData(query);
      while (rs.next()) {
        output = rs.getString(1);
      }
    } catch (Exception e) {}
    return output;
  }
    
   
    // 2. SELECT all the range of data between input date and 30 days before
    // -----------------------------------------------------------------------
    
    // for EUR/GBP pair
    public ArrayList getDataforVol_EurGbp(String date1){
    
      //Date date;
      List stPrices = new ArrayList();
      String sqlQuery = "SELECT close_price FROM eur_gbp"
                 + "WHERE day_date <'"+ date1 +"' AND "
                 + "day_date >= DATE_SUB('" +date1 +"',INTERVAL 30 DAY);";
       try {
            rs = dbCon.getData(sqlQuery);
            
            while (rs.next()) {
              stPrices.add(rs.getString("close_price"));
            }   
       } catch(SQLException e){}       
       return (ArrayList) stPrices; 
    }

   
    
    
    
    
}

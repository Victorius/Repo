/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PairHandlers;

import FinProject_07_08.DatabaseConnection;
import FinProject_07_08.SqlQueryClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommonHandlerForPair {    
    protected String CurrPair="";
    protected DatabaseConnection dbc = null;
    
    public CommonHandlerForPair(){}
    public CommonHandlerForPair(DatabaseConnection dbc){
        this.dbc = dbc;
    }
    /**
     * method returns name of cur pair to Panel
     * @return 
     */
    public String getCurrpair(){
        return this.CurrPair;
    }
    
    /**
     * method for getting close_price value - matching one day;
     * used to fill in the field of Stock_price.
     * 
     * @param FromDate
     * @return
     * @throws SQLException 
     */
    public String getClosePrice(String FromDate) throws SQLException{
        if(dbc!=null){
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE=\'"+FromDate+"\';");
            if(rs.next())
                return rs.getString(1);
            else
                return null;
        }else
            return null;
    }
    /**
     * method for calculating volatility - when choosing data from the range of dates (fromDate and toDate)
     * @param FromDate
     * @param ToDate
     * @return
     * @throws SQLException 
     */
    public ArrayList<Float> getClosePrice(String FromDate,String ToDate)throws SQLException{
        if(dbc!=null){
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE BETWEEN \'"+FromDate+"\' AND \'"+ToDate+"\';");
            ArrayList<Float> results = new ArrayList<Float>();
            while(rs.next()){
                results.add(rs.getFloat(1));
            }
            return results;
        }else
            return null;
    }
    
    /**
     * 
     * method for assigning the existing database connection to class
     * @param dbc 
     */
    public void setDBConn(DatabaseConnection dbc){
        this.dbc=dbc;
        
    }
    
    /**
     * 
     * method returns database connection of class
     * @return 
     */
    public DatabaseConnection getDB(){
        return this.dbc;
    }
    
    
    
}


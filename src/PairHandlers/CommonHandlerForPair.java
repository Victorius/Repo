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
    public String getCurrpair(){
        return this.CurrPair;
    }
    
    public Object getClosePrice(String FromDate) throws SQLException{
        if(dbc!=null){
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE=\'"+FromDate+"\';");
            if(rs.next())
                return rs.getString(1);
            else
                return null;
        }else
            return null;
    }
    
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
    
    public void setDBConn(DatabaseConnection dbc){
        this.dbc=dbc;
        
    }
    
    public DatabaseConnection getDB(){
        return this.dbc;
    }
    
    
    
}

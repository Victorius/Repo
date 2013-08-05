/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PairHandlers;

import finproject_23.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class EURGBP extends CommonHandlerForPair{
    

    public EURGBP(DatabaseConnection dbc){
        this.dbc=dbc;
        this.CurrPair = "EUR/GBP";
    }
    
    @Override
    public Object getClosePrice(String FromDate) throws SQLException{
        if(dbc!=null){
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE="+FromDate+";");
            if(rs.next())
                return rs.getString(1);
            else
                return null;
        }else
            return null;
    }
    
    @Override
    public ArrayList<Float> getClosePrice(String FromDate,String ToDate)throws SQLException{
        if(dbc!=null){
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE BETWEEN "+FromDate+" AND "+ToDate+";");
            ArrayList<Float> results = new ArrayList<Float>();
            while(rs.next()){
                results.add(rs.getFloat(1));
            }
            return results;
        }else
            return null;
    }
}

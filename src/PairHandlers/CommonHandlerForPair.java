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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            if(rs.next()){                
                return rs.getString(1);
            }else
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
            Integer y = Integer.parseInt(FromDate.substring(0,4));
            Integer m = Integer.parseInt(FromDate.substring(4,6));
            Integer d = Integer.parseInt(FromDate.substring(6));
            do{
                if(d-30>=1)
                    d=d-30;
                else if(m==3 && d>=1 && d<=2){
                    if(Math.abs((y-2000))%4==0)
                        if(d==2){
                            d=1;
                            m=2;
                        }else{
                            d=31;
                            m=1;
                        }
                    else
                        if(d==2){
                            d=31;
                            m=1;
                        }else{
                            d=30;
                            m=1;
                        }                        
                }else if(m>1){
                    int t=d-30;
                    switch(m){
                        case 1: d=31+t;break;
                        case 2: 
                            d=31+t;
                        case 3:
                            if(Math.abs((y-2000))%4==0)
                                d=29+t;
                            else
                                d=28+t;
                            break;
                        case 4: d=31+t;break;
                        case 5: d=30+t;break;
                        case 6: d=31+t;break;
                        case 7: d=30+t;break;
                        case 8: d=31+t;break;
                        case 9: d=31+t;break;
                        case 10: d=30+t;break;
                        case 11: d=31+t;break;
                        case 12: d=30+t;break;
                    }
                    m--;
                }else{
                    int t=d-30;
                    m=12;
                    d=31+t;
                    y--;
                }
                String md = (m.toString().length()==1)?"0"+m.toString():m.toString();
                String dd = d.toString().length()==1?"0"+d.toString():d.toString();
                FromDate=y.toString()+md+dd;
                rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE BETWEEN \'"+FromDate+"\' AND \'"+ToDate+"\';");
            }while(!rs.next());            
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
    
    public ArrayList<ArrayList<Object>> getAllData(){
        ArrayList<Object> resultDouble = new ArrayList<Object>();
        ArrayList<Object> resultString = new ArrayList<Object>();
        ResultSet rs = this.dbc.getData("SELECT DAY_DATE,close_price from historical_data.eur_gbp");
        try {
            if(rs!=null && rs.next()){
                resultDouble.add((Object)rs.getDouble(2));
                resultString.add((Object)rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonHandlerForPair.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
        res.add(resultDouble);
        res.add(resultString);
        return null;
    }
    
}


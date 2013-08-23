/*
 * DATE: 10/08/2013
 * EUR_JPY Class
 */

package PairHandlers;

import FinProject_07_08.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anastasiia
 */

public class EURJPY extends CommonHandlerForPair{
    
    public EURJPY(DatabaseConnection dbc){
        this.dbc=dbc;
        this.CurrPair="EUR/JPY";
    }
    
    @Override
    public String getClosePrice(String FromDate) throws SQLException{
        if(dbc!=null){
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_JPY WHERE DAY_DATE=\'"+FromDate+"\';");
            if(rs!=null && rs.next())
                return rs.getString(1);
            else return null;
        }else
            return null;
    }
    
    @Override
    public ArrayList<Float> getClosePrice(String FromDate,String ToDate)throws SQLException{
        if(dbc!=null){            
            Integer y = Integer.parseInt(FromDate.substring(0,4));
            Integer m = Integer.parseInt(FromDate.substring(4,6));
            Integer d = Integer.parseInt(FromDate.substring(6));
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
                        break;
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
            String FromDate2=y.toString()+md+dd;
            ResultSet rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_JPY WHERE DAY_DATE BETWEEN \'"+FromDate2+"\' AND \'"+FromDate+"\';");

            ArrayList<Float> results = new ArrayList<Float>();
            while(rs.next()){
                results.add(rs.getFloat(1));
            }
            return results;
        }else
            return null;
    }
    @Override
    public ArrayList<ArrayList<Object>> getAllData(){
        ArrayList<Object> resultDouble = new ArrayList<Object>();
        ArrayList<Object> resultString = new ArrayList<Object>();
        ResultSet rs = this.dbc.getData("SELECT DAY_DATE,close_price from historical_data.eur_jpy");
        try {
            while(rs!=null && rs.next()){
                resultDouble.add((Object)rs.getDouble(2));
                Date st = rs.getDate(1);
                resultString.add((Object)st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonHandlerForPair.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
        res.add(resultDouble);
        res.add(resultString);
        return res;
    }
}


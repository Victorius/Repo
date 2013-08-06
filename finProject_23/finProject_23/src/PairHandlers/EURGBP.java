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
            else{
                Integer y = Integer.parseInt(FromDate.substring(0,4));
                Integer m = Integer.parseInt(FromDate.substring(4,6));
                Integer d = Integer.parseInt(FromDate.substring(6));
                do{
                    if(d>1)
                        d--;
                    else if(m>1){
                        m--;
                        switch(m){
                            case 1: d=31;break;
                            case 2: 
                                if(Math.abs((y-2000))%4==0)
                                    d=29;
                                else
                                    d=28;
                                break;
                            case 3: d=31;break;
                            case 4: d=30;break;
                            case 5: d=31;break;
                            case 6: d=30;break;
                            case 7: d=31;break;
                            case 8: d=31;break;
                            case 9: d=30;break;
                            case 10: d=31;break;
                            case 11: d=30;break;
                            case 12: d=31;break;
                        }
                    }else{
                        m=12;
                        d=31;
                        y--;
                    }
                    String md = (m.toString().length()==1)?"0"+m.toString():m.toString();
                    String dd = d.toString().length()==1?"0"+d.toString():d.toString();
                    FromDate=y.toString()+md+dd;
                    rs = dbc.getData("SELECT close_price FROM HISTORICAL_DATA.EUR_GBP WHERE DAY_DATE="+FromDate+";");
                }while(!rs.next());
                return rs.getString(1);
            }
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

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
     * Метод возвращает название валют в панель.
     * @return 
     */
    public String getCurrpair(){
        return this.CurrPair;
    }
    
    /**
     * Метод для получения значения close_price в один день;
     * Используется для заполненияя поля Stock_price.
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
     * Метод для вычисления волатильности, когда мы выбираем данные из диапозона, который
     * выбираем в дата_чузерах.
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
     * Метод для присвоения экземпляру класса существующее соединения в базе данных
     * @param dbc 
     */
    public void setDBConn(DatabaseConnection dbc){
        this.dbc=dbc;
        
    }
    
    /**
     * Метод возвращает соеиднение к базе данных данного экземпляра класса.
     * @return 
     */
    public DatabaseConnection getDB(){
        return this.dbc;
    }
    
    
    
}

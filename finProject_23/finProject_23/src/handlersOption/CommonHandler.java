/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;

import FinProject_07_08.SqlQueryClass;
import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;
import PairHandlers.CommonHandlerForPair;


/**
 *
 * @author Admin
 */
public class CommonHandler {
    protected SqlQueryClass sqlClass=null;
    protected String optionName="EUROPEAN";
    
    /**
     * 
     * @param S stock price
     * @param X Strike price of option, price should be input by user
     * @param r risk-free interest rate
     * @param T - duration of counting
     * @param a - volatility
     * @return 
     */
    public Double Call(double S,double X, double r,double rf, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(S/X)+(r-rf+a*a/2)*T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        Double res = S*Math.pow(Math.E, -rf*T)*n.cdf(d1)-X*Math.pow(Math.E, -r*T)*n.cdf(d2);
        return res;
    }
    
    public Double Put(double S,double X, double r,double rf, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(S/X)+(r-rf+a*a/2)*T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        Double res = X*(Math.pow(Math.E, -r*T))*n.cdf(-d2)-S*(Math.pow(Math.E, -rf*T))*n.cdf(-d1);
        return res;
    }    

    
//    public String getCurrencyPair() {
//        return this.pair.getCurrpair();
//    }

    public String getOptionName(){
        return this.optionName;
    }
    
    public void setOption(SqlQueryClass db) {
        this.sqlClass=db;
//        if(this.pair!=null)
//            pair.setDBConn(db);
    }
//    
//    public void setOption(CommonHandlerForPair pair){
////        this.pair=pair;
//        if(this.sqlClass!=null)
//            pair.setDBConn(sqlClass);
//    }
    
    public void setOption(CommonHandlerForPair pair,SqlQueryClass db){
//        this.pair=pair;
        this.sqlClass=db;        
    }
}

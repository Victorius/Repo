/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;

import FinProject_07_08.SqlQueryClass;
import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;
import PairHandlers.CommonHandlerForPair;


public class CommonHandler {
    protected SqlQueryClass sqlClass=null;
    protected String optionName="";
    
    /**
     * 
     * @param S   stock price
     * @param X   Strike price of option, price should be input by user
     * @param r   domestic risk-free rate
     * @param r_f foreign risk-free rate
     * @param T   time to maturity
     * @param a   volatility
     * @return 
     */
    public Double Call(double S,double X, double r,double rf, double T,double a){
        return 0.0;
    }
    
    public Double Put(double S,double X, double r,double rf, double T,double a){
        return 0.0;
    }    
    

    public String getOptionName(){
        return this.optionName;
    }
    
    public void setOption(SqlQueryClass db) {
        this.sqlClass=db;
    }
    
    public void setOption(CommonHandlerForPair pair,SqlQueryClass db){
        this.sqlClass=db;        
    }
}

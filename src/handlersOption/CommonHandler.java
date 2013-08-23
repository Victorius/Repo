/*
 * DATE: 14/08/2013
 * Common Handler Class
 */

package handlersOption;

import FinProject_07_08.SqlQueryClass;
import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;
import PairHandlers.CommonHandlerForPair;

/**
 *
 * @author Anastasiia
 */


public class CommonHandler {
    protected SqlQueryClass sqlClass=null;
    protected String optionName="";
    protected String DefinitionOfOption = "";
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

    public String getDefinitionOfOption(){
        return this.DefinitionOfOption;
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

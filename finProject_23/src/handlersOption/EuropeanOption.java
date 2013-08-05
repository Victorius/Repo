/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;

/**
 *
 * @author Admin
 */
public class EuropeanOption extends CommonHandler{
    public EuropeanOption(){
        this.optionName="EUROPEAN";
    }
    
    
    
    @Override
    public Double Call(double S,double X, double r, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(S/X)+(r+a*a/2)/T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        Double res = S*n.cdf(d1)-X*Math.pow(Math.E, -r*T)*n.cdf(d2);
        return res;
    }
    
    @Override
    public Object[] Put(){
        return null;
    }
    
}

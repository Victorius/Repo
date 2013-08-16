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
public class AsianOption extends CommonHandler{
    public void AsianOption(){
        this.optionName="ASIAN";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double b=rf-r;
        Double ba = 0.5*(b-a*a/6);
        Double aa = a/Math.sqrt(3);
        Double d1 = (Math.log(S/X)+(ba+aa*aa*0.5)*T)/(aa*Math.sqrt(T));
        Double d2 = d1 - aa*Math.sqrt(T);
        Double res = S*Math.exp((ba-r)*T)*n.cdf(d1)-X*Math.exp(-r*T)*n.cdf(d2);
        return res;
    }
    
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double b=rf-r;
        Double ba = 0.5*(b-a*a/6);
        Double aa = a/Math.sqrt(3);
        Double d1 = (Math.log(S/X)+(ba+aa*aa*0.5)*T)/(aa*Math.sqrt(T));
        Double d2 = d1 - aa*Math.sqrt(T);
        Double res = X*Math.exp(-r*T)*n.cdf(-d2)-S*Math.exp((ba-r)*T)*n.cdf(-d1);
        return res;
    }    
    
}

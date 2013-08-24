/*
 * DATE: 21/08/2013
 * Options on Futures Class
 */

package handlersOption;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;

/**
 *
 * @author Anastasiia
 */

public class FuturesOption extends CommonHandler{
    public FuturesOption(){
        this.optionName="FUTURES";
        this.DefinitionOfOption = "\n" +
                                             "Option on Futures\n" +
                                             "________________________\n" +
                                             "is an option that has a\n" +
                                             "standardized expiry dates and\n" +
                                             "strike prices, etc.\n" +
                                             "Once created and initially sold\n" +
                                             "futures are then suitable for\n" + 
                                             "secondary trading on an exchange.\n";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        double F = S*Math.exp((r-rf)*T);
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(F/X)+(r-rf+a*a/2)*T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        double result = F*Math.exp((r-rf)*T)*n.cdf(d1)-X*n.cdf(d2)*Math.exp((r-rf)*T);
        return result;
    }
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        double F = S*Math.exp((r-rf)*T);
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(F/X)+(r-rf+a*a/2)*T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        double result = X*Math.exp((r-rf)*T)*n.cdf(-d2)-F*n.cdf(-d1)*Math.exp((r-rf)*T);
        return result;
    }
}

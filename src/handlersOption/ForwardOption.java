/*
 * DATE: 21/08/2013
 * Options on Forwards Class
 */

package handlersOption;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;

/**
 *
 * @author Anastasiia
 */


public class ForwardOption extends CommonHandler{
    public ForwardOption(){
        this.optionName="FORWARD";
        this.DefinitionOfOption = "\n" +
                                             "Option on Forwards\n" +
                                             "________________________\n" +
                                             "is generally only traded\n" +
                                             "'over the counter' between\n" +
                                             "buyer and seller, since the\n" +
                                             "can be negotiated to have any\n" +
                                             "a set of individual te4rms or\n" +
                                             "conditions required by a buyer.\n";
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

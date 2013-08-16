/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;

/**
 *
 * @author Anthony
 */
public class FuturesOption extends CommonHandler{
    public FuturesOption(){
        this.optionName="FUTURES";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        return Math.exp(rf-r)*T*S;
    }
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        return Math.exp(rf-r)*T*S;
    }
}

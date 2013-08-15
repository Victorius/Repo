/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;


public class ForwardOption extends CommonHandler{
    public ForwardOption(){
        this.optionName="FORWARD";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        return 0.0;
    }
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        return 0.0;
    }
}

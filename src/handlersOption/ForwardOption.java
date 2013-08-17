/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;


public class ForwardOption extends CommonHandler{
    public ForwardOption(){
        this.optionName="FORWARD";
        this.DefinitionOfOption="This is Forward option type.";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        double forwOption = Math.exp(rf-r)*T*X;
        return forwOption;
    }
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        double forwOption = Math.exp(rf-r)*T*X;
        return forwOption;
    }
}

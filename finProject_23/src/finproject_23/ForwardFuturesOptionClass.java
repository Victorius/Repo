/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finproject_23;

/**
 *
 * @author Anastasiia
 */
public class ForwardFuturesOptionClass{
    
  private int maturDate; // period of option
  private double forCurIntRate; // r1
  private double domesCurIntRate; // r2
  private double initPrice; // close price
  private double strPrice;
    
    public ForwardFuturesOptionClass(int maturDate, double forCurIntRate,double domesCurIntRate,double initPrice,
                                     double strPrice){
    
        this.maturDate = maturDate;
        this.forCurIntRate = forCurIntRate;
        this.domesCurIntRate = domesCurIntRate;
        this.initPrice = initPrice;
        this.strPrice = strPrice;
    }
    
    public double getFuturesOpPrice(int maturDate, double forCurIntRate,double domesCurIntRate,double initPrice){
    
        double exp, futOption = 0.0;
        exp = Math.exp(domesCurIntRate - forCurIntRate) * maturDate;
        futOption = exp * initPrice;
        System.out.println("Future option is " + futOption);
        return futOption;
    }
    
   public double getForwardPrice(int maturDate, double forCurIntRate,double domesCurIntRate,double strPrice){
    
        double exp, forwOption = 0.0;
        exp = Math.exp(domesCurIntRate - forCurIntRate) * maturDate;
        forwOption = strPrice * exp;
        System.out.println("Forwards option is " + forwOption);
        return forwOption;
   }
}

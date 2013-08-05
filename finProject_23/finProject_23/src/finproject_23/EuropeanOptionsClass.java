/*
 * DATE: 30/07/2013
 * version 1.0
 */
package finproject_23;

import JSci.maths.statistics.NormalDistribution;

/**
 *
 * @author Anastasiia
 */
public class EuropeanOptionsClass extends BaseOptionClass{
    
    private double call = 0.0;
    private double put = 0.0;
    private double futOption = 0.0;
    private double forwOption = 0.0;
    private double futCallOpt = 0.0;
    private double futPutOpt = 0.0;
    private double forwCallOpt = 0.0;
    private double forwPutOpt = 0.0;
  
  public EuropeanOptionsClass(int maturDate,double initPrice,double volatValue,
                              double forCurIntRate, double domesCurIntRate,double strikePrice){
    
    super(maturDate,(float)initPrice,(float)volatValue,(float)forCurIntRate,(float)domesCurIntRate,(float)strikePrice);
  
  }
  
  // call option
  public double europCall(int maturDate,double initPrice,double volatValue,
                          double forCurIntRate, double domesCurIntRate, double strikePrice){
  
    double d1, d2, div, volPart, log, log1, n_d1, n_d2;
    double call_1, call_2;
    NormalDistribution asd = new NormalDistribution(); 
    
    div = volatValue * Math.sqrt(maturDate); // sig * sqrt(T)
    log = (Math.log(initPrice/strikePrice))/div; // ln(S/X) / sig*sqrt(T)
    log1 = maturDate/div; // T / sig*sqrt(T)
    volPart  = domesCurIntRate - forCurIntRate + (volatValue * volatValue)/2;
    d1 = log + volPart * log1;
    d2 = d1 - div;
    
    double exp  = Math.exp(-forCurIntRate * maturDate); // exp(-r_f * T)
    double exp1 = Math.exp(-domesCurIntRate * maturDate); // exp(-r * T)        
    n_d1 = asd.cumulative(d1);
    n_d2 = asd.cumulative(d2);
    //System.out.println("For Eur Call: N(d1) is " + n_d1 + ", N(d2) is " + n_d2);
    call_1 = initPrice   * exp  * n_d1;
    call_2 = strikePrice * exp1 * n_d2;
    call   = call_1 - call_2;
    //System.out.println("Call option is" + call);
    return call;
  }
   
    // call option
  public double europPut(int maturDate,double initPrice,double volatValue,
                         double forCurIntRate, double domesCurIntRate, double strikePrice){
  
    double d1, d2, div, volPart, log, log1, n_d1, n_d2;
    double put_1, put_2;
    NormalDistribution asd = new NormalDistribution(); 
    div = volatValue * Math.sqrt(maturDate); // sig * sqrt(T)
    log = (Math.log(initPrice/strikePrice))/div; // ln(S/X) / sig*sqrt(T)
    log1 = maturDate/div; // T / sig*sqrt(T)
    volPart  = domesCurIntRate - forCurIntRate + (volatValue * volatValue)/2;
    d1 = log + volPart * log1;
    d2 = d1 - div;
    
    double exp  = Math.exp(-forCurIntRate * maturDate); // exp(-r_f * T)
    double exp1 = Math.exp(-domesCurIntRate * maturDate); // exp(-r * T)        
    n_d1 = asd.cumulative(-d1);
    n_d2 = asd.cumulative(-d2);
    //System.out.println("N(-d1) is " + n_d1 + ", N(-d2) is " + n_d2);
    put_1 = initPrice   * exp  * n_d1;
    put_2 = strikePrice * exp1 * n_d2;
    put   = put_2 - put_1;
    //System.out.println("Put option is" + put);
    return put;
  }
  
      public double getFuturesOpPrice(int maturDate, double forCurIntRate,double domesCurIntRate,double initPrice){
    
        double exp;
        exp = Math.exp(domesCurIntRate - forCurIntRate) * maturDate;
        //System.out.println("Futures: exp(r1 - r2)" + exp);
        futOption = exp * initPrice;
        //System.out.println("Future option is " + futOption);
        return futOption;
    }
    
   public double getForwardPrice(int maturDate, double forCurIntRate,double domesCurIntRate,double strPrice){
    
        double exp;
        exp = Math.exp(domesCurIntRate - forCurIntRate) * maturDate;
        forwOption = strPrice * exp;
        //System.out.println("Forwards option is " + forwOption);
        return forwOption;
   }
   
   public double getCallOpOnFutures(int maturDate,double initPrice,double volatValue,
                                    double forCurIntRate, double domesCurIntRate, double strikePrice){
       futOption = getFuturesOpPrice(maturDate, forCurIntRate,domesCurIntRate,initPrice);
       futCallOpt = europCall(maturDate,futOption,volatValue,forCurIntRate, domesCurIntRate, strikePrice); 
       System.out.println("Futures on Call is " + futCallOpt);
       return futCallOpt;
   }
   
   public double getPutOpOnFutures(int maturDate,double initPrice,double volatValue,
                                   double forCurIntRate, double domesCurIntRate, double strikePrice){
       futOption = getFuturesOpPrice(maturDate, forCurIntRate,domesCurIntRate,initPrice);
       futPutOpt = europPut(maturDate, futOption, volatValue,forCurIntRate, domesCurIntRate, strikePrice); 
       System.out.println("Futures on Put is " + futPutOpt);
       return futPutOpt;
   }
   
   public double getCallOnForwards(int maturDate,double initPrice,double volatValue,
                         double forCurIntRate, double domesCurIntRate, double strPrice){
      forwOption = getForwardPrice(maturDate, forCurIntRate, domesCurIntRate, strPrice); 
      forwCallOpt = europCall(maturDate, initPrice, volatValue, forCurIntRate, domesCurIntRate, forwOption);
      System.out.println("Forwards on Call is " + forwCallOpt);
      return forwCallOpt;
   }
   
      public double getPutOnForwards(int maturDate,double initPrice,double volatValue,
                         double forCurIntRate, double domesCurIntRate, double strPrice){
      forwOption = getForwardPrice(maturDate, forCurIntRate, domesCurIntRate, strPrice); 
      forwPutOpt = europCall(maturDate, initPrice, volatValue, forCurIntRate, domesCurIntRate, forwOption);
      System.out.println("Forwards on Put is " + forwPutOpt);
      return forwPutOpt;
   }
   
}

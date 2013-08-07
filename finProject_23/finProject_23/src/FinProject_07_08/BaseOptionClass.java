

package FinProject_07_08;

/**
 *
 * @author Anastasiia
 */
public abstract class BaseOptionClass {
  
  private int maturDate; // period of option
  private float volatValue;
  private float forCurIntRate; // r1
  private float domesCurIntRate; // r2
  private float initPrice; // close price
  private float strikePrice;
  
  public BaseOptionClass(int maturDate,float initPrice,float volatValue,
                         float forCurIntRate, float domesCurIntRate,float strikePrice){
         
    this.maturDate = maturDate;
    this.initPrice = initPrice;
    this.volatValue = volatValue;
    this.forCurIntRate = forCurIntRate;
    this.domesCurIntRate = domesCurIntRate;
    this.strikePrice = strikePrice;
    
  }
  
  
  
}

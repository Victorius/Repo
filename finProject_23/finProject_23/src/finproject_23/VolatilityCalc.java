

package finproject_23;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anastasiia
 */
public class VolatilityCalc {
    
    private int numObserv; //
    private int numDays; // length of time interval
    private float[] stockPriceArray; // for storing close prices
    
    private float[] newPrices;
    private float[] averPrices;
    
    private float sumPrice;
    private float sumAvPr;
    
    private float averPrice; 
    private float standDev; // standard deviation s 
    private float volatValue;
    
 //public float calculateVolatility(int numObserv, float[] stockPriceArray, int numDays){
 public float calculateVolatility(int numObserv, ArrayList<Float> stockPriceArray, int numDays){    
     this.numObserv = numObserv;
     this.numDays = numDays;
     newPrices = new float[stockPriceArray.size()];
     averPrices=new float[stockPriceArray.size()];
     if (numObserv>0){
          for (int i=1;i < numObserv+1; i++){
         
              //newPrices[i] += oldPrices[i];
              //float div = stockPriceArray.[i]/stockPriceArray[i-1];
              float div = stockPriceArray.get(i)/stockPriceArray.get(i-1);
              float u_i = (float)Math.log(div);
              newPrices[i] = u_i * u_i;// u[i]*u[i]
              averPrices[i] = u_i;// u[i] 
              sumPrice += newPrices[i]; // sum (u[i]*u[i])
              sumAvPr += averPrices[i]; // sum (u[i])
          }
         averPrice = (float) sumAvPr / numObserv; // average_u[i]
         standDev = (float)Math.sqrt( (1/numObserv)*sumPrice - averPrice*averPrice );
         volatValue = standDev / (float)Math.sqrt(numDays);

     System.out.println("Volatility is " + volatValue);
     return volatValue;
     } 
     else { 
         JOptionPane.showMessageDialog(null, "error", "Some errors are detected", JOptionPane.ERROR_MESSAGE);
         return 0;
     }
 }
 
}

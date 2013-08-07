

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
    
    private double averPrice=0.0; 
    private double standDev=0.0; // standard deviation s 
    private double volatValue=0.0;
    
 //public float calculateVolatility(int numObserv, float[] stockPriceArray, int numDays){
 public double calculateVolatility(int numObserv, ArrayList<Float> stockPriceArray, int numDays){    
     this.numObserv = numObserv;
     this.numDays = numDays;
     newPrices = new float[stockPriceArray.size()];
     averPrices=new float[stockPriceArray.size()];
     if (numObserv>0){
          for (int i=1;i < stockPriceArray.size(); i++){
         
              //newPrices[i] += oldPrices[i];
              //float div = stockPriceArray.[i]/stockPriceArray[i-1];
              double div = stockPriceArray.get(i)/stockPriceArray.get(i-1);
              double u_i = Math.log(stockPriceArray.get(i)/stockPriceArray.get(i-1));
//              newPrices[i-1] = u_i * u_i;// u[i]*u[i]
//              averPrices[i-1] = u_i;// u[i] 
              sumPrice += (float)Math.log(div*div);//newPrices[i-1]; // sum (u[i]*u[i])
              sumAvPr += u_i;//averPrices[i-1]; // sum (u[i])
          }
//         averPrice = (float) sumAvPr / numDays; // average_u[i]
         standDev = Math.sqrt( (1/(numDays-1))*sumPrice - (1/(numDays*(numDays-1)))*sumAvPr*sumAvPr );
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

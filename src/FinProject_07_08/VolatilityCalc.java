/*
 * DATE: 01/08/2013
 * Option Panel Class
 */

package FinProject_07_08;

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
     this.volatValue=0.0;
     this.numObserv = numObserv;
     this.numDays = numDays;
     sumAvPr=sumPrice=0;
     newPrices = new float[stockPriceArray.size()];
     averPrices=new float[stockPriceArray.size()];
     if (numObserv>0){
        for(int i=1;i < stockPriceArray.size(); i++)
            sumAvPr +=  Math.log(stockPriceArray.get(i)/stockPriceArray.get(i-1));
	sumAvPr=sumAvPr/numDays;
	for (int i=1;i < stockPriceArray.size(); i++){
            double u_i = Math.log(stockPriceArray.get(i)/stockPriceArray.get(i-1));
            sumPrice += (u_i-sumAvPr)*(u_i-sumAvPr);
        }
        volatValue= Math.sqrt(sumPrice/(numDays-1));
        return volatValue;
     } 
     else { 
         JOptionPane.showMessageDialog(null, "error", "Some errors are detected", JOptionPane.ERROR_MESSAGE);
         return 0;
     }
 }
 
 public double getVolatility(){
     return this.volatValue;
 }
 
}

package FinProject_07_08;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastasiia
 */
public class TestClass {
    
    private OptionsOnAssetsClass optOnAssets;
    
    public static void main(String[] args){
    
        VolatilityCalc volClass = new VolatilityCalc();
        ArrayList<Double> list = new ArrayList<>();
        list.add(0.6577);
        list.add(0.65898);
        list.add(0.4545);
        list.add(0.7986);
        list.add(0.9894);  
//        System.out.println("Volatility is " + volClass.calculateVolatility(5, list, 40));
        
        EuropeanOptionsClass eurOpt = new EuropeanOptionsClass(50, 0.5643, 0.4, 0.03, 0.04, 0.5483);
        System.out.println("European Class ---");
        eurOpt.europCall(50, 0.5643, 0.4, 0.03, 0.04, 0.5483);
        System.out.println("Call option is " + eurOpt.europCall(50, 0.5643, 0.4, 0.03, 0.04, 0.5483));
        eurOpt.europPut(100, 0.66786, 0.1, 0.04, 0.03, 0.5989);
        System.out.println("Put option is " + eurOpt.europPut(100, 0.66786, 0.1, 0.04, 0.03, 0.5989));
        
        System.out.println("Forwards Class ---");
        eurOpt.getCallOnForwards(30, 0.7855, 0.5, 0.04, 0.03, 0.6543);
        eurOpt.getPutOnForwards(40, 0.7545, 0.4, 0.03, 0.04, 0.6543);
        
        System.out.println("Futures Class ---");
        eurOpt.getCallOpOnFutures(25, 0.8473, 0.3, 0.02, 0.03, 0.6064);
        eurOpt.getPutOpOnFutures(65, 0.6432, 0.5, 0.03, 0.05, 0.43284);
        
//        AmerCallPutClass prClass = new AmerCallPutClass(5000);
        int nop;
        double price, vol, ret, tom;
        Double dPrice;
        nop = 10; // number of sub periods
        tom = 0.25; // days
        ret = 0.05; // r1
        vol = 0.4;
        
        //price = prClass.getEurCallPrice(90.0, 100.0, tom, nop, ret, vol);
        //System.out.println("price is " + price);
        //dPrice = new Double(price);
        //System.out.println("Europ call price is " + dPrice.toString());
        
        
    }   
    
    
}

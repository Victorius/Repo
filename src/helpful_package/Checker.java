/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpful_package;

import FinProject_07_08.OptionPanel;

/**
 *
 * @author Admin
 */
public class Checker implements Runnable{
private java.util.Date prevFirstDate=null,prevSecondDate=null;
private OptionPanel op=null;
    public Checker(OptionPanel op){
        this.op =op;        
    }
    @Override
    public void run() {
        while(true){
                if(op.getDate(true)!=null && op.getDate(false)!=null){                    
                    java.util.Date FirstDate =op.getDate(true).getDate();
                    java.util.Date SecondDate =op.getDate(false).getDate();
                    if(FirstDate!=null && SecondDate!=null&& FirstDate.before(SecondDate)){
                        if(prevFirstDate!=null && prevSecondDate!=null && (prevFirstDate.compareTo(FirstDate)!=0 || prevSecondDate.compareTo(SecondDate)!=0)){
                            int daysCount =  (int) ((SecondDate.getTime() - FirstDate.getTime()) / (1000*60*60*24));
                            op.setCountOsDays(daysCount);
                            op.setStockPrice();
                        }else if(prevFirstDate==null || prevSecondDate==null){
                            int daysCount =  (int) ((SecondDate.getTime() - FirstDate.getTime()) / (1000*60*60*24));
                            op.setCountOsDays(daysCount);
                            op.setStockPrice();
                        }
                        
                    }else{
//                        if(prevFirstDate.compareTo(FirstDate)!=0 || prevSecondDate.compareTo(SecondDate)!=0)
//                            op.setClearFields();
                    }
                    prevFirstDate=FirstDate;
                    prevSecondDate=SecondDate;
                }
            }
    }
    
}

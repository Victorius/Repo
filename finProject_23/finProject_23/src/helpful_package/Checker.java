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
                    if(op.getFlag()&& FirstDate!=null && SecondDate!=null &&FirstDate.after(SecondDate)){
                        javax.swing.JOptionPane.showMessageDialog(null, "Input proper double values", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
    }
    
}

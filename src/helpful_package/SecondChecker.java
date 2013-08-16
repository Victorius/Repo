/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpful_package;

/**
 *
 * @author Admin
 */
public class SecondChecker implements Runnable{
    Thread th = null;
    Checker ch =null;
    public SecondChecker(Thread th, Checker checker){
        this.th=th;
        ch = checker;
    }
    @Override
    public void run() {
        while(true){
            if(!th.isAlive()){
                th = new Thread(ch);
                th.start();
                System.out.println("My slave works");
            }                
        }
    }
    
}

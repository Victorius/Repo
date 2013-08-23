/*
 * DATE: 19/08/2013
 * Second Checker Class
 */

package helpful_package;

/**
 *
 * @author Anastasiia
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
                System.out.println("The second checher is working");
            }                
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpful_package;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;
import handlersOption.CommonHandler;
import handlersOption.EuropeanOption;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class test4test {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        CommonHandler ch = new CommonHandler();
        ch =new EuropeanOption();
//        ch.Call();
//        System.out.println(ch.getCurrencyPair());
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        System.out.println(n.cdf(-0.3253));
        File f = new File("D:\\temp\\data2Nastya\\historical data\\AUD-USD\\AUDUSD_Candlestick_1_M_ASK_01.03.2008-01.03.2012.csv");
        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);
        ArrayList<String> art = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        String a=bf.readLine();
        temp.add(a+"\n");
        while((a=bf.readLine())!=null){
            art.add(a.substring(0,a.indexOf(" ")));
            temp.add(a.substring(a.indexOf(" "))+"\n");            
        }
        String tempstr = "";
        for(int i=0;i<art.size();i++){
            tempstr=art.get(i);
            art.set(i, tempstr.substring(tempstr.lastIndexOf(".")+1)+"-"+tempstr.substring(tempstr.indexOf(".")+1,tempstr.lastIndexOf("."))+"-"
                    +tempstr.substring(0,tempstr.indexOf(".")));
        }
        File destination = new File("D:\\temp\\data2Nastya\\historical data\\audusd1.csv");
        if(!destination.exists())
            destination.createNewFile();
        FileWriter fw = new FileWriter(destination);
        fw.write(temp.get(0));
        for(int i=0;i<art.size();i++){
            fw.write(art.get(i)+temp.get(i+1));
        }
        fw.close();
        
    }
}

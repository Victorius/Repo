/*
 * DATE: 14/08/2013
 * European Option Class
 */

package handlersOption;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;

/**
 *
 * @author Anastasiia
 */

public class EuropeanOption extends CommonHandler{
    public Double[][] S,v;
    private Double  dt=0.0;
    public EuropeanOption(){
        this.optionName="EUROPEAN";
        this.DefinitionOfOption="This is European option type.";
    }
    
    
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(S/X)+(r-rf+a*a/2)*T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        Double res = S*Math.pow(Math.E, -rf*T)*n.cdf(d1)-X*Math.pow(Math.E, -r*T)*n.cdf(d2);
        return res;
    }
    
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(S/X)+(r-rf+a*a/2)*T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        Double res = X*(Math.pow(Math.E, -r*T))*n.cdf(-d2)-S*(Math.pow(Math.E, -rf*T))*n.cdf(-d1);
        return res;
    }    
//@Override
//    public Double Call(double S,double X, double r,double rf, double T,double a){
//        int N= 0;
//        if(T>120){
//            dt=30.0;
//            N=(int)Math.round(T/dt);
//        }else{
//            N=5;
//            dt = T/N;
//        }
//        this.S = new Double[N][N];
//        v= new Double[N][N];
//        fillTreeS(S,a,dt);
//        for(int i=0;i<this.S.length;i++){
//            v[this.S.length-1][i]=call(X,this.S.length-1,i);
//        }
//        for(int i=this.S.length-2;i>=0;i--)
//            for(int j=0;j<=i;j++){
//                double p=getProb(r,rf,dt,Math.exp(a*Math.sqrt(dt)));
//                v[i][j] = Math.max(0.0, Math.exp(-r*dt)*( p*v[i+1][j]+(1-p)*v[i+1][j+1]));
//            }
//        
//        return v[0][0];
//    }
//    
//    @Override
//    public Double Put(double S,double X, double r,double rf, double T,double a){        
//        int N= 0;
//        if(T>120){
//            dt=30.0;
//            N=(int)Math.round(T/dt);
//        }else{
//            N=5;
//            dt = T/N;
//        }
//        this.S = new Double[N][N];
//        v= new Double[N][N];
//        fillTreeS(S,a,dt);
//        for(int i=0;i<this.S.length;i++){
//            v[this.S.length-1][i]=put(X,this.S.length-1,i);
//        }
//        for(int i=this.S.length-2;i>=0;i--)
//            for(int j=0;j<=i;j++){
//                double p=getProb(r,rf,dt,Math.exp(a*Math.sqrt(dt)));
//                v[i][j] = Math.max(0.0, Math.exp(-r*dt)*( p*v[i+1][j]+(1-p)*v[i+1][j+1]));
//            }
//        
//        return v[0][0];
//    }
    
    private Double put(double X, int i, int j){
        return 1000*Math.max(X-this.S[i][j],0);        
    }
    private Double call(double X, int i, int j){
        return 1000*Math.max(0,this.S[i][j]-X);
    }
    
    public void fillTreeS(double s0, double a,double dt){
        double u = Math.exp(a*Math.sqrt(dt));
        for(int i=0;i<this.S.length;i++)
            for(int j=0;j<i+1;j++){
                this.S[i][j]=s0*Math.pow(u, i-j)*Math.pow(1/u, j);                
            }
        
    }
    
    private Double getProb(double r, double rf, double dt, double u){
        Double p = (Math.exp((r-rf)*dt) - 1/u)/(u-1/u);
        return p;
    }
    
    
}

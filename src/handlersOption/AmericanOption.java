/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;


public class AmericanOption extends CommonHandler{    
    public Double[][] S,v;
    public AmericanOption(int N){
        S = new Double[N][N];
        this.optionName="AMERICAN";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        
        return 0.0;
    }
    
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){
        double dt=0.0;
        for(int i=0;i<this.S.length;i++){
            v[this.S.length-1][i]=put(X,this.S.length-1,i);
        }
        for(int i=this.S.length-2;i>0;i--)
            for(int j=0;j<i;j++){
                double p=getProb(r,rf,dt,Math.exp(a*Math.sqrt(dt)));
                v[i][j] = Math.max(put(X,i,j), Math.exp(-r*dt)*( p*v[i+1][j]+(1-p)*v[i+1][j+1]));
            }
        
        return v[0][0];
    }
    
    public Double put(double X, int i, int j){
        return 1000*Math.max(X-this.S[j][i],0);        
    }
    public Double call(double X, int i, int j){
        return 1000*Math.max(0,this.S[i][j]-X);
    }
    public void fillTreeS(double s0, double a,double dt){
        double u = Math.exp(a*Math.sqrt(dt));
        for(int i=0;i<S.length;i++)
            for(int j=0;j<i+1;j++){
                S[i][j]=s0*Math.pow(u, i)*Math.pow(1/u, j-i);                
            }
        
    }
    
    public Double getProb(double r, double rf, double dt, double u){
        Double p = (Math.exp((r-rf)*dt) - 1/u)/(u-1/u);
        return 0.0;
    }
}

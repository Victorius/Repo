/*
 * DATE: 16/08/2013
 * American Option Class
 */

package handlersOption;

/**
 *
 * @author Anastasiia
 */


public class AmericanOption extends CommonHandler{    
    public Double[][] S,v;
    private Double  dt=2.0;
    public AmericanOption(){
        this.optionName="AMERICAN";
        this.DefinitionOfOption = "\n" +
                                             "American Call/Put Option\n" +
                                             "________________________\n" +
                                             "is an option which can be\n" +
                                             "exercised at any up to\n" +
                                             "the option expiry date.";
    }
    
    @Override
    public Double Call(double S,double X, double r,double rf, double T,double a){
        int N= 0;
        if(T>120){
            dt=30.0;
            N=(int)Math.round(T/dt);
        }else{
            N=5;
            dt = T/N;
        }
        this.S = new Double[N][N];
        v= new Double[N][N];
        fillTreeS(S,a,dt);
        for(int i=0;i<this.S.length;i++){
            v[this.S.length-1][i]=call(X,this.S.length-1,i);
        }
        for(int i=this.S.length-2;i>=0;i--)
            for(int j=0;j<=i;j++){
                double p=getProb(r,rf,dt,Math.exp(a*Math.sqrt(dt)));
                v[i][j] = Math.max(call(X,i,j), Math.exp(-r*dt)*( p*v[i+1][j]+(1-p)*v[i+1][j+1]));
            }
        
        return v[0][0];
    }
    
    @Override
    public Double Put(double S,double X, double r,double rf, double T,double a){        
        int N= 0;
        if(T>120){
            dt=30.0;
            N=(int)Math.round(T/dt);
        }else{
            N=5;
            dt = T/N;
        }
        this.S = new Double[N][N];
        v= new Double[N][N];
        fillTreeS(S,a,dt);
        for(int i=0;i<this.S.length;i++){
            v[this.S.length-1][i]=put(X,this.S.length-1,i);
        }
        for(int i=this.S.length-2;i>=0;i--)
            for(int j=0;j<=i;j++){
                double p=getProb(r,rf,dt,Math.exp(a*Math.sqrt(dt)));
                v[i][j] = Math.max(put(X,i,j), Math.exp(-r*dt)*( p*v[i+1][j]+(1-p)*v[i+1][j+1]));
            }
        
        return v[0][0];
    }
    
    private Double put(double X, int i, int j){
        return Math.max(X-this.S[i][j],0);        
    }
    private Double call(double X, int i, int j){
        return Math.max(0,this.S[i][j]-X);
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

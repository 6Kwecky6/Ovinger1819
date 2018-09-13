package probability;

public class Oving_1 {

    public static void main(String args[]){
        int minIndex = 4;
        int maxIndex = 7;
        double[] x = {0, 0.3, 0.5, 0.6, 0.7, 0.8, 1.0, 1.2, 1.6};
        double[] p = {(double)1/28, (double)2/28, (double)5/28, (double)8/28, (double)5/28, (double)3/28, (double)2/28, (double)3/56, (double)1/56};
        double[] distribRes = distribFunc(p, x);
        System.out.println("Forventning: " + expecValue(p,x) + "\n" +
                "Variansen: " +variance(p,x) + "\n" +
                "Standard avviket: " + stdVar(p,x) + "\n" +
                "fordelings funksjon:");
        for(int i=minIndex; i<=maxIndex; i++){
            System.out.println("x: " + x[i] + ", P(x=X): " + distribRes[i]);
        }
    }

    public static double expecValue(double[] p,double[] x){
        double res=0;
        for(int i = 0; i< p.length; i++){
            res += x[i]*p[i];
        }
        return res;
    }
    public static double variance(double[] p, double[] x){
        double[] expecValExp = new double[x.length];
        for(int i = 0; i<expecValExp.length; i++){
            expecValExp[i] = x[i]*x[i];
        }
        double eVal = expecValue(p, x);
        double res = expecValue(p, expecValExp)-eVal*eVal;
        if(res < 0)return res*-1;
        else return res;
    }

    public static double stdVar(double[] p, double[] x){
        return Math.sqrt(variance(p, x));
    }

    public static double[] distribFunc(double[] p, double[] x){
        double[] distrib = new double[p.length];
        double curDubl = 0;
        for(int i = 0; i<distrib.length; i++){
            curDubl += p[i];
            distrib[i] = curDubl;
        }
        return distrib;
    }

}


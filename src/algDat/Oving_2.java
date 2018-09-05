package algDat;

import java.util.Date;

public class Oving_2 {

    public static void main(String args[]){
        //System.out.println(recu1(4, 2));
        //System.out.println(recu2(4, 2));
        Date start = new Date();
        int r = 0;
        double recu1,recu2,recu3;
        double time1, time2, time3;
        Date end;
        do{
            recu1 = recu1(Double.parseDouble(args[0]), Integer.parseInt(args[1]));
            end = new Date();
            ++r;
        }while(end.getTime()-start.getTime() <1000);
        time1 = (double)(end.getTime()-start.getTime())/r;

        r =0;
        start = new Date();
        do{
            recu2 = recu2(Double.parseDouble(args[0]), Integer.parseInt(args[1]));
            end = new Date();
            ++r;
        }while(end.getTime()-start.getTime() <1000);
        time2 = (double)(end.getTime()-start.getTime())/r;

        r =0;
        start = new Date();
        do{
            recu3 = Math.pow(Double.parseDouble(args[0]), Integer.parseInt(args[1]));
            end = new Date();
            ++r;
        }while(end.getTime()-start.getTime() <1000);
        time3 = (double)(end.getTime()-start.getTime())/r;

        System.out.println("Method 1 in milliseconds per round: " + time1 +"\n" +
                "The method will return " + recu1 +"\n" +
                "Method 2 in millisecond per round: " +time2 +"\n" +
                "The method will return " +recu2 +"\n" +
                "Millisecond per round for internal method: " + time3 + "\n" +
                "This method returns " + recu3);

    }

    static double recu1(double x, int n) {
        if (n > 0) {
            return recu1(x, n-1)*x;
        }else{
            return 1;
        }
    }

    static double recu2(double x, int n){
        if(n== 0) {
            return 1;
        }else if(n%2 ==0){//partall
            return even(x, n);
        }else {//Oddetall
            return odd(x, n);

        }

    }

    static double odd(double x, int n){
       return  recu2(x*x,(n-1)/2)*x;
    }

    static double even(double x, int n){
       return  recu2(x*x, n/2);
    }
}

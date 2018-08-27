package algDat;

import java.util.Date;

public class Oving_1 {
    public static void main(String args[]){
        int r = 0;
        double time;
        Date end;
        Date start = new Date();
        do{
            optimalBS(new int[]{-1,3,-9,2,2,-1,2,-1,-5,4,-1,3,-9,2,2,-1,2,-1,-5,4});
            end= new Date();
            ++r;
        }while(end.getTime()-start.getTime() < 1000);
        time = (double)(end.getTime()-start.getTime())/r;
        System.out.println("Milliseconds pr round: " + time);

        //int[] res = optimalBS(new int[]{-1,3,-9,2,2,-1,2,-1,-5});
        //System.out.println("Buy:" + res[0] +". \nSell:" + res[1] + ".\nProfit: " + (res[1]-res[0]));
    }
    //1-1
    public static int[] optimalBS(int[] stocks){ //returned index 0 is buy time and index 1 is sell time
        int dumbStocks=0;
        int minStock=dumbStocks;
        int[] curBestBuy = new int[2];
        for(int i=0;i<stocks.length;i++){
            dumbStocks+=stocks[i];
            if(minStock>dumbStocks){
                int dumbSellStocks = dumbStocks;
                for (int j=i+1;j<stocks.length;j++){
                    dumbSellStocks += stocks[j];
                    if(curBestBuy[1]-curBestBuy[0]<dumbSellStocks-dumbStocks){
                        curBestBuy = new int[]{dumbStocks, dumbSellStocks};
                    }
                }
            }
        }
        if(curBestBuy[0] == 0 && curBestBuy[1] == 0){//In case the stocks only rises, and won't give a "Good" buy point
            return new int[]{0,dumbStocks};
        }

        return curBestBuy;
    }

}
/*
************ANALYSE 1-2**************
* Øvre grense:
* f(n)= 5 +8n + 4n^2 //nøstet løkke er j=i, så vi kan dele den på 2
* O(n^2)
* 0 <= 4n^2+8n+5 <= cn^2 |/n^2
* 0 <= 4+8/n+5/n^2 <= c
* velger n0=4 og c=7,5
* 0 <= 6+5/4 <= 7,5
* O(n^2)=7,5n^2
*
* Nedre grense:
* f(n) = 5+5n //Regner med if-settningen ikke kjører
* "Omega"(n) Tetta kan ikke bli uttrykt, siden "omega"(g(n)) != O(g(n))
 */

/*
********************ANALYSE 1-3*****************
* n=10 --> 0.00011732502234161739ms
* n=20 --> 0.00029655656312295415ms
* n=30 --> 0.000730653927958984ms
* n=40 --> 0.0010660833058816883ms
* n=50 --> 0.0018868921376978406ms
*
* Først må vi finne maskinvare konstanten
* c=0.00011732502234161739/10^2
* c=0.0000011732502234161739
* t20 = 0.0000011732502234161739*20^2
* t20 = 0.00046930008936646956ms Dette stemmer, siden dette er øvre grense, og den faktiske tiden er en delunder dette
*
 */
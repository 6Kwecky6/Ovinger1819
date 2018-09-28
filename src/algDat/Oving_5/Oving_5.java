package algDat.Oving_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Oving_5 {
    private  int coliCount = 0;
    public int genHash(String val, int htLength){
        int res = 0;
        for(int i = 0; i<val.length(); i++){
            res +=(int)val.charAt(i)*(i+1);
        }
        return res%htLength;
    }

    public int probe(int h, int i, int htLength){
        return (h+2*i+3*i*i)%htLength;
    }

    public int add(String key, String[] hashTab){
        int hash = genHash(key, hashTab.length);
        for(int i = 0; i<hashTab.length; i++){
            if(hashTab[i] == null){
                hashTab[j] = key;
                return j;
            }else{
		
                System.out.println("Collision on key:\t" + key + "\t--->\t" + hashTab[j]);
                coliCount++;
            }
        }
        return -1;//full
    }
    public int find(String key, String[] hashTab){
        int hash = genHash(key, hashTab.length);
        for(int i = 0; i<hashTab.length; i++){
            int j = probe(hash, i, hashTab.length);
            if(hashTab[j] == null){
                return -2;//not found
            }
            if(hashTab[j].equals(key)){
                return j;
            }else{
                System.out.println("Collision on key:\t" + key + "\t--->\t" + hashTab[j]);
                coliCount++;
            }
        }
        return -1; //Finnes ikke, og fullt
    }
    public int getColiCount(){
        return coliCount;
    }

    public static void main(String args[]){
        Oving_5 hashedArray = new Oving_5();
        int hLength = 109;
        int usedLength = 0, amtSearch = 0;
        String[] list = new String[hLength];
        try {
            URL url = new URL("http://www.aitel.hist.no/fag/_alg/hash/navn");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String read;
            while((read = in.readLine()) !=null){
                //System.out.println(read);
                hashedArray.add(read, list);
                usedLength++;

            }
            in.close();
        }catch (MalformedURLException e){
            System.out.println("MalformedURLException : " +e);
        }catch(IOException e){
            System.out.println( "IOException " +e);
        }
        System.out.println("load Factor: " + (double)usedLength/(double)hLength + "\nCollision per person: " + (double)hashedArray.getColiCount()/(double)(amtSearch+usedLength));
        //System.out.println(list[hashedArray.find("Helgeland,Kevin Andre", list)]);
    }
}

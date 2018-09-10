package algDat;

import java.util.Date;
import java.util.Random;

public class Oving_3 {

    public static void main(String args[]){
	int[] pivotList, dualList;
        Date end;
        Date start = new Date();
        int rounds = 0;
        do {
/*	    for(int i = 0; i<list.length; i++){
	   System.out.print(list[i]+" ");
}*/
            pivotList = genList(Integer.parseInt(args[0]));
            singlePivot(pivotList, 0, pivotList.length - 1);
            end = new Date();
            rounds++;
//System.out.println();
        }while(end.getTime()-start.getTime()<1000);
        printList(pivotList, (double)(end.getTime()-start.getTime())/rounds);
        rounds = 0;
        start = new Date();
        do {
            dualList = genList(Integer.parseInt(args[0]));
            dualPivot(dualList, 0, dualList.length - 1);
            end= new Date();
            rounds++;
//	System.out.println();
        }while(end.getTime()-start.getTime()<1000);
        printList(dualList, (double)(end.getTime()-start.getTime())/rounds);

        System.out.println("-----------------Sorted speed------------------");
        rounds = 0;
        start = new Date();
        do {
            singlePivot(pivotList, 0, dualList.length - 1);
            end = new Date();
            rounds++;
        }while(end.getTime()-start.getTime()<1000);
        printList(pivotList, (double)(end.getTime()-start.getTime())/rounds);
        rounds = 0;
        start = new Date();
        do {
            dualPivot(dualList, 0, dualList.length - 1);
            end= new Date();
            rounds++;
        }while(end.getTime()-start.getTime()<1000);
        printList(dualList, (double)(end.getTime()-start.getTime())/rounds);
        System.out.println("-----------------Duplicate value speed--------------");
        int[] dupeList = genDupeList(Integer.parseInt(args[0]));
        printList(dupeList, 0);
        int[] singleDupe, doubleDupe;
        start = new Date();
        rounds = 0;
        do {
            singleDupe = dupeList;
            singlePivot(singleDupe, 0, singleDupe.length - 1);
            end = new Date();
            rounds++;
        }while(end.getTime()-start.getTime()<1000);
        printList(singleDupe, (double)(end.getTime()-start.getTime())/rounds);
        rounds = 0;
        start = new Date();
        do {
            doubleDupe = dupeList;
            dualPivot(doubleDupe, 0, doubleDupe.length - 1);
            end= new Date();
            rounds++;
        }while(end.getTime()-start.getTime()<1000);
        printList(doubleDupe, (double)(end.getTime()-start.getTime())/rounds);

    }

    public static void printList(int[] list, double time){
        System.out.println("ListPrint");
        boolean sorted = true;
        for(int i = 0; i<list.length -1; i++) {
            System.out.print(list[i] + ", ");
            if (list[i]>list[i+1]) {
                sorted = false;
            }
        }
        System.out.println("Using "+time+"ms per round.\nIs " + sorted);
    }

    public static void singlePivot(int[] list,  int minIndex, int maxIndex){
        if(maxIndex-minIndex>2){
            int splitIndex = split(list, minIndex, maxIndex);
            singlePivot(list, minIndex, splitIndex-1);
            singlePivot(list, splitIndex+1, maxIndex);

        }else quickFinish(list, minIndex, maxIndex);
    }

    public static void dualPivot(int[] list, int minIndex, int maxIndex){
        if(minIndex<maxIndex) {
            int[] part = dualSplit(list, minIndex, maxIndex);//index 0 is left, index 1 is right
            dualPivot(list, minIndex, part[0]-1);
            dualPivot(list, part[0]+1, part[1]-1);
            dualPivot(list, part[1] +1, maxIndex);
        }
    }

    public static int[] dualSplit(int[] list, int minIndex, int maxIndex){
        if(list[minIndex]>list[maxIndex]){
            swap(list, minIndex, maxIndex);
        }
        int[] partIndex = {minIndex+1, maxIndex-1};
        int tempL = minIndex+1,minVal = list[partIndex[0]], maxVal = list[partIndex[1]];
        while(tempL<=partIndex[1]){
            if(list[tempL]<minVal){
                swap(list, tempL, partIndex[0]);
                partIndex[0]++;
            }else if(list[tempL]>= maxVal){
                while(list[partIndex[1]]>maxVal && tempL<partIndex[1]) partIndex[1]--;
                swap(list, tempL, partIndex[1]);
		partIndex[1]--;
                if(list[tempL]<minVal){
                    swap(list, tempL, partIndex[0]);
                    partIndex[0]++;
                }
            }
            tempL++;
        }
        partIndex[0]--;
        partIndex[1]++;

        swap(list, minIndex, partIndex[0]);
        swap(list, maxIndex, partIndex[1]);
        return partIndex;

    }

/*
   if(list[minIndex]>list[maxIndex]){
            swap(list, minIndex, maxIndex);
        }
        int[] partIndex = {minIndex+1, maxIndex-1};
        int tempL = minIndex+1,minVal = list[partIndex[0]], maxVal = list[partIndex[1]];
        while(tempL<=partIndex[1]){
            if(list[tempL]<minVal){
                swap(list, tempL, partIndex[0]);
                partIndex[0]++;
            }else if(list[tempL]>= maxVal){
                while(list[--partIndex[1]]>maxVal&&tempL<partIndex[1]);
                swap(list, tempL, partIndex[1]);
                if(list[tempL]<minVal){
                    swap(list, tempL, partIndex[0]);
                    partIndex[0]++;
                }
            }
            tempL++;
        }
        partIndex[0]--;
        partIndex[1]++;

        swap(list, minIndex, partIndex[0]);
        return partIndex;

    }
*/

    public static int split(int[] list, int minIndex, int maxIndex){
        int middleIndex = quickFinish(list, minIndex, maxIndex);
        int middleVal = list[middleIndex];
        int lastIndex = maxIndex;
        swap(list, middleIndex, maxIndex);
        while(true){
            while(list[++minIndex]<middleVal);
            while(list[--maxIndex]>middleVal);

            if(minIndex<maxIndex){
                swap(list, minIndex, maxIndex);
            }else{
                break;
            }
        }
        swap(list, minIndex, lastIndex);
        return minIndex;
    }


    public static int quickFinish(int[] list, int min, int max){
        int middleIndex = (min+max)/2;
        int middleVal = list[middleIndex];
        //System.out.println("Mid index: " +middleIndex+ ", value: " + middleVal);
        if(list[min]>list[middleIndex]){
            swap(list, min, middleIndex);
        }
        if(list[middleIndex]>list[max]){
            swap(list, middleIndex, max);
            if(list[min]>list[middleIndex]){
                swap(list, min, middleIndex);
            }
        }
        //System.out.println("Min val: " + list[min] + ", middle val: " + list[middleIndex] + ", max val: " + list[max]);
        return middleIndex;
    }

    //public static int[] dualPivot()

    public static int[] swap(int[] unsorted, int leftIndex, int rightIndex){
        //System.out.println("Swapping: " +unsorted[leftIndex] + " to " + unsorted[rightIndex]);
        int h = unsorted[rightIndex];
        unsorted[rightIndex]=unsorted[leftIndex];
        unsorted[leftIndex]=h;
        return unsorted;
    }

    public static int[] genList(int length){
        Random rand = new Random();
        int[] ints = new int[length];
        for(int i = 0; i<length; i++){
            ints[i] = rand.nextInt(length) +1;
        }

        return ints;
    }

    public static int[] genDupeList(int length){
        Random rand = new Random();
        int[] ints = new int[length];
        int[] pair = {rand.nextInt(length)+1, rand.nextInt(length)+1};
        for(int i = 0; i<length; i++){
            if(i%2 == 0) ints[i] = pair[0];
            else ints[i] = pair[1];
        }

        return ints;
    }
}

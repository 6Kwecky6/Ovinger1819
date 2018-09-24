package algDat.Oving_4;

import java.math.BigInteger;

public class Structurer {
    private static DoubleChain curDNode;
    private static BinarySearch head;

    public static void main(String args[]){
        //Oppg. 1
        createDChain(new BigInteger("20000000000000000"));
        createDChain(new BigInteger("1234567891011121314151617"));
        System.out.println(add(curDNode, curDNode.getNext()));
        System.out.println(sub(curDNode.getNext(), curDNode));

        //Oppg. 2
        newBin("Guilotine");
        newBin("Baby");
        newBin("xenomorphing");
        newBin("Cowboy");
        transBin(head);

    }

    public static void createDChain(BigInteger val){
        if(curDNode == null){
            curDNode = new DoubleChain(val, null, null);
        }else{
            DoubleChain newNode = new DoubleChain(val, curDNode, null);
            curDNode.setNext(newNode);
        }
    }

    public static BigInteger add(DoubleChain v, DoubleChain w){
        return v.getVal().add(w.getVal());

    }

    public static BigInteger sub(DoubleChain v, DoubleChain w){
        return v.getVal().subtract(w.getVal());
    }

    private static BinarySearch findFree(BinarySearch node, BinarySearch newNode){
        if(node.getLeft()!= null || node.getRight() != null) {
            if (newNode.getWord().compareTo(node.getLeft().getWord()) < 0) {
                return findFree(node.getLeft(), newNode);
            }else{
                return findFree(node.getRight(), newNode);
            }
        }else {
            return node;
        }
    }

    public static void newBin(String word){
        BinarySearch newNode = new BinarySearch(word, null, null);
        if(head == null) {
            head = newNode;
        }else{
            BinarySearch node =findFree(head, newNode);
            if(node.getLeft() ==null){
                node.setLeft(newNode);
            }else{
                node.setRight(newNode);
            }
        }

    }

    public static void transBin(BinarySearch node){
        System.out.println(node.getWord());
        if(node.getLeft() != null) {
            transBin(node.getLeft());
        }
        if(node.getRight() != null) {
            transBin(node.getRight());
        }
    }

}

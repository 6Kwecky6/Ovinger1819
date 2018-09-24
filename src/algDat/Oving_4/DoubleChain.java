package algDat.Oving_4;

import java.math.BigInteger;

public class DoubleChain {
    private DoubleChain last;
    private DoubleChain next;
    private final BigInteger val;

    public DoubleChain(BigInteger val, DoubleChain last, DoubleChain next){
        this.val = val;
        this.last = last;
        this.next = next;
    }

    public void setNext(DoubleChain next){
        this.next = next;
    }

    public void setLast(DoubleChain last){
        this.last = last;
    }

    public DoubleChain getLast() {
        return last;
    }

    public DoubleChain getNext() {
        return next;
    }

    public BigInteger getVal() {
        return val;
    }
}

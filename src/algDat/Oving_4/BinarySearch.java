package algDat.Oving_4;

public class BinarySearch {
    private BinarySearch left;
    private BinarySearch right;
    private final String word;

    public BinarySearch(String word, BinarySearch left, BinarySearch right){
        this.word = word;
        this.left = left;
        this.right = right;
    }

    public BinarySearch getLeft(){
        return left;
    }

    public BinarySearch getRight() {
        return right;
    }

    public String getWord() {
        return word;
    }

    public void setLeft(BinarySearch left){
        this.left = left;
    }

    public void setRight(BinarySearch right){
        this.right = right;
    }
}

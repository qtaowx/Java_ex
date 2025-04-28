package hexinlei;

public class Adder {
    private int sum = 0;

    public Adder add(int n){
        sum += n;
        return this;
    }

    public Adder inc() {
        sum ++;
        return this;
    }

    public int value() {
        return sum;
    }
}

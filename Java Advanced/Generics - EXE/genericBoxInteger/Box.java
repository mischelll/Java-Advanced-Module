package JavaAdvancedExe.genericBoxInteger;

public class Box<T> {
    private T input;

    public Box(T input) {
        this.input = input;
    }

    public String toString(){
        return String.format("%s: %d",input.getClass().getName(),input);
    }
}

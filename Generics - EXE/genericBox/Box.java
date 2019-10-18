package JavaAdvancedExe.genericBox;

public class Box<T> {
    private T input;

    public Box(T input) {
        this.input = input;
    }

    public String toString() {
        return input.getClass().getName() + ": " + this.input;
    }
}

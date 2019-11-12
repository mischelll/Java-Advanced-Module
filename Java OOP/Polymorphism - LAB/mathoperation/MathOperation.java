package javaooplabs.mathoperation;

public class MathOperation {

    public int add(int a, int b) {
        return sumTwoVars(a, b);
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return sumTwoVars(a, b) + sumTwoVars(c, d);
    }


    private int sumTwoVars(int a, int b) {
        return a + b;
    }
}

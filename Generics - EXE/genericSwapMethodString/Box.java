package JavaAdvancedExe.genericSwapMethodString;

import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box(List<T> list) {
        this.list = list;
    }

    public void swap(List<T> list, int index1, int index2) {
        T element1 = list.get(index1);
        T element2 = list.get(index2);

        list.set(index2, element1);
        list.set(index1, element2);

    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T t : list) {
            stringBuilder.append(t.getClass().getName() + ": " + t);
            stringBuilder.append(System.getProperty("line.separator"));
        }

        return stringBuilder.toString();
    }
}

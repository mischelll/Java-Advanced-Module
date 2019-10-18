package JavaAdvancedExe.genericCountMethodString;

import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box(List<T> list) {
        this.list = list;
    }

    public int getCount(List<T> list, T element){
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }
}

package JavaAdvancedExe.customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public boolean contains(T element) {
        if (this.list.contains(element)) {
            return true;
        }

        return false;
    }

    public int getSize(){
        return list.size();
    }

    public T remove(int index) {

        return this.list.remove(index);

    }

    public void swap(int index, int index2) {
        Collections.swap(this.list,index,index2);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public List<T> getList() {
        return list;
    }

    public T getMax() {
        if (this.list.isEmpty()) {
            throw new IllegalArgumentException("max on empty list");
        }


        return Collections.max(this.list);
    }

    public T getMin() {
        if (this.list.isEmpty()) {
            throw new IllegalArgumentException("min on empty list");
        }

        T min = list.get(0);
        for (T t : list) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }

        return min;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < getSize();
            }

            @Override
            public T next() {
                return list.get(this.counter++);
            }
        };
    }
}

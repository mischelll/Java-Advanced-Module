package JavaAdvancedExe.customList;


public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.getSize() - 1; i++) {
            for (int j = i + 1; j < list.getSize(); j++) {
                if (list.getList().get(i).compareTo(list.getList().get(j)) > 0) {
                    list.swap(i, j);
                }
            }

        }
    }
}

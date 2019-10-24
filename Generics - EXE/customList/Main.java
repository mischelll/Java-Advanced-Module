package JavaAdvancedExe.customList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        CustomList<String> stringCustomList = new CustomList<>();
        while (!"END".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String action = data[0];



            switch (action) {
                case "Add":
                    String element = data[1];
                    stringCustomList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(data[1]);
                    stringCustomList.remove(index);
                    break;
                case "Contains":
                    element = data[1];
                    System.out.println(stringCustomList.contains(element));
                    break;
                case "Greater":
                    element = data[1];
                    System.out.println(stringCustomList.countGreaterThan(element));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(data[1]);
                    int index2 = Integer.parseInt(data[2]);
                    stringCustomList.swap(index1,index2);
                    break;
                case "Max":
                    System.out.println(stringCustomList.getMax());
                    break;
                case "Min":
                    System.out.println(stringCustomList.getMin());
                    break;
                case "Print":
                    for (String s : stringCustomList) {
                        System.out.println(s);
                    }
                    break;
                case "Sort":
                    Sorter.sort(stringCustomList);
                    break;
            }

        }
    }
}

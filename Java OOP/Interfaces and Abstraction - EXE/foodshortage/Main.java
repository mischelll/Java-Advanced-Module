package foodshortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        while (N-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            if (data.length == 4) {
                citizens.add(new Citizen(data[0]
                        , Integer.parseInt(data[1])
                        , data[2]
                        , data[3]));
            } else {
                rebels.add(new Rebel(data[0]
                        ,Integer.parseInt(data[1])
                        ,data[2]));
            }
        }

        String command = "";

        while (!"End".equals(command = reader.readLine())){
            boolean contains = false;
            for (Citizen citizen : citizens) {
                if (citizen.getName().equals(command)){
                    citizen.buyFood();
                    contains = true;
                    break;
                }
            }

            if (!contains){
                for (Rebel rebel : rebels) {
                    if (rebel.getName().equals(command)){
                        rebel.buyFood();
                        break;
                    }
                }
            }
        }

        int sum = citizens.stream().mapToInt(Citizen::getFood).sum();
        sum += rebels.stream().mapToInt(Rebel::getFood).sum();

        System.out.println(sum);

    }
}

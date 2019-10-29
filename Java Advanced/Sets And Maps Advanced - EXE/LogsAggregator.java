package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> userTime = new TreeMap<>();
        Map<String, Set<String>> userIPs = new TreeMap<>();

        int n = Integer.parseInt(bf.readLine());
        while (n-- > 0){
            String[] data = bf.readLine().split("\\s+");

            String IP = data[0];
            String name = data[1];
            int time = Integer.parseInt(data[2]);

            userTime.putIfAbsent(name,0);
            userTime.put(name,userTime.get(name) + time);

            userIPs.putIfAbsent(name, new TreeSet<>());
            userIPs.get(name).add(IP);

        }

        userTime
                .entrySet()
                .stream()
                .forEach(e -> {
                    System.out.printf("%s: %d %s%n",e.getKey(),e.getValue(),userIPs.get(e.getKey()).toString());

                });
    }
}

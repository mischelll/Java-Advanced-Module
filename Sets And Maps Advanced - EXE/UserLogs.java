package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> usernameIPCount = new TreeMap<>();

        String input = "";
        while (!"end".equals(input = bf.readLine())) {
            String[] data = input.split("\\s+");

            int indexIP = data[0].indexOf("=");
            String IP = data[0].substring(indexIP + 1);

            int indexUser = data[2].indexOf("=");
            String user = data[2].substring(indexUser + 1);

            usernameIPCount.putIfAbsent(user, new LinkedHashMap<>());
            usernameIPCount.get(user).putIfAbsent(IP, 0);
            usernameIPCount.get(user).put(IP, usernameIPCount.get(user).get(IP) + 1);
        }


        usernameIPCount.entrySet().forEach(e -> {
            System.out.printf("%s: %n", e.getKey());
            AtomicInteger size = new AtomicInteger();
            size.set(e.getValue().size());
            e.getValue().entrySet().stream().forEach(w -> {
                if (size.get() == 1){
                    System.out.printf("%s => %d.%n",w.getKey(),w.getValue());
                }else {
                    System.out.printf("%s => %d, ",w.getKey(),w.getValue());
                }
                size.decrementAndGet();
            });
        });

    }
}

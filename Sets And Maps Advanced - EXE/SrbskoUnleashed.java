package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrbskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> venueSingerMoney = new LinkedHashMap<>();

        String regex = "(?<name>.*?) @(?<venue>.*?) (?<ticketsPrice>\\d+) (?<ticketsCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String input = "";

        while (!"End".equals(input = bf.readLine())) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String singer = matcher.group("name");
                String venue = matcher.group("venue");
                long ticketsPrice = Long.parseLong(matcher.group("ticketsPrice"));
                long ticketsCount = Long.parseLong(matcher.group("ticketsCount"));

                venueSingerMoney.putIfAbsent(venue, new LinkedHashMap<>());
                venueSingerMoney.get(venue).putIfAbsent(singer, 0L);
                venueSingerMoney.get(venue).put(singer, venueSingerMoney.get(venue).get(singer) + ticketsPrice * ticketsCount);

            }
        }

        venueSingerMoney
                .entrySet()
                .stream()

                .forEach(e -> {
                    System.out.printf("%s%n",e.getKey());
                    e.getValue().entrySet().stream().sorted((x,y) -> Long.compare(y.getValue(),x.getValue())).forEach(w -> {
                        System.out.printf("#  %s -> %d%n",w.getKey(),w.getValue());
                    });
                });


    }
}

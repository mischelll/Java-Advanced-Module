package javaoopexe.trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLight[] lights = Arrays
                .stream(reader.readLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(reader.readLine());

        TrafficLight[] trafficLights = TrafficLight.values();

        while (n-- > 0){
            for (int i = 0; i < lights.length; i++) {
                int index = (lights[i].ordinal() + 1) % trafficLights.length;
                lights[i] = trafficLights[index];
                System.out.print(lights[i].toString() + " ");
            }
            System.out.println();
        }
    }
}

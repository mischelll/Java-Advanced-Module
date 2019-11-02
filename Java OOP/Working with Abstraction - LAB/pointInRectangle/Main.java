package javaooplabs.pointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int X1  = Integer.parseInt(input[0]);
        int Y1  = Integer.parseInt(input[1]);
        int X2  = Integer.parseInt(input[2]);
        int Y2  = Integer.parseInt(input[3]);

        Point point1 = new Point(X1, Y1);
        Point point2 = new Point(X2, Y2);

        Rectangle rectangle = new Rectangle(point1,point2);

        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            input = reader.readLine().split("\\s+");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);

            Point point = new Point(X, Y);
            System.out.println(rectangle.contains(point));
        }
    }
}

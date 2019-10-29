package JavaAdvancedExe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double heiganLife = 3000000;
        double playerLife = 18500;

        int[][] matrix = new int[15][15];
        int playerPositionRow = 7;
        int playerPositonCol = 7;

        String spellPlayerKilledBy = "";
        boolean playerDead = false;
        boolean heiganDead = false;

        double hit = Double.parseDouble(in.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (heiganLife > 0 && playerLife > 0) {
            String[] input = in.nextLine().split(" ");

            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            heiganLife -= hit;

            if (heiganLife <= 0) {
                heiganDead = true;
                while (!stack.isEmpty()) {
                    stack.pop();
                    playerLife -= 3500;

                }
                if (playerLife <= 0) {
                    playerDead = true;
                    spellPlayerKilledBy = "Plague Cloud";
                }
                break;
            }

            if (!stack.isEmpty()) {
                if (stack.pop().equals("Cloud")) {
                    playerLife -= 3500;
                    if (playerLife <= 0) {
                        spellPlayerKilledBy = "Plague Cloud";
                        playerDead = true;
                        break;
                    }
                }
            }


            if (playerIsHit(matrix, row, col, playerPositionRow, playerPositonCol)) {
                boolean receiveHit = false;

                boolean playerPositionUp = playerIsHit(matrix, row, col, playerPositionRow - 1, playerPositonCol);
                if (!playerPositionUp && inRange(matrix, playerPositionRow - 1, playerPositonCol)) {
                    playerPositionRow = playerPositionRow - 1;

                    continue;
                }

                boolean playerPositionRight = playerIsHit(matrix, row, col, playerPositionRow, playerPositonCol + 1);
                if (!playerPositionRight && inRange(matrix, playerPositionRow, playerPositonCol + 1)) {
                    playerPositonCol = playerPositonCol + 1;
                    continue;
                }

                boolean playerPositionDown = playerIsHit(matrix, row, col, playerPositionRow + 1, playerPositonCol);
                if (!playerPositionDown && inRange(matrix, playerPositionRow + 1, playerPositonCol)) {
                    playerPositionRow = playerPositionRow + 1;
                    continue;
                }

                boolean playerPositionLeft = playerIsHit(matrix, row, col, playerPositionRow, playerPositonCol - 1);
                if (!playerPositionLeft && inRange(matrix, playerPositionRow, playerPositonCol - 1)) {
                    playerPositonCol = playerPositonCol - 1;
                    continue;


                }
                receiveHit = true;

                if (receiveHit) {
                    if (spell.equals("Cloud")) {
                        stack.push("Cloud");

                        playerLife -= 3500;
                        if (playerLife <= 0) {
                            spellPlayerKilledBy = "Plague Cloud";
                            playerDead = true;
                            break;
                        }

                    } else if (spell.equals("Eruption")) {

                        playerLife -= 6000;
                        if (playerLife <= 0) {
                            spellPlayerKilledBy = "Eruption";
                            playerDead = true;
                            break;
                        }
                    }

                }
            }
        }

        if (playerDead && heiganDead) {
            System.out.printf("Heigan: Defeated!\n");
            System.out.printf("Player: Killed by %s\n", spellPlayerKilledBy);
            System.out.printf("Final position: %d, %d", playerPositionRow, playerPositonCol);
            return;
        }

        if (playerDead) {
            System.out.printf("Heigan: %.2f\n", heiganLife);
            System.out.printf("Player: Killed by %s\n", spellPlayerKilledBy);
            System.out.printf("Final position: %d, %d", playerPositionRow, playerPositonCol);
        }

        if (heiganDead) {
            System.out.printf("Heigan: Defeated!\n");
            System.out.printf("Player: %.0f\n", playerLife);
            System.out.printf("Final position: %d, %d", playerPositionRow, playerPositonCol);
        }
    }

    static boolean playerIsHit(int[][] matrix, int row, int col, int playerRow, int playerCol) {

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (inRange(matrix, i, j) && i == playerRow && j == playerCol) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean inRange(int[][] matrix, int rows, int cols) {

        return rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[rows].length;
    }

}

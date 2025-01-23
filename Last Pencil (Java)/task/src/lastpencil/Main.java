package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int jacksMove(String leftSticks) {
        Random random = new Random();
        int sticksToSub = 0;
        if (leftSticks.length() == 1) {
            sticksToSub = 1;
        } else {
            switch (leftSticks.length() % 4){
                case 0:
                    sticksToSub = 3;
                    break;
                case 1:
                    sticksToSub = random.nextInt(3) + 1;
                    break;
                case 2:
                    sticksToSub = 1;
                    break;
                case 3:
                    sticksToSub = 2;
                    break;
            }
        }
        System.out.println(sticksToSub);
        return sticksToSub;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initNum;
        int sticksToSub;
        String player, sticks;

        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = scanner.nextLine().trim();

            try {
                initNum = Integer.parseInt(input);

                if (initNum == 0) {
                    System.out.println("The number of pencils should be positive");
                } else if (initNum < 0) {
                    System.out.println("The number of pencils should be numeric");
                } else {
                    sticks = "|".repeat(initNum);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        System.out.println("Who will be the first (John, Jack):");
        player = scanner.nextLine();

        while (true) {
            if (player.equals("Jack") || player.equals("John")) {
                System.out.println(sticks);
                System.out.println(player + "'s turn!");
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
                player = scanner.nextLine();
            }
        }

        while (!sticks.isEmpty()) {

            if (player.equals("Jack")) {
                sticks = "|".repeat(sticks.length() - jacksMove(sticks));
                if (sticks.isEmpty()) {
                    player = "John";
                    System.out.println(player + " won!");
                    break;
                } else {
                    System.out.println(sticks);
                    player = "John";
                    System.out.println(player + "'s turn!");
                }
            }

            if (scanner.hasNextInt()) {
                sticksToSub = scanner.nextInt();
                if (sticksToSub < 1 || sticksToSub > 3) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (sticksToSub > sticks.length()) {
                    System.out.println("Too many pencils were taken");
                } else {
                    sticks = "|".repeat(sticks.length() - sticksToSub);
                    player = player.equals("John") ? "Jack" : "John";

                    if (sticks.isEmpty()) {
                        System.out.println(player + " won!");
                        break;
                    }

                    System.out.println(sticks);
                    System.out.println(player + "'s turn!");
                }
            } else {
                System.out.println("Possible values: '1', '2' or '3'");
                scanner.nextLine();
            }
        }
    }
}
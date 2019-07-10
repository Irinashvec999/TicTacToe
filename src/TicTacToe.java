import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static String[] area;
    static String mark;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        area = new String[9];
        mark = "X";
        String winner = null;
        initializeBoard();

        System.out.println("*************************************\n" +
                "Welcome to  Tic Tac Toe!\n" +
                "*************************************");
        System.out.println("Please, chose the place number of your mark:");
        printBoard();
        System.out.println("Enter a number to place X:");

        while (winner == null) {
            int numInput;
            try {
                numInput = scanner.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input. Please, re-enter place number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please, re-enter place number:");
                break;
            }
            if (area[numInput - 1].equals(String.valueOf(numInput))) {
                area[numInput - 1] = mark;
                if (mark.equals("X")) {
                    mark = "O";
                } else {
                    mark = "X";
                }
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Place already token, please, re-enter the number:");
                continue;
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }

    static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = area[0] + area[1] + area[2];
                    break;
                case 1:
                    line = area[3] + area[4] + area[5];
                    break;
                case 2:
                    line = area[6] + area[7] + area[8];
                    break;
                case 3:
                    line = area[0] + area[3] + area[6];
                    break;
                case 4:
                    line = area[1] + area[4] + area[7];
                    break;
                case 5:
                    line = area[2] + area[5] + area[8];
                    break;
                case 6:
                    line = area[0] + area[4] + area[8];
                    break;
                case 7:
                    line = area[2] + area[4] + area[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(area).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) return "draw";
        }

        System.out.println(mark + "'s mark now. Please, enter a number to place" + mark + " :");
        return null;
    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + area[0] + " | " + area[1] + " | " + area[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + area[3] + " | " + area[4] + " | " + area[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + area[6] + " | " + area[7] + " | " + area[8] + " |");
        System.out.println("|---|---|---|");
    }

    static void initializeBoard() {
        for (int a = 0; a < 9; a++) {
            area[a] = String.valueOf(a + 1);
        }
    }
}


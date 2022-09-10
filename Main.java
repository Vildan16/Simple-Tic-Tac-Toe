package tictactoe;

import java.util.Scanner;

public class Main {
    private static char[][] grid;

    public static void main(String[] args) {
        String gridString = "         ";
        char c = 'X';
        initGrid(gridString);
        printGrid();
        while (true) {
            c = c == 'X' ? 'O' : 'X';
            takeMove(c);
            printGrid();
            String result = getResult();
            if (result != null) {
                System.out.println(result);
                break;
            }
        }
    }

    private static void takeMove(char c) {
        Scanner scanner = new Scanner(System.in);
        char xChar = scanner.next().charAt(0);
        char yChar = scanner.next().charAt(0);

        if (!Character.isDigit(xChar) || !Character.isDigit(yChar)) {
            System.out.println("You should enter numbers!");
            takeMove(c);
            return;
        } else if (xChar < '1' || xChar > '3' || yChar < '1' || yChar > '3') {
            System.out.println("Coordinates should be from 1 to 3!");
            takeMove(c);
            return;
        }
        int x = Integer.parseInt(String.valueOf(xChar));
        int y = Integer.parseInt(String.valueOf(yChar));

        if (grid[x - 1][y - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            takeMove(c);
        }
        else
            grid[x - 1][y - 1] = c;
    }

    private static void initGrid(String gridString) {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = gridString.charAt(i * 3 + j);
            }
        }
    }

    private static void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 || j == 4)
                    System.out.print("|");
                else
                    System.out.print(grid[i][j - 1]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static String getResult() {
        String result = null;
        String gridString = String.valueOf(grid[0]) + String.valueOf(grid[1]) + String.valueOf(grid[2]);

        if (isWinner(gridString, 'X'))
            result = "X wins";
        else if (isWinner(gridString, 'O'))
            result = "O wins";
        else if (!gridString.contains(" "))
            result = "Draw";
        return result;
    }

    private static boolean isWinner(String grid, char x) {
        return  (grid.charAt(0) == x && grid.charAt(1) == x && grid.charAt(2) == x ||
                (grid.charAt(3) == x && grid.charAt(4) == x && grid.charAt(5) == x) || 
                (grid.charAt(6) == x && grid.charAt(7) == x && grid.charAt(8) == x) ||
                (grid.charAt(0) == x && grid.charAt(3) == x && grid.charAt(6) == x) ||
                (grid.charAt(1) == x && grid.charAt(4) == x && grid.charAt(7) == x) ||
                (grid.charAt(2) == x && grid.charAt(5) == x && grid.charAt(8) == x) ||
                (grid.charAt(0) == x && grid.charAt(4) == x && grid.charAt(5) == x) ||
                (grid.charAt(2) == x && grid.charAt(4) == x && grid.charAt(6) == x));
    }
}

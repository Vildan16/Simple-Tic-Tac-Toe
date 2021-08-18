package tictactoe;
import java.util.Scanner;

public class Main {

    public static boolean checkWinner(char[][] str, char c) {
        if (str[0][0] == c && str[0][1] == c && str[0][2] == c)
            return true;
        if (str[1][0] == c && str[1][1] == c && str[1][2] == c)
            return true;
        if (str[2][0] == c && str[2][1] == c && str[2][2] == c)
            return true;
        if (str[0][0] == c && str[1][0] == c && str[2][0] == c)
            return true;
        if (str[0][1] == c && str[1][1] == c && str[2][1] == c)
            return true;
        if (str[0][2] == c && str[1][2] == c && str[2][2] == c)
            return true;
        if (str[0][0] == c && str[1][1] == c && str[2][2] == c)
            return true;
        if (str[0][2] == c && str[1][1] == c && str[2][0] == c)
            return true;
        return false;
    }

    public static void printGrid(char[][] str) {
        System.out.println("---------");
        System.out.println("| " + str[0][0] + " " + str[0][1] + " " + str[0][2] + " |");
        System.out.println("| " + str[1][0] + " " + str[1][1] + " " + str[1][2] + " |");
        System.out.println("| " + str[2][0] + " " + str[2][1] + " " + str[2][2] + " |");
        System.out.println("---------");
    }

    public static boolean checkStatus(char[][] str) {
        int numX = 0;
        int numO = 0;
        boolean winX = checkWinner(str, 'X');
        boolean winO = checkWinner(str, 'O');
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                if (str[i][j] == 'X')
                    numX++;
                if (str[i][j] == 'O')
                    numO++;
            }
        }
        if (!winX && !winO && numX + numO == 9) {
            System.out.println("Draw");
            return true;
        }
        else if (winX) {
            System.out.println("X wins");
            return true;
        }
        else if (winO) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    public static void makeMove(char[][] grid, char c) {
        Scanner scanner = new Scanner(System.in);
        int newX;
        int newY;
        while (true) {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt())
                newX = scanner.nextInt();
            else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (scanner.hasNextInt())
                newY = scanner.nextInt();
            else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (newX < 1 || newX > 3 || newY < 1 || newY > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (grid[newX - 1][newY - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            grid[newX - 1][newY - 1] = c;
            printGrid(grid);
            break;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
        printGrid(grid);
        while (true) {
            makeMove(grid, 'X');
            if (checkStatus(grid))
                break;
            makeMove(grid, 'O');
            if (checkStatus(grid))
                break;
        }
    }
}

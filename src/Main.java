import javax.security.auth.x500.X500Principal;
import java.util.*;

public class Main {
    static char[][] board = {
            {'1', '|', '2', '|', '3'},
            {'-', '+', '-', '+', '-'},
            {'4', '|', '5', '|', '6'},
            {'-', '+', '-', '+', '-'},
            {'7', '|', '8', '|', '9'},
    };
    static int moves = 0;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        while (moves <= 9) {
            printBoard();
            System.out.println("\nYour chance >>>");

            int loc = in.nextInt();
            while (set.contains(loc)){
                System.out.println("\nFill right box >>>");
                loc = in.nextInt();
            }
            set.add(loc);
            play('U', loc);

            loc = random.nextInt(9);
            while (set.contains(loc)){
                System.out.println("\nFill right box >>>");
                loc = random.nextInt(9);
            }
            set.add(loc);
            play('M', loc);

            int win = win();

            if (win > 0){
                printBoard();
                winner(win);
                break;
            }
        }
    }

    private static void winner(int win) {
        char winner = ' ';
        if (win == 1 || win == 4 || win == 7){
            winner = board[0][0];
        }
        else if (win == 2 || win == 5){
            winner = board[2][2];
        }
        else if (win == 3 || win == 8)
            winner = board[4][0];
        else if (win == 6)
            winner = board[0][4];

        if (winner == 'X')
            System.out.println("Congratulations :) YOU WON");
        if (winner == '0')
            System.out.println("Sorry :( YOU LOSS");
    }

    private static int win() {
        if(board[0][0] == board[0][2] && board[0][0] == board[0][4])
            return 1;
        else if (board[2][0] == board[2][2] && board[2][0] == board[2][4])
            return 2;
        else if (board[4][0] == board[4][2] && board[4][0] == board[4][4])
            return 3;
        else if (board[0][0] == board[2][0] && board[0][0] == board[4][0])
            return 4;
        else if(board[0][2] == board[2][2] && board[0][2] == board[4][2])
            return 5;
        else if (board[0][4] == board[2][4] && board[0][4] == board[4][4])
            return 6;

        else if (board[0][0] == board[2][2] && board[0][0] == board[4][4])
            return 7;
        else if (board[0][4] == board[2][2] && board[0][4] == board[4][0])
            return 8;

        return -1;
    }

    private static void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void play(char player, int loc){
        int x = 0;
        int y = 0;

        if (loc == 1){
            x = 0;
            y = 0;
        } else if (loc == 2){
            x = 0;
            y = 2;
        } else if (loc == 3){
            x = 0;
            y = 4;
        } else if (loc == 4){
            x = 2;
            y = 0;
        } else if (loc == 5){
            x = 2;
            y = 2;
        } else if (loc == 6){
            x = 2;
            y = 4;
        } else if (loc == 7){
            x = 4;
            y = 0;
        } else if (loc == 8){
            x = 4;
            y = 2;
        } else if (loc == 9){
            x = 4;
            y = 4;
        }

        if (player == 'U')
            board[x][y] = 'X';
        else
            board[x][y] = '0';

        moves++;
    }
}
package gamecenter;

import java.util.Scanner;

public class Main {

    /**
     * @return a digit from a string.
     * Forces user to insert a String with only 1 digit(obligatory) and spaces(optional).
     */
    static int inputEvaluator() {
        boolean flag;
        int num = 0;
        String reader;
        Scanner scanner = new Scanner(System.in);

        do {
            flag = false;//Represents an error in the input given by the user
            int count = 0;//reset the counter of how many digits characters the user input in the string

            reader = scanner.nextLine();

            for (int i = 0; i < reader.length(); i++) {
                if (!Character.isDigit(reader.charAt(i))) {
                    if (!Character.isSpaceChar(reader.charAt(i))) {
                        System.out.println("Please, type in only the number of the option you choose!");
                        flag = true;
                        break;
                    }
                }
                else {
                    num = Character.getNumericValue(reader.charAt(i));
                    count++;
                }
            }

            if (count != 1 && !flag) {
                System.out.println("Please insert only 1 number!");
                flag = true;
            }
        } while (flag);

        return num;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        int gameNum;

        do {
            //prints the menu
            System.out.println("----------------------------------------------");
            System.out.println("Welcome to the game center menu!");
            System.out.println("Choose one of our games and have fun!");
            System.out.println("0 : End program");
            System.out.println("1 : Tic-Tac-Toe");
            System.out.println("2 : Battleship");
            System.out.println("3 : Minesweeper");
            System.out.println("4 : Chess");
            System.out.println("5 : Checkers");
            System.out.println("----------------------------------------------");

            gameNum = inputEvaluator();

            switch (gameNum){
                case 0:
                    System.out.println("Are you sure you want to leave?");
                    System.out.println("1 - Yes        2 - No");
                    int num = inputEvaluator();

                    if (num == 1) {
                        System.exit(0);
                    }
                    else
                        break;
                case 1:
                    ticTacToe.NewGame();
                    break;
                case 2:
                    System.out.println("Battleship hasn't been done yet! Please choose a different option!");
                    break;
                case 3:
                    System.out.println("Minesweeper hasn't been done yet! Please choose a different option!");
                    break;
                case 4:
                    System.out.println("Chess hasn't been done yet! Please choose a different option!");
                    break;
                case 5:
                    System.out.println("Checkers hasn't been done yet! Please choose a different option!");
                    break;
                default:
                    System.out.println("This number doesn't correspond to any options from the list!");
                    System.out.println("Please, choose an existing option!");
            }
        } while (true);
    }
}

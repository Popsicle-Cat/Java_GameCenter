package gamecenter;

import java.util.Scanner;

public class TicTacToe {

    static boolean numIsNotInRange(int num) {
        return num < 1 || num > 3;
    }

    public void NewGame() {
        String reader;
        int numCount;
        char[][] tableMoves = new char[3][3];
        char currentPlayerChar, player1 = 'X', player2 = 'O';
        final char blankSpaces = ' ';
        Scanner scanner = new Scanner(System.in);

        do {
            //fills the table with blank spaces
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    tableMoves[i][k] = blankSpaces;
                }
            }

            System.out.println("Welcome to a game of tic-tac-toe");

            //chooses characters for player 1 and 2
            /*System.out.println("Player 1, choose you character!");
            player1 =  scanner.next().charAt(0);

            System.out.println("Player 2, choose you character!");
            player2 =  scanner.next().charAt(0);*/

            currentPlayerChar = player1;

            //Prints the empty table
            System.out.println("---------");
            System.out.printf("| %c %c %c |\n", tableMoves[0][0], tableMoves[1][0], tableMoves[2][0]);
            System.out.printf("| %c %c %c |\n", tableMoves[0][1], tableMoves[1][1], tableMoves[2][1]);
            System.out.printf("| %c %c %c |\n", tableMoves[0][2], tableMoves[1][2], tableMoves[2][2]);
            System.out.println("---------");

            while (true) {
                //Asks for the player move and checks if it's valid
                int chosenInput;
                boolean wrongInput, gameFinished = false;
                int[] playerMovement = new int[2];
                do {
                    wrongInput = false;//reset condition of input
                    playerMovement[0] = 0;//reset first coordinate of the player movement
                    playerMovement[1] = 0;//reset second coordinate of the player movement
                    numCount = 0;//counts the amount of numbers inserted by the player
                    System.out.println(currentPlayerChar + ", make your move: ");
                    reader = scanner.nextLine();

                    for (int i = 0; i < reader.length(); i++) {
                        if (!Character.isDigit(reader.charAt(i))) {
                            if (!Character.isSpaceChar(reader.charAt(i))) {
                                wrongInput = true;
                                break;
                            }
                        } else if (numCount < 2) {
                            playerMovement[numCount] = Character.getNumericValue(reader.charAt(i));
                            numCount++;
                        } else
                            numCount++;
                    }

                    if (wrongInput) {
                        System.out.println("You should enter numbers!");
                    } else if (numCount != 2) {
                        System.out.println("You should enter exactly 2 numbers for coordinates!");
                        wrongInput = true;
                    } else if (numIsNotInRange(playerMovement[0]) || numIsNotInRange(playerMovement[1])) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        wrongInput = true;
                    } else if (tableMoves[playerMovement[0] - 1][playerMovement[1] - 1] != blankSpaces) {
                        System.out.println("This cell is occupied! Choose another one!");
                        wrongInput = true;
                    }
                } while (wrongInput);
                tableMoves[playerMovement[0] - 1][playerMovement[1] - 1] = currentPlayerChar;//applies the player movement on the table

                //Prints the table after player made his move
                System.out.println("---------");
                System.out.printf("| %c %c %c |\n", tableMoves[0][0], tableMoves[1][0], tableMoves[2][0]);
                System.out.printf("| %c %c %c |\n", tableMoves[0][1], tableMoves[1][1], tableMoves[2][1]);
                System.out.printf("| %c %c %c |\n", tableMoves[0][2], tableMoves[1][2], tableMoves[2][2]);
                System.out.println("---------");

                //Checks the game state
                boolean xWins = (tableMoves[0][0] == 'X' && tableMoves[1][0] == 'X' && tableMoves[2][0] == 'X') || (tableMoves[0][1] == 'X' && tableMoves[1][1] == 'X' && tableMoves[2][1] == 'X') || (tableMoves[0][2] == 'X' && tableMoves[1][2] == 'X' && tableMoves[2][2] == 'X') || (tableMoves[0][0] == 'X' && tableMoves[0][1] == 'X' && tableMoves[0][2] == 'X') || (tableMoves[1][0] == 'X' && tableMoves[1][1] == 'X' && tableMoves[1][2] == 'X') || (tableMoves[2][0] == 'X' && tableMoves[2][1] == 'X' && tableMoves[2][2] == 'X') || (tableMoves[0][0] == 'X' && tableMoves[1][1] == 'X' && tableMoves[2][2] == 'X') || (tableMoves[2][0] == 'X' && tableMoves[1][1] == 'X' && tableMoves[0][2] == 'X');
                boolean oWins = (tableMoves[0][0] == 'O' && tableMoves[1][0] == 'O' && tableMoves[2][0] == 'O') || (tableMoves[0][1] == 'O' && tableMoves[1][1] == 'O' && tableMoves[2][1] == 'O') || (tableMoves[0][2] == 'O' && tableMoves[1][2] == 'O' && tableMoves[2][2] == 'O') || (tableMoves[0][0] == 'O' && tableMoves[0][1] == 'O' && tableMoves[0][2] == 'O') || (tableMoves[1][0] == 'O' && tableMoves[1][1] == 'O' && tableMoves[1][2] == 'O') || (tableMoves[2][0] == 'O' && tableMoves[2][1] == 'O' && tableMoves[2][2] == 'O') || (tableMoves[0][0] == 'O' && tableMoves[1][1] == 'O' && tableMoves[2][2] == 'O') || (tableMoves[2][0] == 'O' && tableMoves[1][1] == 'O' && tableMoves[0][2] == 'O');

                if (xWins) {
                    System.out.println("X wins!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Do you wish to play another game?");
                    System.out.println("1 - Play another game     2 - Go back to menu");
                    do {
                        chosenInput = scanner.nextInt();

                        if (chosenInput != 1 && chosenInput != 2) {
                            System.out.println("Please, insert a valid number!");
                        }
                        else
                            break;
                    } while (true);

                    if (chosenInput == 2)
                        return;
                    break;
                } else if (oWins) {
                    System.out.println("O wins!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Do you wish to play another game?");
                    System.out.println("1 - Play another game     2 - Go back to menu");
                    do {
                        chosenInput = scanner.nextInt();

                        if (chosenInput != 1 && chosenInput != 2) {
                            System.out.println("Please, insert a valid number!");
                        }
                        else
                            break;
                    } while (true);

                    if (chosenInput == 2)
                        return;
                    break;
                } else {
                    boolean flag = false;//indicates if the game state has already been output
                    for (int i = 0; i < 3; i++) {
                        for (int k = 0; k < 3; k++) {
                            if (tableMoves[i][k] == blankSpaces) {
                                System.out.println("Game not finished");
                                flag = true;
                                break;
                            } else if (i == 2 && k == 2) {
                                gameFinished = true;
                                System.out.println("Draw!");
                                System.out.println("------------------------------------------------");
                                System.out.println("Do you wish to play another game?");
                                System.out.println("1 - Play another game     2 - Go back to menu");
                                do {
                                    chosenInput = scanner.nextInt();

                                    if (chosenInput != 1 && chosenInput != 2) {
                                        System.out.println("Please, insert a valid number!");
                                    }
                                    else
                                        break;
                                } while (true);

                                if (chosenInput == 2) {
                                    return;
                                }
                            }
                        }
                        if (flag)
                            break;
                    }

                    //Changes the turn to the other player
                    if (currentPlayerChar == player1)
                        currentPlayerChar = player2;
                    else
                        currentPlayerChar = player1;
                }
                if (gameFinished)
                    break;
            }
        } while (true);
    }
}

import java.util.Scanner;
public class TicTacToe {
    //Instance variables
    private char[][] gameBoard = new char[3][3];
    private boolean gameOver = false;
    private int row;
    private int column;
    private char input;
    private char letter;
    private boolean freeSpace;
    private int turn = 1;

    //Make constructor. When created, creates a game board which is a 3x3 array full of *. * are used as a place holder.
    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = '*';
            }
        }
    }

    //Method to set input variable to the players input
    public void setInput(char inp) {
        input = inp;
    }

    //Used in GameRun class so the game doesn't run indefinitely.
    public boolean isGameOver() {
        return gameOver;
    }

    //Gets the player input and depending on the input assigns the row and column of the array to the respective variables.
    //These variables are used later on to change the array value to plug in the X and O respectively
    public void boardInput() {
        //sets the row and column equal to the value of which the key correlates to
        if (input == 'q') {
            row = 0;
            column = 0;
        } else if (input == 'w') {
            row = 0;
            column = 1;
        } else if (input == 'e') {
            row = 0;
            column = 2;
        } else if (input == 'a') {
            row = 1;
            column = 0;
        } else if (input == 's') {
            row = 1;
            column = 1;
        } else if (input == 'd') {
            row = 1;
            column = 2;
        } else if (input == 'z') {
            row = 2;
            column = 0;
        } else if (input == 'x') {
            row = 2;
            column = 1;
        } else if (input == 'c') {
            row = 2;
            column = 2;
        }
    }

    //Runs player 1 turn. PLayer 1 is x. based off row and column variable sets the spot to X.
    public void p1Turn() {
        //take player input, check if the spot is taken, if not enter in depending on inp
            gameBoard[row][column] = 'X';
    }

    //Same as p1 just with O
    public void p2Turn() {
            gameBoard[row][column] = 'O';
    }

    //Checks if the space where a player wants to go isn't already taken by an X or O
    public void turnCheck() {
        if(gameBoard[row][column] == '*') {
            freeSpace = true;
        } else {
            freeSpace = false;
        }
    }

    //Checks if a player got 3 in a row. If all the spaces are filled but there is no winner then it is a tie.
    public void checkWin(){
        if(gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][1] == gameBoard[0][2] && gameBoard[0][0] != '*'){
            gameOver = true;
        } else if(gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[1][2] && gameBoard[1][2] != '*'){
            gameOver = true;
        } else if(gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][1] == gameBoard[2][2] && gameBoard[2][2] != '*'){
            gameOver = true;
        } else if(gameBoard[0][0] == gameBoard[1][0] && gameBoard[1][0] == gameBoard[2][0] && gameBoard[2][0] != '*'){
            gameOver = true;
        } else if(gameBoard[0][1] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][1] && gameBoard[2][1] != '*'){
            gameOver = true;
        } else if(gameBoard[0][2] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][2] && gameBoard[2][2] != '*'){
            gameOver = true;
        } else if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[2][2] != '*'){
            gameOver = true;
        } else if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[2][0] != '*'){
            gameOver = true;
        } else if(gameBoard[0][0] != '*' && gameBoard[1][0] != '*' && gameBoard[2][0] != '*' && gameBoard[0][1] != '*' && gameBoard[1][1] != '*' && gameBoard[2][1] != '*' && gameBoard[0][2] != '*' && gameBoard[1][2] != '*' && gameBoard[2][2] != '*'){
            gameOver = true;
        }
    }

    //Runs a round. Based off the turn it knows if it is player 1's turn or player 2's
    public void playRound() {
        // get p1 input
        boardInput();

        turnCheck();
        if (turn % 2 != 0 && freeSpace) {
            p1Turn();
            turn++;
        } else if(turn % 2 == 0 && freeSpace) {
            p2Turn();
            turn++;
        } else{
            System.out.println("Try again. Invalid space.");
        }
    }

        //Plays the game. Prints the board at the start, and then after every round respectively
        public void playGame(){
            Scanner sc = new Scanner(System.in);
            while (!gameOver) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(gameBoard[i][j] + " ");
                    }
                    System.out.println();
                }
                setInput(sc.next().charAt(0));
                playRound();
                checkWin();
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(gameBoard[i][j] + " ");
                }
                System.out.println();
            }

            if(gameBoard[0][0] != '*' && gameBoard[1][0] != '*' && gameBoard[2][0] != '*' && gameBoard[0][1] != '*' && gameBoard[1][1] != '*' && gameBoard[2][1] != '*' && gameBoard[0][2] != '*' && gameBoard[1][2] != '*' && gameBoard[2][2] != '*'){
                System.out.println("Tie");
            } else if((turn - 1) % 2 != 0){
                System.out.println("X WON!");
            } else{
                System.out.println("O WON!");
            }
        }
}

import java.util.Scanner;

public class NimNumber {

    private int numberOfBalls = 10;
    private GameState startingState;

    public void printGame(){
        System.out.println("The current state of pile:");
        System.out.println("" + "○ ".repeat(Math.max(0, this.numberOfBalls)));
    }

    public int playGame(){
        System.out.println("Welcome to the Nim Number Game! The game starts with " + 10 + " balls in the pile.");
        while (true) {
            System.out.println("**************************************");
            printGame();
            if (humanMove() == true) {
                return 1;
            }
            if (computerMove() == true) {
                return 0;
            }
        }
    }

    public boolean humanMove(){
        // need to make a check if only 1 or 2 is input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose 1 or 2 balls from the exiting pile:");
        int number = scanner.nextInt();
        if(this.numberOfBalls == 1) {
            while (number != 1) {
                System.out.println("Only 1 ball can be chosen from the stack!");
                number = scanner.nextInt();
            }
        } else{
            while(number<=0 || number >=3){
                System.out.println("Please choose 1 or 2 balls.");
                number = scanner.nextInt();
            }
        }
        this.numberOfBalls -= number;
        if(this.numberOfBalls <= 0){
            System.out.println("Player won!");
            return true; // Human player wins
        }
        return false;
    }

    public boolean computerMove(){

        startingState = new GameState("computer", this.numberOfBalls);
        GameTree tree = new GameTree(this.numberOfBalls, "computer");
        int bestMove = tree.pilesToBeRemoved(startingState);
        System.out.println("Computer chose " + bestMove + " balls from the pile.");
        this.numberOfBalls -= bestMove;
        if(this.numberOfBalls <= 0){
            System.out.println("Computer won!");
            return true; // Computer player wins
        }
        return false;

    }

}

import java.util.Scanner;

public class NimNumber {

    public void printGame(){
        System.out.println("The current state of pile:");
        System.out.println("" + "○ ".repeat(Math.max(0, this.numberOfBalls)));
    }
    private int numberOfBalls;

    public int playGame(){
        System.out.println("Welcome to the Nim Number Game! The game starts with " + 10 + " balls in the pile.");
        System.out.print("Choose your level of difficulty - Easy or Hard\n>");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String level = scanner.nextLine().toUpperCase();
            if (level.equals("EASY")) {
                int numRounds = 0;
                while (true) {
                    System.out.println("**************************************");
                    System.out.println("Round:" + numRounds);
                    printGame();
                    if (humanMove() == true) {
                        return 1;
                    }
//                    if (computerMove() == true) {
//                        return 0;
//                    }
                    numRounds++;
                }
            } else {
                System.out.print("Please choose a valid level of difficulty.\n >");
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




    //    public NimNumber(int gamePileNumber){
//        this.gamePileNumber = gamePileNumber;
//        this.gameTree = new GameTree(gamePileNumber, "human");
//    }
//
//    public void gameState(){
//        String val = "";
//        for(int i = 0; i < this.currentState.piles; i++){
//            val += "o";
//        }
//
//        System.out.println(val);
//    }
//
//    public int getPlayerMove(){
//        System.out.println("Your turn. Enter the number of stones you want to remove from the pile.");
//        int playerMove = Integer.parseInt(System.console().readLine());
//        if(playerMove > 3 || playerMove < 1){
//            System.out.println("Invalid move. You must remove between 1 and 3 stones.");
//            this.getPlayerMove();
//        }
//        return playerMove;
//
//    }
//
//    public int getComputerMove(){
//        return 0;
//    }
//


}

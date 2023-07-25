public class NimNumber {

    int gamePileNumber;

    GameState currentState;

    GameTree gameTree;
    public NimNumber(int gamePileNumber){
        this.gamePileNumber = gamePileNumber;
        this.gameTree = new GameTree(gamePileNumber, "human");
    }

    public void gameState(){
        String val = "";
        for(int i = 0; i < this.currentState.piles; i++){
            val += "o";
        }

        System.out.println(val);
    }

    public int getPlayerMove(){
        System.out.println("Your turn. Enter the number of stones you want to remove from the pile.");
        int playerMove = Integer.parseInt(System.console().readLine());
        if(playerMove > 3 || playerMove < 1){
            System.out.println("Invalid move. You must remove between 1 and 3 stones.");
            this.getPlayerMove();
        }
        return playerMove;

    }

    public int getComputerMove(){


    }

    public void playGame(){
        this.currentState = this.gameTree.head;
        while(this.currentState.isEndState == false){
            this.gameState();
            int valPlayer = this.getPlayerMove();
            for(int i = 0; i < this.currentState.childState.size();i++){
                if(this.currentState.childState.get(i).value == valPlayer){
                    this.currentState = this.currentState.childState.get(i);
                    break;
                }
            }

            int valComputer = this.getComputerMove();
            System.out.println("Computer removed " + valComputer + " stones.");
            for(int i = 0; i < this.currentState.childState.size();i++){
                if(this.currentState.childState.get(i).value == valComputer){
                    this.currentState = this.currentState.childState.get(i);
                    break;
                }
            }

        }
    }


}

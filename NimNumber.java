public class NimNumber {

    int gamePileNumber;

    GameTree gameTree;
    public NimNumber(int gamePileNumber){
        this.gamePileNumber = gamePileNumber;
        this.gameTree = new GameTree(gamePileNumber, "human");
    }


}

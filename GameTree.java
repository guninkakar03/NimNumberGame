import java.util.ArrayList;
import java.util.List;

/** The first player is always the computer -- the second is the player.
 * The computer maximises at its level and the player minimizes at its level.
 * The person who removes the last counter wins.
 * If player has nothing to pick, it is positive. If computer has nothing to pick, it is negative.
 *
 */
public class GameTree {

    ArrayList<Integer> choices = new ArrayList<>(List.of(1, 2, 3));
    GameState head;

    public GameTree(int piles, String player){
        this.head = new GameState(player, piles);
//        this.generateTree();
    }

    public int generateTree(GameState startingState){
        if(startingState.isEndState) {
            return;
        }


        String tempPlayer = startingState.player.equals("computer")? "human": "computer";
        ArrayList<GameState> children = new ArrayList<>(); // All the children states
        for(int choice: choices){
            int tempPiles = startingState.piles-choice;

            if (tempPiles>=0) {
                GameState newState = new GameState(tempPlayer, tempPiles);
                children.add(newState);
            }
        }

        if (startingState.player.equals("computer")) {

        }

    }

    public static void printTree(){
        GameTree tree = new GameTree(5, "human");
        System.out.println(tree.head.piles);
    }


    public static void main(String args[]){
        GameTree.printTree();
    }

}

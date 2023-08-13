import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/** The first player is always the computer -- the second is the player.
 * The computer maximises at its level and the player minimizes at its level.
 * The person who removes the last counter wins.
 * If player has nothing to pick, it is positive. If computer has nothing to pick, it is negative.
 *
 */
public class GameTree {

    static ArrayList<Integer> choices = new ArrayList<>(List.of(1, 2, 3));
    GameState head;

    public GameTree(int piles, String player){
        this.head = new GameState(player, piles);
    }

    public static void printTree(){
        GameTree tree = new GameTree(5, "human");
        System.out.println(tree.head.piles);
    }
    public static int pilesToBeRemoved(GameState startingState) {
        int bestMove = -1;
        int bestValue = Integer.MIN_VALUE;

        ArrayList<GameState> children = new ArrayList<>(); // All the children states
        String tempPlayer = startingState.player.equals("computer")? "human": "computer";

        for(int choice: choices){
            int tempPiles = startingState.piles-choice;

            if (tempPiles>=0) {
                GameState newState = new GameState(tempPlayer, tempPiles);
                children.add(newState);
            }
        }
        for (GameState child : children) {
            int childValue = buildMinMaxTree(child, true);
            if (childValue > bestValue) {
                bestValue = childValue;
                bestMove = startingState.piles - child.piles;
            }
        }

        return bestMove;
    }

    public static int buildMinMaxTree(GameState startingState, boolean isMaximizingPlayer) {
        if (startingState.isEndState) {
            return startingState.value; // Assuming getValue() returns -1 or 1 for end states
        }

        ArrayList<GameState> children = new ArrayList<>(); // All the children states
        String tempPlayer = startingState.player.equals("computer")? "human": "computer";

        for(int choice: choices){
            int tempPiles = startingState.piles-choice;

            if (tempPiles>=0) {
                GameState newState = new GameState(tempPlayer, tempPiles);
                children.add(newState);
            }
        }

        int bestValue;
        if (isMaximizingPlayer) {
            bestValue = Integer.MIN_VALUE;
            for (GameState child : children) {
                int childValue = buildMinMaxTree(child, false);
                bestValue = Math.max(bestValue, childValue);
            }
        } else {
            bestValue = Integer.MAX_VALUE;
            for (GameState child : children) {
                int childValue = buildMinMaxTree(child, true);
                bestValue = Math.min(bestValue, childValue);
            }
        }

        return bestValue;
    }

}

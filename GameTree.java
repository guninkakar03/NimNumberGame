import java.util.ArrayList;
import java.util.List;

public class GameTree {

    GameState head;

    public GameTree(int piles, String player){
        this.head = new GameState(player, piles);
        this.generateTree();
    }

    public void generateTree(){
        if(this.head.isEndState){
            return;
        }
        ArrayList<GameState> queue = new ArrayList<>(List.of(this.head));
        while (queue.size()>0){
            GameState currentState = queue.get(0);
            queue.remove(0);
            ArrayList<GameState> childStates = currentState.generateChild();
            for(GameState state: childStates){
                if(state.isEndState == false){
                    queue.add(state);
                }
            }
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

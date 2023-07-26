import java.util.ArrayList;
import java.util.List;

public class GameTree {

    ArrayList<Integer> choices = new ArrayList<>(List.of(1, 2, 3));
    GameState head;

    public GameTree(int piles, String player){
        this.head = new GameState(player, piles);
//        this.generateTree();
    }

    public void generateTree(GameState startingState){
        ch
        for(int choice: choices){

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

import java.util.ArrayList;
import java.util.List;

public class GameState {

    String player;
    ArrayList<Integer> choices;
    int piles;
//    ArrayList<GameState> childState;
    boolean isEndState = false;
    int value = -2;

    public GameState(String player, int piles){
        this.player = player;
        this.piles = piles;
        choices = new ArrayList<>(List.of(1, 2, 3));
        if (piles<=0){
            isEndState = true;
            if (this.player == "computer") {
                this.value = -1;
            } else {
                this.value = 1;
            }
        }
    }

}

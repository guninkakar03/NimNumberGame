import java.util.ArrayList;
import java.util.List;

public class GameState {

    String player;
    ArrayList<Integer> choices;
    int piles;
    ArrayList<GameState> childState;
    boolean isEndState = false;
    int value;

    public GameState(String player, int piles){
        this.player = player;
        this.piles = piles;
        choices = new ArrayList<>(List.of(1, 2, 3));
        if (piles<=0){
            isEndState = true;
        }
    }

    public ArrayList<GameState> generateChild() {
        String newPlayer = player.equals("computer") ? "human" : "computer";
        ArrayList<GameState> gameStates = new ArrayList<>();

        for (int i = 0; i < choices.size(); i++) {
            int gameStateValue = choices.get(i);
            int gamePileNumber = this.piles - gameStateValue;
            if(gamePileNumber<0) continue;
            GameState newstate = new GameState(newPlayer, gamePileNumber);
            gameStates.add(newstate);
            newstate.value = gameStateValue;
        }
        this.childState = gameStates;
        return gameStates;
    }
}

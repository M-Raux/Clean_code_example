import game.Game;
import game.actions.Action;
import game.actions.ActionFactory;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        ActionFactory actionFactory = new ActionFactory();

        try {
            String receivedAction = receiveAction();
            Action action = actionFactory.getAction(receivedAction);
            game.requestAction(action);
            game.playNextTurn();
            System.out.printf("TURN DONE SUCCESSFULLY AND EARNED %d POINTS\n%s", game.getScore(), game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String receiveAction() {
        return "PLANTCARROT";
    }
}

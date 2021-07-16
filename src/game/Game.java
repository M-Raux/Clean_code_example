package game;

import game.actions.Action;
import game.parcel.Parcel;
import lombok.Getter;

public class Game {
    private final Parcel parcel;
    private Action actionWaiting;
    @Getter
    private int score;

    public Game() {
        parcel = new Parcel();
        score = 0;
    }

    public void requestAction(Action action) {
        actionWaiting = action;
    }

    public void playNextTurn() {
        playAction();
        if (parcel.hasPlant()) {
            parcel.playPlantLifecycle();
        }
    }

    private void playAction() {
        if (hasActionWaiting() && actionWaiting.isActionPossible(parcel)) {
            score += actionWaiting.getActionValue(parcel);
            actionWaiting.playAction(parcel);
        }
        actionWaiting = null;
    }

    private boolean hasActionWaiting() {
        return actionWaiting != null;
    }

    @Override
    public String toString() {
        return "game{" +
                "parcel=" + parcel +
                ", score=" + score +
                '}';
    }
}

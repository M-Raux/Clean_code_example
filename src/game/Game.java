package game;

import game.actions.Action;
import game.parcel.Parcel;
import lombok.Getter;
import lombok.Setter;

public class Game {
    private final Parcel parcel;
    @Setter
    private Action actionWaiting;
    @Getter
    private int score;

    public Game() {
        parcel = new Parcel();
        score = 0;
    }

    public void playNextTurn() {
        if (hasActionWaiting() && actionWaiting.isActionPossible(parcel)) {
            score = actionWaiting.playAction(parcel);
        }
        actionWaiting = null;
        if (parcel.hasPlant()) {
            parcel.growPlant();
            parcel.feedPlantWithNutrient();
        }
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

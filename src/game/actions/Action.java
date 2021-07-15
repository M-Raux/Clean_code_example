package game.actions;

import game.parcel.Parcel;

public abstract class Action {
    public abstract int getActionValue(Parcel parcel);

    public abstract void playAction(Parcel parcel);

    public abstract boolean isActionPossible(Parcel parcel);
}

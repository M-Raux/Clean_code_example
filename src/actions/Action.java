package actions;

import parcel.Parcel;

public abstract class Action {
    public abstract int playAction(Parcel parcel);

    public abstract boolean isActionPossible(Parcel parcel);
}

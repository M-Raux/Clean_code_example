import actions.Action;
import actions.ActionFactory;
import parcel.Parcel;

public class Main {
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        ActionFactory actionFactory = new ActionFactory();

        try {
            String receivedAction = receiveAction();
            Action action = actionFactory.getAction(receivedAction);
            int pointsGained = parcel.playNextTurn(action);
            System.out.printf("TURN DONE SUCCESSFULLY AND EARNED %d POINTS\n%s", pointsGained, parcel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String receiveAction() {
        return "PLANTA";
    }
}

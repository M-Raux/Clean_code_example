public class Main {
    public static void main(String[] args) {
        Cell t = new Cell();
        String act = receiveAction();
        int ret = t.nextTurn(act);
        String turnInformation;
        switch (ret) {
            case -1:{
                turnInformation = "INVALID OR MISSING TYPE OF PLANT";
                break;
            }
            case -2: {
                turnInformation = "INVALID ACTION";
                break;
            }
            default:
                turnInformation = String.format("TURN DONE SUCCESSFULLY AND EARNED %d POINTS\n%s", ret, t);
        }
        System.out.println(turnInformation);
    }

    private static String receiveAction() {
        return "PLANTA";
    }
}

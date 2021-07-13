public class Cell {
    private int plt;
    private char pltType;
    private int sQlt;

    public Cell() {
        this.plt = -1;
        this.sQlt = 1000;
    }

    public int nextTurn(String act) {
        int p = 0;
        if (act != null) {
            if (act.equals("FERTILIZE")) {
                sQlt = Math.min(1000, sQlt + 300);
            } else if (act.equals("HARVEST")) {
                if (plt != -1) {
                    if (plt >= 10 && plt <= 11) {
                        if (pltType == 'A') {
                            p = 1;
                        } else if (pltType == 'B') {
                            p = 2;
                        }
                    }
                    plt = -1;
                }
            } else if (act.startsWith("PLANT")) {
                if (plt == -1) {
                    act = act.substring(5);
                    if (act.equals("A") || act.equals("B")) {
                        pltType = act.charAt(0);
                        plt = 0;
                    } else {
                        return -1;
                    }
                }
            } else {
                return -2;
            }
        }
        if (plt >= 0) {
            plt++;
            if (pltType == 'A') {
                sQlt = Math.max(0, sQlt - 10);
            } else if (pltType == 'B') {
                sQlt = Math.max(0, sQlt - 20);
            }
            if (sQlt == 0) {
                plt = 110;
            }
        }
        return p;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "plt=" + plt +
                ", pltType=" + pltType +
                ", sQlt=" + sQlt +
                '}';
    }
}

package Cryptographing;

public class AlgorithmChoose {

    private static int lastUsed = 0;
    private static final int numOfAlgorithm = 5;

    public static int chooseAlgorithm() {

        int numToreturn = (int) (Math.random() * numOfAlgorithm);
        while (numToreturn == lastUsed) {
            numToreturn = (int) (Math.random() * numOfAlgorithm);
        }
        lastUsed = numToreturn;

        //TODO razviti bolji nacin odabira sledeceg algoritma

        return numToreturn;
    }

    private static void analysis() {
        //TODO dinamicko pracenje i menjanje nacina odabira
    }

}

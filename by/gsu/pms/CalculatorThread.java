package by.gsu.pms;

public class CalculatorThread extends Thread {
    private int lowerLimit;
    private int upperLimit;

    private int result = 1;

    public CalculatorThread(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println(CalculatorThread.currentThread());
        for (int i = lowerLimit; i <= upperLimit; i++) {
            int k = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0)
                    k++;
            }
            if (k < 2) {
                result *= i;
            }
        }
    }
}

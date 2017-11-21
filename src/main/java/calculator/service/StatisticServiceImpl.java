package calculator.service;

public class StatisticServiceImpl implements StatisticService {
    private int addCounter;
    private int subtractCounter;
    private int multiplyCounter;
    private int divideCounter;

    public int getAddCounter() {
        return addCounter;
    }

    public int getSubtractCounter() {
        return subtractCounter;
    }

    public int getMultiplyCounter() {
        return multiplyCounter;
    }

    public int getDivideCounter() {
        return divideCounter;
    }

    public void incrementAddCounter() {
        addCounter++;
    }

    public void incrementSubtractCounter() {
        subtractCounter++;
    }

    public void incrementMultiplyCounter() {
        multiplyCounter++;
    }

    public void incrementDivideCounter() {
        divideCounter++;
    }

}

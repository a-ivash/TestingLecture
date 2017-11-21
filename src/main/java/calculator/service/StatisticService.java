package calculator.service;

public interface StatisticService {
    int getAddCounter();
    int getSubtractCounter();
    int getMultiplyCounter();
    int getDivideCounter();
    void incrementAddCounter();
    void incrementSubtractCounter();
    void incrementMultiplyCounter();
    void incrementDivideCounter();
}

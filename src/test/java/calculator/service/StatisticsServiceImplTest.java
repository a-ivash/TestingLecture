package calculator.service;

import calculator.Calculator;
import calculator.domain.ComplexObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StatisticsServiceImplTest {
    /** Used to get random iteration counter*/
    private Random random = new Random();
    private static StatisticService statisticService;
    private static CountingService countingService;
    private static Calculator calculator;
    private ComplexObject objectA = new ComplexObject(10, 10);
    private ComplexObject objectB = new ComplexObject(1, 2);

    @BeforeClass
    public static void beforeClassInit() {
        calculator = new Calculator();
        countingService = new CountingServiceImpl();
        statisticService = new StatisticServiceImpl();
        calculator.setStatisticsService(statisticService);
        calculator.setCountingService(countingService);
    }

    @Test
    public void testAddCounter() {
        int addCounterBefore = statisticService.getAddCounter();
        int iterationCounter = random.nextInt(20);
        for (int i = 0; i < iterationCounter; i++) {
            calculator.add(objectA, objectB);
        }
        int addCounterNow = statisticService.getAddCounter();
        int expectedCounter = addCounterBefore + iterationCounter;
        assertEquals(expectedCounter, addCounterNow);
    }

    @Test
    public void testSubtractCounter() {
        int subtractCounterBefore = statisticService.getSubtractCounter();
        int iterationCounter = random.nextInt(20);
        for (int i = 0; i < iterationCounter; i++) {
            calculator.subtract(objectA, objectB);
        }
        int subtractCounterNow = statisticService.getSubtractCounter();
        int expectedCounter = subtractCounterBefore + iterationCounter;
        assertEquals(expectedCounter, subtractCounterNow);
    }

    @Test
    public void testMultiplyCounter() {
        int multiplyCounterBefore = statisticService.getMultiplyCounter();
        int iterationCounter = random.nextInt(20);
        for (int i = 0; i < iterationCounter; i++) {
            calculator.multiply(objectA, objectB);
        }
        int multiplyCounterNow = statisticService.getMultiplyCounter();
        int expectedCounter = multiplyCounterBefore + iterationCounter;
        assertEquals(expectedCounter, multiplyCounterNow);
    }

    @Test
    public void testDivideCounter() {
        int divideCounterBefore = statisticService.getDivideCounter();
        int iterationCounter = random.nextInt(20);
        for (int i = 0; i < iterationCounter; i++) {
            calculator.divide(objectA, objectB);
        }
        int divideCounterNow = statisticService.getDivideCounter();
        int expectedCounter = divideCounterBefore + iterationCounter;
        assertEquals(expectedCounter, divideCounterNow);
    }
}

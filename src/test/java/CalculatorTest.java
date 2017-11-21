import calculator.Calculator;
import calculator.Service;
import calculator.service.CountingService;
import static org.junit.Assert.*;

import calculator.service.StatisticService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import calculator.domain.ComplexObject;


@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
    @Mock
    private StatisticService statisticService;
    @Mock
    private CountingService service;

    @InjectMocks
    private Calculator calculator;

    /**
     * Testing adding values and substituting return result with custom object.
     * */
    @Test
    public void addTest() {
        ComplexObject objectA = new ComplexObject(1, 2);
        ComplexObject objectB = new ComplexObject(3, 4);
        ComplexObject expectedObject = new ComplexObject(0, 0);

        Mockito.when(service.add(objectA, objectB)).thenReturn(expectedObject);
        ComplexObject resultObject = calculator.add(objectA, objectB);

        assertEquals(expectedObject, resultObject);
        Mockito.verify(service, Mockito.times(1)).add(objectA, objectB);
    }

    /**
     * Testing subtracting values and substituting return result with custom object.
     * */
    @Test
    public void subtractTest() {
        ComplexObject objectA = new ComplexObject(1, 2, Service.TWO);
        ComplexObject objectB = new ComplexObject(3, 4, Service.TWO);
        ComplexObject expectedObject = new ComplexObject(-2, -2);

        Mockito.when(service.subtract(objectA, objectB)).thenReturn(expectedObject);
        ComplexObject resultObject = calculator.subtract(objectA, objectB);

        assertEquals(expectedObject, resultObject);
    }

    /**
     * Substituting calls for statistics service counter increment
     * */
    @Test
    public void checkCallsCounter() {
        int expectedAddCallsCounter = 100;
        Mockito.when(statisticService.getAddCounter()).thenReturn(expectedAddCallsCounter);
        ComplexObject objectA = new ComplexObject(10, 10);
        ComplexObject objectB = new ComplexObject(1, 1);

        calculator.add(objectA, objectB);
        assertEquals(expectedAddCallsCounter, calculator.getStatisticsService().getAddCounter());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPointerTest() {
        ComplexObject objectA = null;
        ComplexObject objectB = new ComplexObject(1, 1);
        calculator.divide(objectA, objectB);
    }

    /**
     * Math operations can be performed only on objects with same Service values
     * */
    @Test(expected = IllegalArgumentException.class)
    public void differentServicesTest() {
        ComplexObject objectA = new ComplexObject(1, 2);
        ComplexObject objectB = new ComplexObject(3, 4, Service.TWO);

        ComplexObject resultObject = calculator.add(objectA, objectB);
    }

    /**
     * both valueA and valueB must be positive
     * */
    @Test(expected = IllegalArgumentException.class)
    public void invalidValueServiceTwoTest() {
        ComplexObject objectA = new ComplexObject(-1, 2, Service.TWO);
        ComplexObject objectB = new ComplexObject(3, 4, Service.TWO);
        calculator.multiply(objectA, objectB);
    }

    /**
     * Checking for failing validation for third service type.
     * valueA = -100 or 50
     * valueB only negative
     * */
    @Test(expected = IllegalArgumentException.class)
    public void invalidValueServiceThreeTest() {
        ComplexObject objectA = new ComplexObject(-100, -2, Service.THREE);
        ComplexObject objectB = new ComplexObject(50, 100, Service.THREE);
        calculator.multiply(objectA, objectB);
    }
}


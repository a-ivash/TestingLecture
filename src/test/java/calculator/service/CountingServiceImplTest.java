package calculator.service;


import calculator.domain.ComplexObject;
import static org.junit.Assert.*;
import org.junit.Test;

public class CountingServiceImplTest {
    private CountingService service = new CountingServiceImpl();

    @Test
    public void addTest() {
        ComplexObject objectA = new ComplexObject(1, 2);
        ComplexObject objectB = new ComplexObject(3, 4);
        ComplexObject expectedObject = new ComplexObject(4, 6);

        ComplexObject actualObject = service.add(objectA, objectB);

        assertEquals(expectedObject, actualObject);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZeroTest() {
        ComplexObject objectA = new ComplexObject(1, 1);
        ComplexObject objectB = new ComplexObject(0, 1);

        service.divide(objectA, objectB);
    }

    @Test
    public void subtractTest() {
        ComplexObject objectA = new ComplexObject(100, -1);
        ComplexObject objectB = new ComplexObject(10, 1);
        ComplexObject expectedObject = new ComplexObject(90, -2);
        ComplexObject actualObject = service.subtract(objectA, objectB);
        assertEquals(expectedObject, actualObject);
    }

    @Test
    public void multiplyTest() {
        ComplexObject objectA = new ComplexObject(100, -1);
        ComplexObject objectB = new ComplexObject(0, 1);
        ComplexObject expectedObject = new ComplexObject(0, -1);
        ComplexObject actualObject = service.multiply(objectA, objectB);
        assertEquals(expectedObject, actualObject);
    }

    @Test
    public void divideTest() {
        ComplexObject objectA = new ComplexObject(10, -1);
        ComplexObject objectB = new ComplexObject(9, 1);
        ComplexObject expectedObject = new ComplexObject(1, -1);
        ComplexObject actualObject = service.divide(objectA, objectB);
        assertEquals(expectedObject, actualObject);
    }
}

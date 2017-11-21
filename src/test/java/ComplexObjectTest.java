import calculator.domain.ComplexObject;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexObjectTest {

    @Test
    public void hashCodeTest() {
        ComplexObject objectA = new ComplexObject(1, 1);
        int expectedHashCode = 32;
        int actualHashCode = objectA.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void toStringTest() {
        ComplexObject objectA = new ComplexObject(1, 1);
        String expectedValue = "[valueA=1, valueB=1]";
        assertEquals(expectedValue, objectA.toString());
    }
}

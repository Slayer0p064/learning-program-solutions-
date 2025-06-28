package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up Calculator...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }

    @Test
    public void testAdd() {
        int result = calculator.add(10, 5);
        assertEquals(15, result);
        System.out.println("testAdd passed");
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 3);
        assertEquals(7, result);
        System.out.println("testSubtract passed");
    }
}

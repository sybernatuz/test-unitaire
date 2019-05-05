import com.esgi.services.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initCalculator() {
        this.calculator = new Calculator();
    }

    @Test
    public void addTest() {
        assertEquals(5, calculator.add(3, 2));
        assertEquals(-5, calculator.add(-3, -2));
        assertEquals(0, calculator.add(-3, 3));
    }

    @Test
    public void subTest() {
        assertEquals(5, calculator.sub(10, 5));
        assertEquals(5, calculator.sub(0, -5));
        assertEquals(-10, calculator.sub(-5, 5));
        assertEquals(10, calculator.sub(5, -5));
    }

    @Test
    public void mulTest() {
        assertEquals(100, calculator.mul(10, 10));
        assertEquals(0, calculator.mul(0, 5));
        assertEquals(-10, calculator.mul(10, -1));
    }

    @Test
    public void divTest() {
        assertEquals(1.0, calculator.div(10, 10), 1);
        assertEquals(2.5, calculator.div(5, 2), 1);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZeroTest() {
        calculator.div(5, 0);
        Assert.fail("Division by 0");
    }

    @Test
    public void avgTest() {
        int[] list = {1, 2, 3, 4, 5};
        assertEquals(3.0, calculator.avg(list), 1);
    }
}

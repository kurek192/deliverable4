
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The following class includes pinning tests for ProgramStack.java,
 * ProgramExecutor.java, and ProgramArea.java. Specifically, the methods 
 * tested are getOpCode(), toString(), and modulo().
 *
 */
public class PinningTests {

    //
    @Test
    public void getOpCodeTest() {
        ProgramArea pa = new ProgramArea("William");
        assertEquals(pa.getOpCode(0, 5), 'a');
    }

    // Test that a negative value returns char 0
    @Test
    public void getOpCodeNegativeTest() {
        ProgramArea pa = new ProgramArea("William");
        assertEquals(pa.getOpCode(-1, 5), (char) 0);
    }

    // Test that a value that is too high returns char 0
    @Test
    public void getOpCodeBoundsTest() {
        ProgramArea pa = new ProgramArea("William");
        assertEquals(pa.getOpCode(10000, 5), (char) 0);
    }
   
    // Test that an empty stack returns "[]".
    @Test
    public void toStringEmptyTest() {
        ProgramStack stack = new ProgramStack();
        assertTrue(stack.toString().equals("[]"));
    }

    // Test that the stack with one element is represented as a string value
    // correctly
    @Test
    public void toStringTest() {
        ProgramStack stack = new ProgramStack();
        stack.push(100);
        assertTrue(stack.toString().equals("[100]"));

    }

    // Test that a stack with multiple elements is represented as a string value
    // correctly
    @Test
    public void toStringMultipleTest() {
        ProgramStack stack = new ProgramStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertTrue(stack.toString().equals("[1, 2, 3, 4, 5]"));
    }

    public ProgramExecutor executor = null;

   
    //Test that modulo pushes the correct value to the stack
    @Test
    public void moduloTest() {
        ProgramStack stack = new ProgramStack();
        stack.push(1);
        stack.push(2);
        ProgramArea area = new ProgramArea("William");
        MainPanel panel = new MainPanel();
        executor = new ProgramExecutor(panel, stack, area);
        executor.modulo();
        assertEquals(1, executor._ps.peek());
    }
    
    //Test that modulo pushes the correct value to the stack if
    //one of the arguments is zero
    @Test
    public void moduloZeroTest() {
        ProgramStack stack = new ProgramStack();
        stack.push(0);
        stack.push(1);
        ProgramArea area = new ProgramArea("William");
        MainPanel panel = new MainPanel();
        executor = new ProgramExecutor(panel, stack, area);
        executor.modulo();
        assertEquals(0, executor._ps.peek());
    }
    
    //Test that modulo pushes the correct value to the stack
    //if the values are edge cases
    @Test
    public void moduloBoundsTest() {
        ProgramStack stack = new ProgramStack();
        stack.push(10000);
        stack.push(20000);
        ProgramArea area = new ProgramArea("William");
        MainPanel panel = new MainPanel();
        executor = new ProgramExecutor(panel, stack, area);
        executor.modulo();
        assertEquals(10000, executor._ps.peek());
    }

}

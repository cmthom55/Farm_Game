import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void testHelloWorld() {
        // Create an instance of the Main class
        Main mainInstance = new Main();

        // Call the method to be tested
        String result = mainInstance.helloWorld();

        // Verify the result
        assertEquals("Hello, World!", result);
    }
}
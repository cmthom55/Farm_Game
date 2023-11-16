import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void testHelloWorld() {
        // Redirect System.out to capture the printed output
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Main.helloWorld();

        // Reset System.out to the original PrintStream
        System.setOut(System.out);

        // Verify the printed output
        assertEquals("Hello, World!\n\n", outputStream.toString());
    }
}
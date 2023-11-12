import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testHelloWorld() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.helloWorld();

        System.setOut(System.out);

        assertEquals("Hello, World!\n", outContent.toString());
    }
}

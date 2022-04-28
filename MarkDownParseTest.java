import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;



public class MarkdownParseTest {
    @Test
    public void addition(){
        assertEquals(2,1+1);
    }

    @Test
    public void MDTestFile1() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of("https://something.com, some-thing.html"));
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("test-file.md")));
        assertEquals(expected,resultArray);
    
    }
}

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
        
    }
    @Test
    public void testgetLink(){
        try {
            Path fileName = Path.of("test-file.md");
        
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        String LinkS=links.toString();
        assertEquals("The website should be printed out correctly","[https://something.com, some-thing.html]", LinkS);

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
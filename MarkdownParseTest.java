import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;


public class MarkdownParseTest {

    @Test
    public void addition(){
        assertEquals(2,1+1);
    }

    @Test
    public void testgetLinks() throws IOException {
        ArrayList<String> toReturn = new ArrayList<>();
        toReturn.add("https://something.com");
        toReturn.add("some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(toReturn, MarkdownParse.getLinks(content));
    }
    @Test
    public void test1getLinks() throws IOException {
        ArrayList<String> toReturn = new ArrayList<>();
        toReturn.add("somethingtem t.com");
        Path fileName = Path.of("test-file1.md");
        String content = Files.readString(fileName);
        assertEquals(toReturn, MarkdownParse.getLinks(content));
    }
    @Test
    public void test2getLinks() throws IOException {
        ArrayList<String> toReturn = new ArrayList<>();
        toReturn.add("somethingting.com");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        assertEquals(toReturn, MarkdownParse.getLinks(content));
    }
    @Test
    public void test3getLinks() throws IOException {
        ArrayList<String> toReturn = new ArrayList<>();
        toReturn.add(" ");
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        assertEquals(toReturn, MarkdownParse.getLinks(content));
    }
}

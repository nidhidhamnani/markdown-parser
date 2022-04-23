import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;



import org.junit.*;
public class MarkdownParseTest{
    public MarkdownParse mp = new MarkdownParse();
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test

    public void testParse() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
    
        ArrayList<String> links = mp.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }
    @Test
    public void testParse2() throws IOException{
        Path fileName = Path.of("test-file-for-error.md");
        String content = Files.readString(fileName);
    
        ArrayList<String> links = mp.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }
    @Test
    public void testParse3() throws IOException{
        Path fileName = Path.of("test-file-for-error-copy.md");
        String content = Files.readString(fileName);
    
        ArrayList<String> links = mp.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html", "some-thing.html", "some-thing.html"), links);
    }
    @Test
    public void testParse4() throws IOException{
        Path fileName = Path.of("test-file-for-error-copy-2.md");
        String content = Files.readString(fileName);
    
        ArrayList<String> links = mp.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html", "https://something.com", "https://something.com"), links);
    }
}
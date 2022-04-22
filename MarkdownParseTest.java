import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testFile() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void testFile2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void testFile3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html", "something.html"), links);
    }

    @Test
    public void testFile4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }
}

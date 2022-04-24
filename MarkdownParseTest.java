import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-thing.html"),MarkdownParse.getLinks(content));
    }

    @Test
    public void break1() throws IOException{
        Path fileName = Path.of("breaking-test.md");
        String content = Files.readString(fileName);
        assertEquals(List.of(),MarkdownParse.getLinks(content));
    }

    @Test
    public void break2() throws IOException{
        Path fileName = Path.of("breaking-test-2.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("link1", "link2"),MarkdownParse.getLinks(content));
    }

    @Test
    public void break3() throws IOException{
        Path fileName = Path.of("breaking-test-3.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-thing.html"),MarkdownParse.getLinks(content));
    }
}
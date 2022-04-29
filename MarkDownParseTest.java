import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void markdownTest() throws Exception {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest2() throws Exception {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest3() throws Exception {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest4() throws Exception {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest5() throws Exception {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest6() throws Exception {
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest7() throws Exception {
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a link on the first line");
        assertEquals(expected, links);
    }
}

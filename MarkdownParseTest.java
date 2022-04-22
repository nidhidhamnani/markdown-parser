
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    // @Test
    // public void markdownParseTest1() throws IOException {
    //     Path fileName = Path.of("test-file.md");

    //     List<String> expected = List.of("[https://something.com, some-page.html, google.com]");
    //     List<String> got = MarkdownParse.getLinks("test-file.md");
    //     // System.out.println(expected);
    //     // System.out.println(got);
    //     assertEquals(expected, got);
    // }

    @Test 
    public void test1() throws IOException{
        //MarkdownParse md = new MarkdownParse();
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        List<String> expected = MarkdownParse.getLinks(content);
        // System.out.println(links);
        //ArrayList<String> expec = md.getLink(Files.readString("test-file.md"));
        List<String> got = List.of("https://something.com", "some-page.html");
        // System.out.print(links);
        assertEquals(got, expected);
    }
}
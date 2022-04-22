import static org.junit.Assert.*;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest1() {
        // test-file.md
        String markdown = "# Title\n\n[link1](https://something.com)\n[link2](some-thing.html)";
        List<String> expectedLinks = List.of("https://something.com", "some-thing.html");
        assertEquals(expectedLinks, MarkdownParse.getLinks(markdown));
    }

    @Test
    public void getLinksTest2() {
        // test-file2.md
        String markdown = "# title\n\n[link1](";
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(markdown));
    }

    @Test
    public void getLinksTest3() {
        // test-file3.md
        String markdown = "# Title\n[Reference style link][1]\n[1]: https://referencelink.php\n[link1](https://something.com)\n[link2](some-thing.html)\n![image1](cat.png)";
        List<String> expectedLinks = List.of("https://something.com", "some-thing.html", "cat.png");
        assertEquals(expectedLinks, MarkdownParse.getLinks(markdown));
    }

    @Test
    public void getLinksTest4() {
        // test-file4.md
        String markdown = "# title\n\n[link(";
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(markdown));
    }
}
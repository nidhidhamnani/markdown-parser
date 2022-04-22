
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void markdownParseTest1() {
        List<String> expected = List.of("[https://something.com, some-page.html, google.com]");
        List<String> got = MarkdownParse.getLinks("test-file.md");
        // System.out.println(expected);
        // System.out.println(got);
        assertEquals(expected, got);
    }
}
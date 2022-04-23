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
    public void getLinksTest() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        Path fileName = Path.of("C:/GitHub/cse15l-lab-reports/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        System.out.println(content);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    System.out.println(links);
        assertEquals(expected, links);
    }

}
// import the set of assertEquals
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// import JUnit core classes and annotations
import org.junit.*;

public class MarkdownParseTest {
    // “@Test” is an annotation to declare that the class below this part is a test.
    @Test
    public void addition() {
        // “assertEquals()” has two arguments. Will pass if the first arguement 
        // is equal to the second
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testParse() throws IOException {
        List<String> exp = List.of("https://something.com", "some-thing.html");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testImage() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/markdown-parser/testImage.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testParen() throws IOException {
        List<String> exp = List.of("https://angeliazddl.github.io/markdown-parser/");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/markdown-parser/testParen.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testBracket() throws IOException {
        List<String> exp = List.of("https://angeliazddl.github.io/markdown-parser/");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/markdown-parser/testBracket.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

}
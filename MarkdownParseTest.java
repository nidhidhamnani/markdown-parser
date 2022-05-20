import static org.junit.Assert.*;
import org.junit.*;

import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" *.java
// java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of("https://something.com", "some-thing.html");
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }
/*
    @Test
    public void getLinksTest2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksMyTest() throws IOException {
        Path fileName = Path.of("mytest.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    } */
}
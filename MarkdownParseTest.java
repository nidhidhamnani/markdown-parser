import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
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

    // more tests Part 6 lab 4
    @Test
    public void getLinksTest4() throws IOException {
        Path fileName = Path.of("lab-test-file2.md");
        String content = Files.readString(fileName);        
        List<String> expectedLinks = List.of("https://something.com", "some-page.html");
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }
    
    @Test
    public void getLinksTest5() throws IOException {
        Path fileName = Path.of("lab-test-file3.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest6() throws IOException {
        Path fileName = Path.of("lab-test-file4.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest7() throws IOException {
        Path fileName = Path.of("lab-test-file5.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest8() throws IOException {
        Path fileName = Path.of("lab-test-file6.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of("page.com");
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest9() throws IOException {
        Path fileName = Path.of("lab-test-file7.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest10() throws IOException {
        Path fileName = Path.of("lab-test-file8.md");
        String content = Files.readString(fileName);
        List<String> expectedLinks = List.of("a link on the first line");
        assertEquals(expectedLinks, MarkdownParse.getLinks(content));
    }
}
import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// Compile: javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
// Run: java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

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
        expected.add("some-thing.htmLsdff");
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest1() throws Exception {
        Path fileName = Path.of("test-file-1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
         expected.add("https://www.youtube.com/");
          expected.add("https://www.akpsiucsd.com/about");
           expected.add("https://mail.google.com/mail/u/0/#inbox");
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest2() throws Exception {
        Path fileName = Path.of("test-file-2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void markdownTest3() throws Exception {
        Path fileName = Path.of("test-file-3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://www.akpsiucsd.com/about");
        assertEquals(expected, links);
    }

    // @Test
    // public void markdownTest4() throws Exception {
    //     Path fileName = Path.of("test-file4.md");
    //     String content = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(content);
    //     ArrayList<String> expected = new ArrayList<String>();
    //     assertEquals(expected, links);
    // }

    // @Test
    // public void markdownTest5() throws Exception {
    //     Path fileName = Path.of("test-file5.md");
    //     String content = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(content);
    //     ArrayList<String> expected = new ArrayList<String>();
    //     assertEquals(expected, links);
    // }

    // @Test
    // public void markdownTest6() throws Exception {
    //     Path fileName = Path.of("test-file6.md");
    //     String content = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(content);
    //     ArrayList<String> expected = new ArrayList<String>();
    //     assertEquals(expected, links);
    // }

    // @Test
    // public void markdownTest7() throws Exception {
    //     Path fileName = Path.of("test-file7.md");
    //     String content = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(content);
    //     ArrayList<String> expected = new ArrayList<String>();
    //     expected.add("a link on the first line");
    //     assertEquals(expected, links);
    // }
}

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }
    @Test
    public void testgetLinks() throws IOException {
        String filename = "test-file.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks2() throws IOException {
        String filename = "test-file1.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks3() throws IOException {
        String filename = "test-file2.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks4() throws IOException {
        String filename = "test-file3.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks5() throws IOException {
        String filename = "test-file4.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
}

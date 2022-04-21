import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {

    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks1() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("test-file.md"))));
    }
    
    @Test
    public void testGetLinks2() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("test-file-break1.md"))));
    }

    @Test
    public void testGetLinks3() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("test-file-break2.md"))));
    }

    @Test
    public void testGetLinks4() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("test-file-break3.md"))));
    }

    @Test
    public void testGetLinks5() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("hello.com");
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("test-file-break4.md"))));
    }
}
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


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
    public void MarkdownParseTest() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of("https://something.com", "some-thing.html"));
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("test-file.md")));
        assertEquals(expected, resultArray);
    }

    @Test
    public void MarkdownParseTest2() throws IOException{
        ArrayList<String> expected = new ArrayList<>();
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("break-file.md")));
        assertEquals(expected, resultArray);
    }

    @Test
    public void MarkdownParseTest3() throws IOException{
        ArrayList<String> expected = new ArrayList<>();
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("break-file2.md")));
        assertEquals(expected, resultArray);
    }

    @Test
    public void MarkdownParseTest4() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of("someLink.com"));
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("break-file3.md")));
        assertEquals(expected, resultArray);
    }

    @Test
    public void MarkdownParseTest5() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of("https://something.com", "some-page.html"));
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("test-file2.md")));
        assertEquals(expected, resultArray);
    }

    @Test
    public void MarkdownParseTest6() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of());
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("test-file3.md")));
        assertEquals(expected, resultArray);
    }

    @Test
    public void MarkdownParseTest7() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of());
        MarkdownParse mp = new MarkdownParse();
        ArrayList<String> resultArray = mp.getLinks(Files.readString(Path.of("test-file3.md")));
        assertEquals(expected, resultArray);
    }

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

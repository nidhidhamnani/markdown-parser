import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest{

    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("/Users/aliceli/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>(); 
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks2() throws IOException{
        Path fileName = Path.of("/Users/aliceli/Documents/GitHub/markdown-parser/test-file-2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>(); 
        expected.add("a-");
        expected.add("https://minesweeperonline.com/#200");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks3() throws IOException{
        Path fileName = Path.of("/Users/aliceli/Documents/GitHub/markdown-parser/test-file-3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks4() throws IOException{
        Path fileName = Path.of("/Users/aliceli/Documents/GitHub/markdown-parser/test-file-4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://minesweeperonline.com/#200");
        assertEquals(expected, links);
    }
}

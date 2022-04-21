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
   public void testProvidedTestFile() throws IOException {
      Path fileName = Path.of("C:/Users/Helen/Desktop/CSE15L/markdown-parser/test-file.md");
      String content = Files.readString(fileName);
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {"https://something.com", "some-thing.html"};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testTest2File() throws IOException {
      Path fileName = Path.of("C:/Users/Helen/Desktop/CSE15L/markdown-parser/test2.md");
      String content = Files.readString(fileName);
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[0];
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testTestNoLink() throws IOException {
      Path fileName = Path.of("C:/Users/Helen/Desktop/CSE15L/markdown-parser/testNoLink.md");
      String content = Files.readString(fileName);
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[0];
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testTestImageAndLink() throws IOException {
      Path fileName = Path.of("C:/Users/Helen/Desktop/CSE15L/markdown-parser/testImageAndLink.md");
      String content = Files.readString(fileName);
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {"shouldbeidentified.com"};
      assertArrayEquals(expected, links.toArray());
   }
}
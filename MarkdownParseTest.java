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

   public String readFile(String file) throws IOException {
      String fullPath = "C:/Users/Helen/Desktop/CSE15L/markdown-parser/" + file;
      Path fileName = Path.of(fullPath);
      String content = Files.readString(fileName);
      return content;  
   }

   @Test
   public void testProvidedTestFile() throws IOException {
      String content = readFile("test-file.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {"https://something.com", "some-thing.html"};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testTest2File() throws IOException {
      String content = readFile("test2.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[0];
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testTestNoLink() throws IOException {
      String content = readFile("testNoLink.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[0];
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testTestImageAndLink() throws IOException {
      String content = readFile("testImageAndLink.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {"shouldbeidentified.com"};
      assertArrayEquals(expected, links.toArray());
   }
}
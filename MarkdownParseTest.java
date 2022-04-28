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
      String fullPath = file;
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

   @Test
   public void testProvidedTestFile2() throws IOException {
      String content = readFile("test-file2.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {"https://something.com", "some-page.html"};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestFile3() throws IOException {
      String content = readFile("test-file3.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestFile4() throws IOException {
      String content = readFile("test-file4.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestFile5() throws IOException {
      String content = readFile("test-file5.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestFile6() throws IOException {
      String content = readFile("test-file6.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestFile7() throws IOException {
      String content = readFile("test-file7.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestFile8() throws IOException {
      String content = readFile("test-file8.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }

   @Test
   public void testProvidedTestEmptyParen() throws IOException {
      String content = readFile("testNoLinkInParen.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
   }
   @Test
      public void testProvidedTest9() throws IOException {
      String content = readFile("test-file9.md");
      ArrayList<String> links = MarkdownParse.getLinks(content);
      String[] expected = new String[] {};
      assertArrayEquals(expected, links.toArray());
}

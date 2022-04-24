//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.sound.sampled.LineListener;

/**
 * Fork of MarkdownParse by Nidhi Dhamnani
 * Forked by Conrado Martinez
 * 
 * This fork addresses some bugs I noticed from 
 * the original implementation. 
 * Specifically, this forked version: 
 * 1) Fixes the bug that would cause an infinite 
 *    loop if the last line of the markdown file 
 *    was blank. 
 * 2) Filters out images (which use the ![Image] tag option)
 * 3) Filters out text that is not a link (text in parenthesis w/o 
 *    [http:, https:, www.] will be ignored)
 * 
 * these behaviors are tested in the newly added test file 
 * my-test.md
 */
public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int openBracket;
        while(currentIndex < markdown.length()) {
		
            // Handles edge case where an image tag contains the last open bracket
            if (currentIndex == -1) {
                break;
            }
            // Fix for infinite loop caused by empty last line
            if (currentIndex + 1 == markdown.length() && markdown.charAt(currentIndex) == '\n'){
                break;
            }

            openBracket = markdown.indexOf("[", currentIndex);
            // Check for ! to determine if the item is a non-link tag
            if (openBracket != 0 && markdown.charAt(openBracket - 1) == '!') {
                currentIndex = markdown.indexOf('[', openBracket + 1);
                continue;
            }

            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // Filtering out non-link uses of tags
            String linkToAdd = markdown.substring(openParen + 1, closeParen);
            if (linkToAdd.substring(0, 6).equalsIgnoreCase("HTTPS:") ||
                linkToAdd.substring(0, 5).equalsIgnoreCase("HTTP:") ||
                linkToAdd.substring(0, 4).equalsIgnoreCase("www.")) {
                    toReturn.add(markdown.substring(openParen + 1, closeParen).toLowerCase());
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

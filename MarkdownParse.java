//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // : was used to reference a link instead of ()
            if (markdown.charAt(closeBracket + 1) == ':') {
                int escape = markdown.indexOf("\r\n", closeBracket + 3);
                int space = markdown.indexOf(" ", closeBracket + 3);
                String link = "";
                if (space > escape || space == -1) {
                    link = markdown.substring(closeBracket + 3, escape);
                    currentIndex = escape + 1;
                }
                else {
                    link = markdown.substring(closeBracket + 3, space);
                    currentIndex = space + 1;
                }        
                toReturn.add(link);
            }
            if (markdown.charAt(closeBracket + 1) != '(') {
                currentIndex = markdown.indexOf("[", closeBracket + 1);
            }

            // no link
            if (openBracket == -1 || closeBracket == -1 ||
                openParen == -1 || closeParen == -1) {
                return toReturn;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
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

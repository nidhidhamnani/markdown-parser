

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )

        int currentIndex = 0;
        // System.out.println(currentIndex);
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            // int openParen = markdown.indexOf("(", currentIndex);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1) {
                currentIndex = markdown.length();
                break; // prevents infinite loop
            } else if (closeBracket + 1 == openParen && openBracket != -1) {
                if (markdown.indexOf("\n", openBracket) < closeParen) {
                    currentIndex = closeParen;
                } else if (markdown.charAt(openBracket - 1) == '!') {
                    currentIndex = closeParen + 1; 
                } else {
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                }
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            // System.out.println(currentIndex);
        }
        // System.out.println(toReturn) ;
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

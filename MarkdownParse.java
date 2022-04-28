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

            int openBrackPrevIndex = openBracket-1;
            // System.out.println(markdown.substring(openParen + 1, closeParen));
            // check if escape character
            if (openBracket == -1 || closeBracket ==-1 || openParen == -1 || closeParen == -1){
                break;
            }

            if (openBrackPrevIndex >=0 && (
            markdown.substring(openBrackPrevIndex, openBracket).equals("!") || markdown.substring(openBrackPrevIndex, openBracket).equals("\\"))) {
                // System.out.println("image");
                // Math.max(openBracket,closeBracket, openParen,closePare/n);
            }
            else if (openBracket+1 == closeBracket) {}
            else if (openParen + 1 == closeParen) {}
            else if (openBracket == 0) {
                System.out.println("zero");
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            else if (closeBracket + 1 == openParen) {
                // System.out.println("]( next to eachother");
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            // Cases gets triggered falsly. ONe is that it might trigger another case while it isn't a link. Faulty
            currentIndex = closeParen + 1;
            // System.out.println(currentIndex);
        }
        System.out.println(toReturn.toString());
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

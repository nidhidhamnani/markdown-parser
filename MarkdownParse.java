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
        
        if(markdown.indexOf("[", currentIndex) == -1 || markdown.indexOf("]", currentIndex) == -1 
            || markdown.indexOf("(", currentIndex) == -1 || markdown.indexOf(")", currentIndex) == -1){
            return toReturn;
        }
        while(currentIndex < markdown.length()) {
            if(markdown.indexOf("!", currentIndex) != -1){
                int exclamation = markdown.indexOf("!", currentIndex);
                
                int openBracket = markdown.indexOf("[", exclamation);
            if(exclamation == openBracket - 1){
                break;
            }
            }
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            if(closeBracket + 1 != openParen){
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if((closeParen + 1) < currentIndex) {
                break;
            }
            if(closeBracket < openBracket){
                break;
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
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

            if (markdown.indexOf("(") == -1 && markdown.indexOf(")") == -1 && markdown.indexOf("[") == -1 && markdown.indexOf("]") == -1){
                if (markdown.indexOf("#") == 0){
                    toReturn.add("");
                    return toReturn;
                }
                toReturn.add(markdown);
                return toReturn;
            }
            //new comment haha
            if (markdown.indexOf("(") == -1 && markdown.indexOf(")") == -1){
                toReturn.add("");
                return toReturn;
            }

            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (markdown.indexOf(")", closeParen+1) != -1 && markdown.indexOf(")", closeParen+1) < markdown.indexOf("[", closeParen+1)){
                closeParen = markdown.indexOf(")", closeParen+1);
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1; //0, 0, 30, 24
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

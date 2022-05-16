// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkdownParse {

    static int findCloseParen(String markdown, int openParen) {
        int closeParen = openParen + 1;
        int openParenCount = 1;
        int lastCloseParenIndex = markdown.indexOf(")", openParen);
        while (openParenCount > 0) {
            if (markdown.charAt(closeParen) == '(') {
                openParenCount++;
            } else if (markdown.charAt(closeParen) == ')') {
                openParenCount--;
                lastCloseParenIndex = closeParen;
            }
            closeParen++;
        }
        return lastCloseParenIndex;
    }
    public static Map<String, List<String>> getLinks(File directory) throws IOException {
        Map<String, List<String>> result = new HashMap<>();
        if(directory.isDirectory()) {
            for(File f: directory.listFiles()) {
                result.putAll(getLinks(f));
            }
            return result;
        }
        else {
            Path p = directory.toPath();
            int lastDot = p.toString().lastIndexOf(".");
            if(lastDot == -1 || !p.toString().substring(lastDot).equals(".md")) {
                return null;
            }
            ArrayList<String> links = getLinks(Files.readString(p));
            result.put(directory.getPath(), links);
            return result;
        }
    }

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCodeBlock = markdown.indexOf(System.lineSeparator() + "```");
            if(nextCodeBlock < nextOpenBracket && nextCodeBlock!=-1 ) {
                int endOfCodeBlock = markdown.indexOf(System.lineSeparator() + "```");
                currentIndex = endOfCodeBlock + 1;
                continue;
            }

            // System.out.format("%d\t%d\t%s\n", currentIndex, nextOpenBracket, toReturn);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);

            // The close paren we need may not be the next one in the file
            // Track opening parens and find matching close paren
            int closeParen = findCloseParen(markdown, openParen);
            
            if(nextOpenBracket == -1 || nextCloseBracket == -1
                  || closeParen == -1 || openParen == -1) {
                return toReturn;
            }
            if(nextOpenBracket!=0 && markdown.charAt(nextOpenBracket-1)=='!'){
                currentIndex = closeParen + 1;
                continue;
            }
            if(nextCloseBracket != openParen-1){
                currentIndex = closeParen + 1;
                continue;
            }
            String potentialLink = markdown.substring(openParen + 1, closeParen).trim();
            if(potentialLink.indexOf(" ") == -1 && potentialLink.indexOf("\n") == -1) {
                toReturn.add(potentialLink);
                currentIndex = closeParen + 1;
            }
            else {
                currentIndex = currentIndex + 1;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
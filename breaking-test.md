# Breaking test

Exception in thread "main" java.lang.StringIndexOutOfBoundsException: begin 0, end -1, length 20
        at java.base/java.lang.String.checkBoundsBeginEnd(String.java:4601)
        at java.base/java.lang.String.substring(String.java:2704)
        at MarkdownParse.getLinks(MarkdownParse.java:19)
        at MarkdownParse.main(MarkdownParse.java:30)
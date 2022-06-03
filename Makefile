CLASSPATH = lib\*;.

TryCommonMark.class: TryCommonMark.java
	javac -g -cp "$(CLASSPATH)" TryCommonMark.java

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java

Run: MarkdownParseTest.class
	java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
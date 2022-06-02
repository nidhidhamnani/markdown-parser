CLASSPATH = lib/*:.
MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java
MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
Test: MarkdownParseTest.class MarkdownParse.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java

TestTryCommonMark : TryCommonMark.class
	java -cp lib/*:. TryCommonMark
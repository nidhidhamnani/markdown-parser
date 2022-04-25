# First Code Changes
## Screenshot of the code change

## Link to the test file
[testImage](https://angeliazddl.github.io/markdown-parser/testImage.html)
## The Symptom
Expect output:
`[https://www.google.com/?client=safari, https://github.com/AngeliaZddl/markdown-parser, https://angeliazddl.github.io/markdown-parser/]`
Actual output before make changes:
`[https://www.google.com/?client=safari, https://github.com/AngeliaZddl/markdown-parser, sunset.jpg, https://angeliazddl.github.io/markdown-parser/]`
## Description
Before the change, the code cannot test the image while it's in the test file. The image is not a link so we are supposed to not show it in the output. I add a if condition to check if targeted links are iamges.

# Second Code Changes
## Screenshot of the code change

## Link to the test file
[testParen](https://angeliazddl.github.io/markdown-parser/testParen.html)
## The Symptom
Expect output:
`[https://angeliazddl.github.io/markdown-parser/]`
Actual output:
`[, https://angeliazddl.github.io/markdown-parser/]`
## Description
Before the change, the code cannot skip the empty links so I add a if condition to check if the link is empty with nothing in parens.

# Third Code Changes
## Screenshot of the code change

## Link to the test file
[testBracket](https://angeliazddl.github.io/markdown-parser/testBracket.html)
## The Symptom
Expect output:
`[https://angeliazddl.github.io/markdown-parser/]`
Actual output:
```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Range [0, -1) out of bounds for length 66
        at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
        at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
        at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
        at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
        at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
        at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckFromToIndex(Preconditions.java:112)
        at java.base/jdk.internal.util.Preconditions.checkFromToIndex(Preconditions.java:349)
        at java.base/java.lang.String.checkBoundsBeginEnd(String.java:4589)
        at java.base/java.lang.String.substring(String.java:2703)
        at MarkdownParse.getLinks(MarkdownParse.java:21)
        at MarkdownParse.main(MarkdownParse.java:33)
```
## Description
Before the change, the code cannot run if the link is in a pair of brackets. However the link in a pair of brackets is alse a link so we are supposed to return it in the output. To fix this symptom, 

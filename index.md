# First Code Changes
### Screenshot of the code change

### Link to the test file

[testImage](https://angeliazddl.github.io/markdown-parser/testImage.html)

### The Symptom

Expect output:

`[]`

Actual output before make changes:

`[sunset.jpg]`

### Description

Before the change, the code cannot test the image while it's in the test file. The image is not a link so we are supposed to not show it in the output. I add a if condition to check if the targeted link is an iamge.

# Second Code Changes
### Screenshot of the code change

### Link to the test file

[testParen](https://angeliazddl.github.io/markdown-parser/testParen.html)

### The Symptom
Expect output:

`[https://angeliazddl.github.io/markdown-parser/]`

Actual output:

`[, https://angeliazddl.github.io/markdown-parser/]`

### Description

Before the change, the code cannot skip the empty links so I add a if condition to check if the link is empty with nothing in parens.

# Third Code Changes
### Screenshot of the code change

### Link to the test file

[testBracket](https://angeliazddl.github.io/markdown-parser/testBracket.html)

### The Symptom

Expect output:

`[https://angeliazddl.github.io/markdown-parser/]`

Actual output:

```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.base/java.lang.StringLatin1.newString(StringLatin1.java:766)
        at java.base/java.lang.String.substring(String.java:2708)
        at MarkdownParse.getLinks(MarkdownParse.java:19)
        at MarkdownParse.main(MarkdownParse.java:30)
```

### Description

Before the change, the code cannot run if the link is in a pair of brackets. However the link in a pair of brackets is alse a link so we are supposed to return it in the output. To fix this symptom, 

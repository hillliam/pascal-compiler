# Pascal Compiler

Liam Hill
---------

### Progress

| Constructs      | XML         | JavaScript  |
| --------------- |:-----------:|:-----------:|
| program         | Done        | Done        |
| program heading | Done        | Done        |
| block           | Done        | Done        |
| Variable         | Done        | Done        |
| constant        | Done        | Done        |
| array           | Done        | Done        |
| set             | Done        | Done        |
| if              | Done        | Done        |
| while           | Done        | Done        |
| with            | not-possible| not-possible|
| for             | Done        | Done        |
| repeat          | Done        | Done        |
| function        | Done        | Done        |
| procedure       | Done        | Done        |
| Statement       | Done        | Done        |
| Assignment      | Done        | Done        |
| Label           | Done        | not-possible|
| goto            | Done        | not-possible|
| case            | Done        | In-progress |

### edit to grammar

#### adding case insensitivity

* Pascal is a case insensitive language
* added lowercase version of every word in the language
* improving the range of programs you can test without editing them
* all JavaScript output is converted to lowercase preventing variable mismatch

#### optional end DOT

* the dot at the end of a Pascal program is optional

#### dynamic variables

* because JavaScript is a dynamically typed language allow variable declaration to not need a data type

#### removal of parts of the language

* pointerType not supported in JavaScript
* fileType not supported in JavaScript

### Building

1. generate antlr files by running `../antlr.bat pascal.g4 -listener -package pascal -o pascal`
2. compile the java classes by running  `../javac.bat pascal\*.java`

### How to use

#### Walking the tree

* to display the tree path walked run the command `../java.bat pascal.pascal file.pascal -path`.
* adding `-path` to the end of the command.
* adding 1 to the end will add the contence of each part pf the tree to the output

#### Exporting to XML

* to display the tree path walked run the command `../java.bat pascal.pascal file.pascal -XML`.
* adding `-XML` to the end of the command.

#### Converting to Javascript

* to convert the tree to JavaScript run the command `../java.bat pascal.pascal file.pascal`

#### Searching file

* to  the tree path walked run the command `../java.bat pascal.pascal file.pascal -search if while`.
* adding `-search` to the end of the command.
* the search items must be separated by a space

#### tree display form

* adding `-gui` will display the tree on a GUI
* clicking a part of the tree will open that subtree in a new window

### testing System

* the batch script `br.bat` can be used to test the compiler to see if it is working
* this can be easily updated as new programs are added to test
* this script will build the program and run a collection of automated test generating javascript and xml of files in the folder
* the script also tests the search component of the compiler
